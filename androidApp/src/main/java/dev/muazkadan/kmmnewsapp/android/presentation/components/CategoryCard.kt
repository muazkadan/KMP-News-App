package dev.muazkadan.kmmnewsapp.android.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.muazkadan.kmmnewsapp.data.model.CategoryModel

@Composable
fun CategoryCard(
    category: CategoryModel,
    modifier: Modifier = Modifier,
    onClickCategory: (category: String) -> Unit
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .aspectRatio(2F)
            .clickable {
                onClickCategory.invoke(category.value)
            },
        elevation = 10.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category.name,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
@Preview
fun CategoryCardPreview() {
    CategoryCard(
        category = CategoryModel(
            name = "Business",
            value = "business"
        )
    ) {}
}

