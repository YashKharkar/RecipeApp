package com.example.recipeapp.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.Model.Categories
import com.example.recipeapp.Model.recipeService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState :State<RecipeState> = _categorieState

    init {
        fetchCategories()
    }

    private  fun fetchCategories() {
        viewModelScope.launch {
           try {

               val response = recipeService.getCategories()
               _categorieState.value = _categorieState.value.copy(
               list = response.categories,
               loading = false,
               error = null
               )
               Log.d(TAG, "fetchCategories: "+response.categories)


           }catch (e:Exception){
                 _categorieState.value = _categorieState.value.copy(
                     loading = false,
                     error = "Error fetching categories${e.localizedMessage}"
                 )
           }
        }}

        data class RecipeState(
            val loading: Boolean = true,
            val list: List<Categories> = emptyList(),
            val error: String? = null
        )
    }