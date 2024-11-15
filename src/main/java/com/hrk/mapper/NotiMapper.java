package com.hrk.mapper;

import com.hrk.entity.Noti;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotiMapper {
    @Select("select * from t_noti")
    List<Noti> selectNotis();

    @Select("select * from t_noti where id=#{id}")
    Noti selectNotiById(@Param("id") Integer id);

    @Insert("insert into t_noti values (null,#{notiKind},#{notiContent},#{time})")
    int insertNoti(Noti noti);

    @Delete("delete from t_noti where id=#{id}")
    int deleteNotiById(int id);

    @Update("update t_noti set notiKind=#{notiKind},notiContent=#{notiContent},time=#{time} where id=#{id}")
    int updateNoti(Noti noti);

    @Select("select * from t_noti where ${searchType} like concat('%',#{keyword},'%')")
    List<Noti> searchNotis(@Param("searchType") String searchType, @Param("keyword") String keyword);

}
