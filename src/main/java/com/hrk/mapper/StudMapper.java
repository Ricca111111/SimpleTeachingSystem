package com.hrk.mapper;
import com.hrk.entity.Stud;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StudMapper {
    @Select("select * from t_stud")
    List<Stud> selectStuds();

    @Select("select * from t_stud where sequence=#{sequence}")
    Stud selectStudBySequence(@Param("sequence") Integer sequence);

    @Insert("insert into t_stud values (null,#{studNumber},#{studName},#{major},#{studClass})")
    int insertStud(Stud stud);

    @Delete("delete from t_stud where sequence=#{sequence}")
    int deleteStudBySequence(int sequence);

    @Update("update t_stud set studNumber=#{studNumber},studName=#{studName},major=#{major},studClass=#{studClass} where sequence=#{sequence}")
    int updateStud(Stud stud);

    @Select("select * from t_stud where ${searchType} like concat('%',#{keyword},'%')")
    List<Stud> searchStuds(@Param("searchType") String searchType, @Param("keyword") String keyword);

}


