package com.hh.recipe.service;


import com.hh.recipe.utils.Result;

public interface CookingStepService {
    Result selectCookingStepByRecipeId(int recipeId);
}
