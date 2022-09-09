package com.TB_Challenge.dao;

import com.TB_Challenge.model.Track;
import com.TB_Challenge.model.User;

import java.util.List;

public interface UserDAO {

    List<User> list();

    User getUserInfo(String username);

    int update(User user);
}
