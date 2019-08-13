package cn.com.dhc.service;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.SearchEntity;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;

import java.util.List;


public interface ForrentService {

    Result<SearchResult> searchHourse(SearchEntity searchEntity) throws DJWRuntimeException;

    List<Hourse> getAllHourse();

}
