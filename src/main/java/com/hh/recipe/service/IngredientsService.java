package com.hh.recipe.service;


import com.hh.recipe.utils.Result;

public interface IngredientsService {
    Result selectIngredientsByRecipeId(int recipeId);
}
