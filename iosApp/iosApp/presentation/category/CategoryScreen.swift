//
//  CategoryScreen.swift
//  iosApp
//
//  Created by Muaz KADAN on 24.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CategoryScreen: View {
    @ObservedObject private(set) var viewModel: CategoryViewModel
    
    var body: some View {
        ScrollView {
            LazyVGrid(columns: [GridItem(.adaptive(minimum: 125))]) {
                ForEach(viewModel.categoriesList, id: \.self){ category in
                    CardView(category: category)
                }
            }
            .padding()
        }
    }
}

struct CardView: View {
    let category: CategoryModel
    var body: some View {
        VStack {
            Text(category.name)
                .font(.headline)
        }
        .frame(width: 135, height: 50)
        .padding()
        .background(Color.white)
        .cornerRadius(8)
        .shadow(radius: 8)
    }
}

struct CategoryScreen_Previews: PreviewProvider {
    static var previews: some View {
        CategoryScreen(viewModel: CategoryScreen.CategoryViewModel())
    }
}

