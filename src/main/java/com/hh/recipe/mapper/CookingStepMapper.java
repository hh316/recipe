package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.CookingStep;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CookingStepMapper extends BaseMapper<CookingStep> {
    void insertCookingStepBatch(@Param("cookingSteps") List<CookingStep> cookingStepList);
}
