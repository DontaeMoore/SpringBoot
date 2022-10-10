package com.TB_Challenge.authorization;

import com.TB_Challenge.model.User;
import com.TB_Challenge.dao.UserDAO;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import static com.TB_Challenge.security.ApplicationUserRole.*;

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

        System.out.println("Spring will fetch users from this call, then compare what you typed in to this!");
        System.out.println("We store passwords encrypted, then we decrypt them when we pull them out");

//        String originalInput = "stogiemike2022";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//        String decodedString = new String(decodedBytes);
//        System.out.println(encodedString + " " + decodedString);

        List<ApplicationUser> appUser = new ArrayList<>();
        List<User>  userList = userDAO.list();

        appUser.add(
                new ApplicationUser(
                       "test",
                        "password",
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );

        for(User u: userList){
            //Assumes the password stored in db is encoded with base64
            byte[] decodedPassBytes = Base64.getDecoder().decode(u.getPassword());
            String decodedPass = new String(decodedPassBytes);
            System.out.println("Defined a new user  from db with username " + u.getUsername() + " " + u.getPassword()
                    + " decoded password -> " +decodedPass+  " role " +u.getRole() + " status " + u.getStatus());



            if(!u.getStatus().equals("2")) { //don't make accounts for users with inactive status
                if (u.getRole().equals("1"))
                    appUser.add(
                            new ApplicationUser(
                                    u.getUsername(),
                                    decodedPass,
                                    ADMIN.getGrantedAuthorities(),
                                    true,
                                    true,
                                    true,
                                    true
                            )
                    );
                } else if(u.getRole().equals("2")){
                    appUser.add(
                            new ApplicationUser(

                                    u.getUsername(),
                                    decodedPass,
                                    USER.getGrantedAuthorities(),
                                    true,
                                    true,
                                    true,
                                    true
                            )
                    );

                }
            else {
                appUser.add(
                        new ApplicationUser(

                                u.getUsername(),
                                decodedPass,
                                OFFICER.getGrantedAuthorities(),
                                true,
                                true,
                                true,
                                true
                        )
                );
            }



        }


        return appUser;
    }

}
