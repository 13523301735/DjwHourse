package cn.com.dhc.dao;

import cn.com.dhc.domain.Usermanager;
import cn.com.dhc.domain.UsermanagerExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsermanagerMapper {
    int countByExample(UsermanagerExample example);

    int deleteByExample(UsermanagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermanager record);

    int insertSelective(Usermanager record);

    List<Usermanager> selectByExample(UsermanagerExample example);

    Usermanager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usermanager record, @Param("example") UsermanagerExample example);

    int updateByExample(@Param("record") Usermanager record, @Param("example") UsermanagerExample example);

    int updateByPrimaryKeySelective(Usermanager record);

    int updateByPrimaryKey(Usermanager record);
}