package com.example.recipeapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.recipeapp.Model.Categories

@Composable
fun CategoryDetailScreen(category: Categories) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} Thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f) // Keeps image square, within screen width
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Center,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}