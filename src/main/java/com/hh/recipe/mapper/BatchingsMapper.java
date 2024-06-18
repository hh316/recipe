package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.Batchings;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatchingsMapper extends BaseMapper<Batchings> {
    void insertBatingsBatch(@Param("batchings") List<Batchings> batchingsList);
}
