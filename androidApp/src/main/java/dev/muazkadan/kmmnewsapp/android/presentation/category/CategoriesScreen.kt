package dev.muazkadan.kmmnewsapp.android.presentation.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.muazkadan.kmmnewsapp.android.presentation.Screen
import dev.muazkadan.kmmnewsapp.android.presentation.components.CategoryCard
import org.koin.androidx.compose.getViewModel

/**
 * @author muaz
 * Created on 9/8/2022.
 */
@Composable
fun CategoriesScreen(viewModel: CategoryViewModel = getViewModel(), navController: NavController) {
    val gridState = rememberLazyGridState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.White) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "KMP News App",
                        color = Color.Black,
                        style = MaterialTheme.typography.h6,
                    )
                }
            }
        }
    ) {
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                state = gridState,
                columns = GridCells.Adaptive(140.dp)
            ) {
                items(uiState.categories) { category ->
                    CategoryCard(category = category) {
                        navController.navigate(Screen.NewsDetailsScreen.withArgs(category.value))
                    }
                }
            }
        }
    }
}