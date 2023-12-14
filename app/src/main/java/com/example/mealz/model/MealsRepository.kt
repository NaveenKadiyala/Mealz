package com.example.mealz.model

import com.example.mealz.model.api.MealzApi
import com.example.mealz.model.response.Category

class MealsRepository(private val mealzApi: MealzApi = MealzApi()) {

    suspend fun getCategories(): List<Category> {
        return mealzApi.getCategories().categories
    }
}