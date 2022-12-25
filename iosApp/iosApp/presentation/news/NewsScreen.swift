//
//  NewsScreen.swift
//  iosApp
//
//  Created by Muaz KADAN on 25.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsScreen: View {
    @ObservedObject private(set) var viewModel: NewsViewModel
    var categoryModel: CategoryModel
    
    init(viewModel: NewsViewModel, categoryModel: CategoryModel) {
        self.viewModel = viewModel
        self.categoryModel = categoryModel
        viewModel.getNews(category: categoryModel.value)
    }

    var body: some View {
        
        if(viewModel.isLoading){
            ActivityIndicator().frame(width: 75, height: 75)
        }else {
            ScrollView {
                LazyVStack {
                    ForEach(viewModel.newsList, id: \.self){ newsModel in
                        NewsCard(newsModel: newsModel)
                    }
                }
                .padding()
           
            }
            .frame(maxWidth:.infinity,maxHeight:.infinity,alignment:.topLeading)
            .navigationTitle(categoryModel.name)
            .navigationBarTitleDisplayMode(.inline)
        }
    }
}

struct NewsScreen_Previews: PreviewProvider {
    static var previews: some View {
        NewsScreen(viewModel:    NewsScreen.NewsViewModel(), categoryModel: CategoryModel(name: "Test", value: "Test"))
    }
}
