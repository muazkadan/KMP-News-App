//
//  NewsCard.swift
//  iosApp
//
//  Created by Muaz KADAN on 25.12.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsCard: View {
    let newsModel: NewsModel
    var body: some View {
        VStack(alignment: .leading) {
            Text(newsModel.title)
                .font(.headline)
                .fontWeight(.bold)
                .multilineTextAlignment(.leading)
            Text(newsModel.content)
                .multilineTextAlignment(.leading)
            Text(newsModel.author + ", " + newsModel.date + ", " + newsModel.time).font(.footnote)
            CustomImageView(urlString: newsModel.imageUrl)
        }
        .padding([.top, .leading, .trailing])
        .frame(maxWidth: .infinity)
        .background(Color.white)
        .cornerRadius(8)
        .shadow(radius: 8)
    }
}

struct NewsCard_Previews: PreviewProvider {
    static var previews: some View {
        NewsCard(newsModel: NewsModel(author: "Test Author", content: "Test some content", date: "12/12/2022", imageUrl: "https://downloads.ti.com/mctools/esd/docs/tidl-api/_images/cat-pet-animal-domestic-104827.jpeg", readMoreUrl: "https://downloads.ti.com/mctools/esd/docs/tidl-api/_images/cat-pet-animal-domestic-104827.jpeg", time: "12:12", title: "Test title", url: "https://downloads.ti.com/mctools/esd/docs/tidl-api/_images/cat-pet-animal-domestic-104827.jpeg"))
    }
}
