package cn.com.dhc.service;

import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;

import java.util.List;

public interface HourseService {

    Result<SearchResult> searchHourseWithVillage(String status,String currPage, String village) throws DJWRuntimeException;

}
