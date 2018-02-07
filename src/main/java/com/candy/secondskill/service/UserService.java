package com.candy.secondskill.service;

import com.candy.secondskill.dao.UserDao;
import com.candy.secondskill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public User getById(int id){
        User u = userDao.getById(id);
        return u;
    }

    @Transactional
    public boolean tx(){
        User u1 = new User();
        u1.setName("change");
        u1.setId(3);
        userDao.insertUser(u1);

        u1.setId(3);
        u1.setName("hhhhha");
        userDao.insertUser(u1);
        return true;

    }
}
