package cn.com.dhc.service;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;

public interface HourseService {

    Result<SearchResult> searchHourseWithVillage(String status,String currPage, String village) throws DJWRuntimeException;

    int add(Hourse hourse);

    Result<Hourse> searchById(String hourseId);
}
