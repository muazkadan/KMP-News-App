package dev.muazkadan.kmmnewsapp.android.presentation

sealed class Screen(val route: String) {
    object CategoriesScreen : Screen("categories_screen")
    object NewsDetailsScreen : Screen("details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
