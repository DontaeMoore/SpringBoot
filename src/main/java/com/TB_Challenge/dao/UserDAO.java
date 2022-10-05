package com.TB_Challenge.dao;

import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.User;

import java.util.List;

public interface UserDAO {

    List<User> list();
    List<User> Adminlist(List<Status> s);

    User getUserInfo(String username);

    int update(User user);

    User getUser(Integer id);

    int delete(Integer id);

    int updateAdmin(User user);

    int saveAdmin(User u);


}
