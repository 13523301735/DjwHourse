package cn.com.dhc.dao;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.HourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HourseMapper {
    int countByExample(HourseExample example);

    int deleteByExample(HourseExample example);

    int deleteByPrimaryKey(Integer hourseid);

    int insert(Hourse record);

    int insertSelective(Hourse record);

    List<Hourse> selectByExample(HourseExample example);

    List<Hourse> selectByExampleWithLimit(@Param("example")HourseExample example,@Param("currIndex") int currIndex, @Param("pageSize")int pageSize);

    Hourse selectByPrimaryKey(Integer hourseid);

    int updateByExampleSelective(@Param("record") Hourse record, @Param("example") HourseExample example);

    int updateByExample(@Param("record") Hourse record, @Param("example") HourseExample example);

    int updateByPrimaryKeySelective(Hourse record);

    int updateByPrimaryKey(Hourse record);
}