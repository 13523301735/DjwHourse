package cn.com.dhc.service;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;

public interface GalleryvariationService {

    Result<Hourse> searchById(String hourseId) throws DJWRuntimeException;
}
