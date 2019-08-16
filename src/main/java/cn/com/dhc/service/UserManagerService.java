package cn.com.dhc.service;

import cn.com.dhc.domain.Usermanager;

public interface UserManagerService {

    Usermanager login(String username, String password);

    Usermanager findUserManagerByUsername(String username);
}
