package com.hh.recipe.service;


import com.hh.recipe.mapper.BatchingsMapper;
import com.hh.recipe.utils.Result;

public interface BatchingsService {

    Result selectBatchingsByRecipeId(int recipeId);
}
