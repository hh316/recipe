package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.CookingStep;
import com.hh.recipe.domain.vo.CookingStepVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface CookingStepMapper extends BaseMapper<CookingStep> {
    void insertCookingStepBatch(@Param("cookingSteps") List<CookingStep> cookingStepList);

    ArrayList<CookingStepVo> selectCookingStepByRecipeId(int recipeId);
}
