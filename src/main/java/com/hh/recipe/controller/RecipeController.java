package com.hh.recipe.controller;

import com.hh.recipe.domain.dto.CreateRecipeDto;
import com.hh.recipe.service.RecipeService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor  //代替了@Autowired注解-要在属性前加入final关键字
public class RecipeController {
    //crud               create(添加)  read(查询)      update（修改）     delete(删除)
    //restful风格接口规范  POST：创建新   GET：获取资源    PUT：更新现有资源   DELETE：删除资源
    private final RecipeService recipeService;

    //创建菜谱
    @PostMapping()
    public Result createRecipe(@RequestBody CreateRecipeDto recipeDto, @RequestHeader String token) {
        Result result = recipeService.create(recipeDto);
        return result;
    }

    // 查看收藏的菜谱
    @GetMapping()
    public Result recipeFavoritesByRecipeId() {
        Result result = recipeService.recipeFavoritesByRecipeId();
        return result;
    }

    //查看点赞的菜谱
    @GetMapping("recipeLikesByRecipeId")
    public Result recipeLikesByRecipeId() {
        Result result = recipeService.recipeLikesByRecipeId();
        return result;
    }

    // 根据菜谱id查询菜谱信息
    @GetMapping("detail")
    public Result recipeDetail(@RequestParam int recipeId) {
        Result result = recipeService.recipeDetail(recipeId);
        return result;
    }

    //根据菜谱名称查询菜谱信息
    @GetMapping("recipeDetailByRecipeName")
    public Result recipeDetailByRecipeName(@RequestParam String recipeName) {
        Result result = recipeService.recipeDetailByRecipeName(recipeName);
        return result;
    }

    //根据分类名称查询菜谱信息
    @GetMapping("recipeDetailByCategoryName")
    public Result recipeDetailByCategoryName(@RequestParam String CategoryName) {
        Result result = recipeService.recipeDetailByCategoryName(CategoryName);
        return result;
    }

    //根据食材名称查询菜谱信息
    @GetMapping("recipeDetailByIngredientName")
    public Result recipeDetailByIngredientName(@RequestParam String ingredientName) {
        Result result = recipeService.recipeDetailByIngredientName(ingredientName);
        return result;
    }

}