package cn.com.dhc.service;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;

import java.util.List;

public interface HourseService {

    Result<SearchResult> searchHourseWithVillage(String status,String currPage, String village) throws DJWRuntimeException;

    int add(Hourse hourse);

    Result<Hourse> searchById(String hourseId);

    String delete(List<Integer> ids);

    String putaway(List<Integer> ids);

    String soldOut(List<Integer> ids);
}
