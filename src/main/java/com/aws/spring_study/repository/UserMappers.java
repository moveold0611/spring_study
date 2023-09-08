package com.aws.spring_study.repository;


import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMappers {
    public int saveUser(RegisterUserReqDto registerUserReqDto);
    public int updateUser(User user);
    public int deleteUser(int userId);
    public List<User> getUserListAll();
}