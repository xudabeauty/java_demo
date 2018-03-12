package com.my.spring.chapter02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.spring.chapter02.dao.LoginLogDao;
import com.my.spring.chapter02.dao.UserDao;
import com.my.spring.chapter02.domain.LoginLog;
import com.my.spring.chapter02.domain.User;

@Service
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;
    
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao=loginLogDao;
    }
    
    public boolean hasMatchUser(String username,String password) {
        return userDao.GetMatchCout(username, password)>1;
    }
    
    public User findUserByUsername(String userName) {
        return userDao.getUserByUsernaem(userName);
    }
    
    @Transactional
    public void loginSuccess(User user) {
        user.setCredit(5+user.getCredit());
        LoginLog loginLog=new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
