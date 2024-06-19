package com.hh.recipe.controller;

import com.hh.recipe.domain.vo.IngredientsVo;
import com.hh.recipe.service.IngredientsService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//食材控制层
@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientsController {
    private final IngredientsService ingredientsService;

    @GetMapping()
    public Result selectIngredientsByRecipeId(@RequestParam int recipeId) {
        Result result = ingredientsService.selectIngredientsByRecipeId(recipeId);
        return result;
    }
}
