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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class HourseServiceImpl implements HourseService {

    @Value(value = "${adminPageSize}")
    private int adminPageSize;

    @Value("${fileSavePath}")
    private String fileSavePath;

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
        List<Hourse> hourseList = hourseMapper.selectByExampleWithLimit(example, (Integer.valueOf(currPage)-1)*adminPageSize, adminPageSize);
        int count = hourseMapper.countByExample(example);
        SearchResult result = new SearchResult();
        result.setTotalCount(count);
        result.setHourseList(hourseList);
        result.setPageNum(Integer.valueOf(currPage));
        return Result.success(result);
    }

    @Override
    public int add(Hourse hourse) {
        hourse.setStatus(0);
        int result = hourseMapper.insert(hourse);
        return result;
    }

    @Override
    public Result<Hourse> searchById(String hourseId) {
        Hourse hourse = hourseMapper.selectByPrimaryKey(Integer.valueOf(hourseId));
        return Result.success(hourse);
    }

    @Override
    public String delete(List<Integer> ids) {
        if (ids == null){
            throw new DJWRuntimeException(10000,"hourseIds is invalid.");
        }
        ArrayList<Hourse> deleteList = new ArrayList<>();
        ids.forEach(id -> {
            Hourse hourse = hourseMapper.selectByPrimaryKey(id);
            deleteList.add(hourse);
            if (hourse.getStatus() == 1){
                throw new DJWRuntimeException(10000,"您要删除的房源中含有商家中的房源，请先下架后再进行删除。");
            }
        });
        deleteList.forEach(hourse -> {
            hourseMapper.deleteByPrimaryKey(hourse.getHourseid());
            //删除对应的图片。
            String[] pics = hourse.getPicture().split(",");
            for (String pic : pics) {
                File file = new File(fileSavePath + pic);
                file.delete();
            }
        });
        return "删除成功。";
    }

    @Override
    public String putaway(List<Integer> ids) {
        if (ids == null){
            throw new DJWRuntimeException(10000,"hourseIds is invalid.");
        }
        Hourse hourse = new Hourse();
        hourse.setStatus(1);
        ids.forEach(id -> {
            hourse.setHourseid(id);
            int i = hourseMapper.updateByPrimaryKeySelective(hourse);
            if (i != 1){
                throw new DJWRuntimeException(10000,"上架失败。");
            }
        });
        return "上架成功。";
    }

    @Override
    public String soldOut(List<Integer> ids) {
        if (ids == null){
            throw new DJWRuntimeException(10000,"hourseIds is invalid.");
        }
        Hourse hourse = new Hourse();
        hourse.setStatus(0);
        ids.forEach(id -> {
            hourse.setHourseid(id);
            int i = hourseMapper.updateByPrimaryKeySelective(hourse);
            if (i != 1){
                throw new DJWRuntimeException(10000,"下架失败。");
            }
        });
        return "下架成功。";
    }
}
