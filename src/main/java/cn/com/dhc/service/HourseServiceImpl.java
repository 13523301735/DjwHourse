package cn.com.dhc.service;

import cn.com.dhc.dao.HourseMapper;
import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.HourseExample;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HourseServiceImpl implements HourseService {

    @Value(value = "${adminPageSize}")
    private int adminPageSize;

    @Resource
    private HourseMapper hourseMapper;

    @Override
    public Result<SearchResult> searchHourseWithVillage(String status,String currPage, String village) throws DJWRuntimeException {
        HourseExample example = new HourseExample();
        HourseExample.Criteria criteria = example.createCriteria();
        if (village != null && !village.trim().equals("")){
            criteria.andVillageLike("%" + village + "%");
        }
        if (status != null && !status.trim().equals("")){
            criteria.andStatusEqualTo(Integer.valueOf(status));
        }
        List<Hourse> hourseList = hourseMapper.selectByExampleWithLimit(example, Integer.valueOf(currPage)*adminPageSize, adminPageSize);
        int count = hourseMapper.countByExample(example);
        SearchResult result = new SearchResult();
        result.setTotalCount(count);
        result.setHourseList(hourseList);
        result.setPageNum(Integer.valueOf(currPage));
        return Result.success(result);
    }
}
