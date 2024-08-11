package dev.muazkadan.kmmnewsapp.android.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.muazkadan.kmmnewsapp.android.presentation.category.CategoriesScreen
import dev.muazkadan.kmmnewsapp.android.presentation.news.NewsScreen
import org.koin.androidx.compose.koinViewModel

/**
 * @author muaz
 * Created on 9/8/2022.
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CategoriesScreen.route) {
        composable(route = Screen.CategoriesScreen.route) {
            CategoriesScreen(koinViewModel(), navController)
        }
        composable(
            route = Screen.NewsDetailsScreen.route + "/{category}",
            arguments = listOf(
                navArgument(name = "category") {
                    type = NavType.StringType
                }
            )
        ) {
            it.arguments?.getString("category")?.let { categoryName ->
                NewsScreen(categoryName.capitalize(), koinViewModel(), navController)
            }
        }
    }
}
