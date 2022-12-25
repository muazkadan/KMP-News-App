//
//  CategoryCard.swift
//  iosApp
//
//  Created by Muaz KADAN on 25.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CategoryCard: View {
    let category: CategoryModel
    var body: some View {
        VStack {
            NavigationLink(destination: NewsScreen(viewModel: NewsScreen.NewsViewModel() , categoryModel: category)){
                Text(category.name)
                    .font(.headline)
                    .foregroundColor(.black)
            }
        }
        .frame(width: 135, height: 60)
        .padding()
        .background(Color.white)
        .cornerRadius(8)
        .shadow(radius: 8)
    }
}

struct CategoryCard_Previews: PreviewProvider {
    static var previews: some View {
        CategoryCard(category: CategoryModel(name: "Sport", value: "")) 
    }
}
