package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.RecipeFavorites;
import com.hh.recipe.domain.po.RecipeLikes;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.domain.vo.UserVo;

import java.util.ArrayList;

public interface UserMapper extends BaseMapper<User> {
    int likeRecipe(RecipeLikes recipeLike);

    ArrayList<UserVo> findAllfans(Integer userId);

    ArrayList<UserVo> findAllFollower(Integer userId);

    int favoritesRecipe(RecipeFavorites recipeFavorite);


}