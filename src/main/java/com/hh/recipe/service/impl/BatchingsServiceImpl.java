package com.hh.recipe.service.impl;

import com.hh.recipe.domain.vo.BatchingsVo;
import com.hh.recipe.mapper.BatchingsMapper;
import com.hh.recipe.service.BatchingsService;
import com.hh.recipe.utils.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//配料业务层
@Service
@RequiredArgsConstructor
public class BatchingsServiceImpl implements BatchingsService {
    private final BatchingsMapper batchingsMapper;

    /**
     * @param recipeId
     * @return 查询菜谱里的配料
     */
    @Override
    public Result selectBatchingsByRecipeId(int recipeId) {
        ArrayList<BatchingsVo> batchingsVoArrayList = new ArrayList<>();
        batchingsVoArrayList = batchingsMapper.selectBatchingsByRecipeI(recipeId);
        return Result.ok(batchingsVoArrayList);
    }
}
