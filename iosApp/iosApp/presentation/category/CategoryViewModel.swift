//
//  CategoryViewModel.swift
//  iosApp
//
//  Created by Muaz KADAN on 24.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

extension CategoryScreen {
    @MainActor class CategoryViewModel: ObservableObject {
        @Published var categoriesList = [CategoryModel]()
        init() {
            CategoryHelper().getCategories { categories, error in
                DispatchQueue.main.async {
                    if let categories = categories {
                        self.categoriesList = categories
                    }
                }
            }
        }
    }
}
