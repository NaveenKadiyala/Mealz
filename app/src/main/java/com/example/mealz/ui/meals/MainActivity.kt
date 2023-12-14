package com.example.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealz.ui.theme.MealzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                CategoriesScreen()
            }
        }
    }
}

@Composable
fun CategoriesScreen() {
    val viewModel: CategoriesViewModel = viewModel()
    val meals = viewModel.categoriesListState.value
    LazyColumn {
        items(meals) {
            Text(
                text = "Name : ${it.name}\nDescription : ${it.description}"
            )
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzTheme {
        CategoriesScreen()
    }
}