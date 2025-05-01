package com.example.recipeapp.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipeapp.Model.Categories
import com.example.recipeapp.Screen
import com.example.recipeapp.View.CategoryDetailScreen
import com.example.recipeapp.View.RecipeScreen

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route) {
            RecipeScreen(viewstate = viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                navController.navigate(Screen.DetailsScreen.route)
            })
        }
        composable(Screen.DetailsScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Categories>("category")
                    ?: Categories("", "strCategory", "", "")
            CategoryDetailScreen(category = category)
        }


    }
}