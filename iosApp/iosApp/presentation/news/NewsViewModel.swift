//
//  NewsViewModel.swift
//  iosApp
//
//  Created by Muaz KADAN on 25.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

extension NewsScreen{
    @MainActor class NewsViewModel: ObservableObject {
        @Published var isLoading = true
        @Published var newsList: [NewsModel]
        @Published var errorMessage: String? = nil
        
        init() {
            newsList = [NewsModel]()
        }
        
        func getNews(category: String){
            NewsHelper().getNews(category: category) { newsList, err in
                DispatchQueue.main.async {
                    if let newsList = newsList {
                        self.newsList = newsList
                        self.isLoading = false
                        print(newsList)
                    }
                    if let err = err {
                        self.errorMessage = err.localizedDescription
                        self.isLoading = false
                        print(err.localizedDescription)
                    }
                }
            }

        }
    }
}
