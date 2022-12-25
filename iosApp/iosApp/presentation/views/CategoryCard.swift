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
    let onTapGesture: (String) -> Void
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
        .onTapGesture {
            self.onTapGesture(category.value)
        }
    }
}

struct CategoryCard_Previews: PreviewProvider {
    static var previews: some View {
        CategoryCard(category: CategoryModel(name: "Sport", value: "")) { category in
        
        }
    }
}
