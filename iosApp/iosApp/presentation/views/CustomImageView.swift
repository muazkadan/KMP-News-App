//
//  CustomImageView.swift
//  iosApp
//
//  Created by Muaz KADAN on 25.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//
// source: https://stackoverflow.com/a/68989047/4417463

import SwiftUI

struct CustomImageView: View {
    var urlString: String
    @ObservedObject var imageLoader = ImageLoaderService()
    @State var image: UIImage = UIImage()
    
    var body: some View {
        Image(uiImage: image)
            .resizable()
            .aspectRatio(contentMode: .fit)
            .onReceive(imageLoader.$image) { image in
                self.image = image
            }
            .onAppear {
                imageLoader.loadImage(for: urlString)
            }
    }
}

class ImageLoaderService: ObservableObject {
    @Published var image: UIImage = UIImage()
    
    func loadImage(for urlString: String) {
        guard let url = URL(string: urlString) else { return }
        
        let task = URLSession.shared.dataTask(with: url) { data, response, error in
            guard let data = data else { return }
            DispatchQueue.main.async {
                self.image = UIImage(data: data) ?? UIImage()
            }
        }
        task.resume()
    }
    
}

struct CustomImageView_Previews: PreviewProvider {
    static var previews: some View {
        CustomImageView(urlString: "https://downloads.ti.com/mctools/esd/docs/tidl-api/_images/cat-pet-animal-domestic-104827.jpeg")
    }
}
