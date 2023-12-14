package com.example.mealz.ui.meals

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealz.model.MealsRepository
import com.example.mealz.model.response.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    val categoriesListState = mutableStateOf(emptyList<Category>())

    init {
        Log.d("N_TAG", "about to launch the coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("N_TAG", "launched the coroutine")
            categoriesListState.value = getCategories()
            Log.d("N_TAG", "Received the data from the async")
        }
        Log.d("N_TAG", "other work")
    }

    private suspend fun getCategories(): List<Category> {
        return repository.getCategories()
    }

}