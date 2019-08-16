package cn.com.dhc.service;

import cn.com.dhc.dao.UsermanagerMapper;
import cn.com.dhc.domain.Usermanager;
import cn.com.dhc.domain.UsermanagerExample;
import cn.com.dhc.util.CodeMsg;
import cn.com.dhc.util.DJWRuntimeException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Resource
    private UsermanagerMapper usermanagerMapper;

    @Override
    public Usermanager login(String username, String password) {
        UsermanagerExample example = new UsermanagerExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<Usermanager> usermanagerList = usermanagerMapper.selectByExample(example);
        if (usermanagerList != null && usermanagerList.size() == 1){
            return usermanagerList.get(0);
        }
        throw new DJWRuntimeException(CodeMsg.PASSWORD_ERROR);
    }

    @Override
    public Usermanager findUserManagerByUsername(String username) {
        UsermanagerExample example = new UsermanagerExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Usermanager> usermanagerList = usermanagerMapper.selectByExample(example);
        if (usermanagerList != null && usermanagerList.size() == 1){
            return usermanagerList.get(0);
        }
        throw new DJWRuntimeException(CodeMsg.SERVER_ERROR);
    }
}
