package com.example.demo.auth;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {

        List<ApplicationUser> appUser = new ArrayList<>();
        List<User>  userList = userDAO.list();

        for(User u: userList){
            System.out.println("Defined a new user  from db with username " + u.getUsername() + " " + u.getPassword());

            appUser.add(
                    new ApplicationUser(
                            u.getUsername(),
                            u.getPassword(),
                            true,
                            true,
                            true,
                            true
                    )
            );
        }


        return appUser;
    }

}
