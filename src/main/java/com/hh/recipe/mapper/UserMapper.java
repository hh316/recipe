package com.hh.recipe.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.recipe.domain.po.User;
import com.hh.recipe.domain.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

public interface UserMapper extends BaseMapper<User> {


     ArrayList<UserVo> findAllfans(Integer userId);

     ArrayList<UserVo> findAllFollower(Integer userId);
}