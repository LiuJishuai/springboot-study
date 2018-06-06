package com.jeyson.springboot.mapper;

import com.jeyson.springboot.dao.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author: liujishuai
 * @Time: 2018/2/26 15:21
 * @Description:
 */
@Mapper
public interface UserMapper {
    String table_name = "user";
    String fields = "account,username,password";
    String all_fields = "id,account,username,password";

    @Select("select "+all_fields+" from "+table_name+"  where id = #{id}")
    User getById(@Param("id") Long id);

    @Insert("insert into "+table_name+" ("+fields+")"+" values (#{user.account},#{user.username},#{user.password})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "user.id", before = false, resultType = Long.class)
    int insertUser(@Param("user") User user);

    @Select("select "+all_fields+" from "+table_name+"  where account = #{account}")
    User getByAccount(@Param("account") String account);

    @Select("select count(1) from "+table_name+"  where account = #{account}")
    int getUserNumByAccount(@Param("account") String account);
}
