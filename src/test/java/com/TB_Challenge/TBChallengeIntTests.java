package com.TB_Challenge;

import com.TB_Challenge.authorization.ApplicationUserService;
import com.TB_Challenge.controller.EffectController;
import com.TB_Challenge.dao.ChallengeDAO;
import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.dao.RaceHorseDAO;
import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.RaceHorse;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.security.ApplicationSecurityConfig;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EffectController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TBChallengeIntTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RaceDAO raceDAO;

    @Autowired
    private ChallengeDAO challengeDAO;
    @Autowired
    private RaceHorseDAO raceHorseDAO;


    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private ApplicationUserService applicationUserService;

    @MockBean
    private JavaMailSender javaMailSender;



    @Test
    void testDisplayHelloWorldText() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());

    }

    @Test
    void pullRaceFromATable() throws Exception {

        Race race = raceDAO.getRace(8);
        assertEquals("Breeder's Cup Juvenile", race.getName());

    }
    @Test
    void grabAllStatusFromTable() throws Exception {

        List<Status> statusList = challengeDAO.status();
        System.out.println(statusList.toString());
        assertNotNull(statusList);

    }
    @Test
    void grabAChallengeFromTable() throws Exception {

        Challenge c = challengeDAO.getChallenge(1);
        assertEquals("Derby Bourbon 2022-23", c.getName());

    }

    @Test
    void addAndDeleteHorse() throws Exception {

        RaceHorse r = new RaceHorse("dexter", "M", "2000", "https://link", "Dontae", "My trainer", "epic horse", null);
        raceHorseDAO.save(r);




    }





}
