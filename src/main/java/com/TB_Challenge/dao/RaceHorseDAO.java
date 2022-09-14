package com.TB_Challenge.dao;


import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.RaceHorse;

import java.util.List;

public interface RaceHorseDAO {

    List<RaceHorse> list();

    RaceHorse getRaceHorse(int racehorseID);

    int save(RaceHorse race);

    int update(RaceHorse race);

    int delete(Integer id);



}
