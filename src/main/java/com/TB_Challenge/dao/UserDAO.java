package com.TB_Challenge.dao;

import com.TB_Challenge.model.Role;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    List<User> list();

    HashMap<Integer, String> fastlookup();

    List<User> Adminlist(List<Status> s, List<Role> r, int adminOffset);

    User getUserInfo(String username);

    int update(User user);

    User getUser(Integer id);

    int delete(Integer id);

    int updateAdmin(User user);

    int saveAdmin(User u);

    int changeUserName(Integer id, String username);
    int changePassword(Integer id, String password);
    int changeRole(Integer id, String role);
    int changeStatus(Integer id, String status);


}
