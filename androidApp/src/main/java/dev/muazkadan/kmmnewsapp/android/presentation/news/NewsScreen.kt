package dev.muazkadan.kmmnewsapp.android.presentation.news

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import dev.muazkadan.kmmnewsapp.android.utils.extension.asUri
import dev.muazkadan.kmmnewsapp.data.model.NewsModel
import org.koin.androidx.compose.getViewModel

@Composable
fun NewsScreen(
    categoryName: String,
    viewModel: NewsViewModel = getViewModel(),
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true){
        viewModel.getNews(categoryName)
    }
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.White) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Text(text = categoryName, fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }) {
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(it),
            ) {
                items(uiState.news) { news ->
                    NewsCard(newsItem = news)
                }
            }
        }
    }
}

@Composable
fun NewsCard(newsItem: NewsModel, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable {
                val browserIntent = Intent(Intent.ACTION_VIEW, newsItem.readMoreUrl.asUri())
                context.startActivity(browserIntent, null)
            },
        elevation = 10.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Text(text = newsItem.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = newsItem.content, modifier = Modifier.padding(top = 6.dp))
            Text(
                text = buildString {
                    append(newsItem.author)
                    append(", ")
                    append(newsItem.date)
                    append(", ")
                    append(newsItem.time)
                },
                modifier = Modifier.padding(top = 6.dp), fontSize = 10.sp
            )

            SubcomposeAsyncImage(
                model = newsItem.imageUrl,
                loading = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 6.dp),
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
    NewsCard(
        newsItem = NewsModel(
            author = "Test Author",
            content = "Test content test content",
            date = "15 Sep 2022",
            imageUrl = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_light_color_272x92dp.png",
            readMoreUrl = "https://github.com/Mouazkaadan/NewsApp/tree/master/app/src/main/java/net/mouazkaadan/inshort",
            time = "Thursday, 02:05 pm",
            title = "Test Title",
            url = "https://github.com/Mouazkaadan/NewsApp/tree/master/app/src/main/java/net/mouazkaadan/inshort"
        )
    )
}
