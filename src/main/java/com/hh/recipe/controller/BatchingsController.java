package com.hh.recipe.controller;

import com.hh.recipe.service.BatchingsService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//配料控制层
@RestController
@RequestMapping("/batchings")
@RequiredArgsConstructor
public class BatchingsController {
    private final BatchingsService batchingsService;

    @GetMapping()
    public Result selectBatchingsByRecipeId(@RequestParam int recipeId) {
        Result result = batchingsService.selectBatchingsByRecipeId(recipeId);
        return result;
    }
}
