package com.TB_Challenge.dao;

import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;

import java.util.List;

public interface ChallengeDAO {

    List<Challenge> list();

    Challenge getChallenge(int challengeID);

    int save(Challenge challenge);

    int update(Challenge challenge);

    int delete(Integer id);

    List<Race> listRaces(int challengeID);
}
