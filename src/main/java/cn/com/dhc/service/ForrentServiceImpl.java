package cn.com.dhc.service;

import cn.com.dhc.dao.HourseMapper;
import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.HourseExample;
import cn.com.dhc.domain.SearchEntity;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.util.CodeMsg;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ForrentServiceImpl implements ForrentService {

    @Value(value = "${pageSize}")
    private int pageSize;

    @Resource
    private HourseMapper hourseMapper;

    @Override
    public Result<SearchResult> searchHourse(SearchEntity searchEntity) throws DJWRuntimeException {
        if (searchEntity == null){
            throw new DJWRuntimeException(CodeMsg.BIND_ERROR);
        }
        HourseExample example = new HourseExample();
        HourseExample.Criteria criteria = example.createCriteria();
        if (!"all".equals(searchEntity.getOnePlace())){
            criteria.andOneplaceEqualTo(searchEntity.getOnePlace());
        }
        if (!"all".equals(searchEntity.getTwoPlace())){
            criteria.andTwoplaceEqualTo(searchEntity.getTwoPlace());
        }
        if (!"all".equals(searchEntity.getArea())){
            if (searchEntity.getArea().contains(">")){
                criteria.andAreaGreaterThanOrEqualTo(Integer.valueOf(searchEntity.getArea().substring(1)));
            } else if (searchEntity.getArea().contains("<")){
                criteria.andAreaLessThanOrEqualTo(Integer.valueOf(searchEntity.getArea().substring(1)));
            } else {
                String[] areaArr = searchEntity.getArea().split("-");
                criteria.andAreaBetween(Integer.valueOf(areaArr[0]),Integer.valueOf(areaArr[1]));
            }
        }
        if (!"all".equals(searchEntity.getDirection())){
            criteria.andDirectionEqualTo(searchEntity.getDirection());
        }
        if (!"all".equals(searchEntity.getUnit())){
            if (searchEntity.getUnit().contains(">")){
                criteria.andRoomnumGreaterThan(Integer.valueOf(searchEntity.getUnit().substring(1)));
            } else {
                criteria.andRoomnumEqualTo(Integer.valueOf(searchEntity.getUnit()));
            }
        }
        if (!"all".equals(searchEntity.getFloor())){
            if (searchEntity.getFloor().contains(">")){
                criteria.andFloorGreaterThanOrEqualTo(Integer.valueOf(searchEntity.getFloor().substring(1)));
            } else if (searchEntity.getFloor().contains("<")){
                criteria.andFloorLessThanOrEqualTo(Integer.valueOf(searchEntity.getFloor().substring(1)));
            } else {
                String[] floorArr = searchEntity.getFloor().split("-");
                criteria.andFloorBetween(Integer.valueOf(floorArr[0]),Integer.valueOf(floorArr[1]));
            }
        }
        if (!"any".equals(searchEntity.getMinPrice())){
            criteria.andPriceGreaterThanOrEqualTo(Double.valueOf(searchEntity.getMinPrice()));
        }
        if (!"any".equals(searchEntity.getMaxPrice())){
            criteria.andPriceLessThanOrEqualTo(Double.valueOf(searchEntity.getMaxPrice()));
        }
        //只查询上架的房源
        criteria.andStatusEqualTo(1);
        SearchResult result = new SearchResult();
        //分页查询
        List<Hourse> list = hourseMapper.selectByExampleWithLimit(example,searchEntity.getPageNum()*pageSize,pageSize);
        result.setPageNum(searchEntity.getPageNum());
        result.setHourseList(list);
        //查询总条数
        int count = hourseMapper.countByExample(example);
        result.setTotalCount(count);
        return Result.success(result);
    }

    @Override
    public List<Hourse> getAllHourse() {
        return hourseMapper.selectByExample(new HourseExample());
    }
}
