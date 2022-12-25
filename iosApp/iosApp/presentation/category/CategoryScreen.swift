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
        NavigationView{
            if(viewModel.isLoading){
                ActivityIndicator().frame(width: 75, height: 75)
            }else {
                ScrollView {
                    LazyVGrid(columns: [GridItem(.adaptive(minimum: 125))]) {
                        ForEach(viewModel.categoriesList, id: \.self){ category in
                            CategoryCard(category: category)
                        }
                    }
                    .padding()
                }
                .navigationTitle("News App")
            }
        }
    }
}

struct CategoryScreen_Previews: PreviewProvider {
    static var previews: some View {
        CategoryScreen(viewModel: CategoryScreen.CategoryViewModel())
    }
}

