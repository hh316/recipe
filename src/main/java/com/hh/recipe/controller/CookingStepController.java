package com.hh.recipe.controller;

import com.hh.recipe.service.BatchingsService;
import com.hh.recipe.service.CookingStepService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//步骤控制层
@RestController
@RequestMapping("/cookingStep")
@RequiredArgsConstructor
public class CookingStepController {
    private final CookingStepService cookingStepService;

    @GetMapping()
    public Result selectCookingStepByRecipeId(@RequestParam int recipeId) {
        Result result = cookingStepService.selectCookingStepByRecipeId(recipeId);
        return result;
    }
}
