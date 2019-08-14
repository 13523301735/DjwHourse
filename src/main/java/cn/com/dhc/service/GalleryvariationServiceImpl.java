package cn.com.dhc.service;

import cn.com.dhc.dao.HourseMapper;
import cn.com.dhc.domain.Hourse;
import cn.com.dhc.util.CodeMsg;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class GalleryvariationServiceImpl implements GalleryvariationService {

    @Resource
    private HourseMapper hourseMapper;

    @Override
    public Result<Hourse> searchById(String hourseId) throws DJWRuntimeException {
        if (hourseId == null || hourseId == ""){
            throw new DJWRuntimeException(CodeMsg.BIND_ERROR);
        }
        Hourse hourse = hourseMapper.selectByPrimaryKey(Integer.valueOf(hourseId));
        return Result.success(hourse);
    }
}
