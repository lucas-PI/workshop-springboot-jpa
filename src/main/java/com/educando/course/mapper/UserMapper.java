package com.educando.course.mapper;

import com.educando.course.dto.UserPostRequest;
import com.educando.course.dto.UserPutRequest;
import com.educando.course.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User toUser(UserPostRequest userPostRequest);
    public abstract User toUser(UserPutRequest userPutRequest);
}
