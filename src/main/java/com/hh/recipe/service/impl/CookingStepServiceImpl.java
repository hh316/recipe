package com.hh.recipe.service.impl;

import com.hh.recipe.domain.vo.CookingStepVo;
import com.hh.recipe.mapper.CookingStepMapper;
import com.hh.recipe.service.CookingStepService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//步骤业务层
@Service
@RequiredArgsConstructor
public class CookingStepServiceImpl implements CookingStepService {
    private final CookingStepMapper cookingStepMapper;

    /**
     * @param recipeId
     * @return 根据菜谱id查询步骤
     */
    @Override
    public Result selectCookingStepByRecipeId(int recipeId) {
        ArrayList<CookingStepVo> cookingStepVoArrayList = new ArrayList<>();
        cookingStepVoArrayList = cookingStepMapper.selectCookingStepByRecipeId(recipeId);
        return Result.ok(cookingStepVoArrayList);
    }
}
