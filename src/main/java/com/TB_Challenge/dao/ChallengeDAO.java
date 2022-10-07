package com.TB_Challenge.dao;

import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.Track;

import java.util.HashMap;
import java.util.List;

public interface ChallengeDAO {

    List<Challenge> list(List<Status> s, int offset);
    List<Status> status();

    Challenge getChallenge(int challengeID);

    int save(Challenge challenge);

    int update(Challenge challenge);

    int delete(Integer id);

    List<Race> listRaces(int challengeID, List<Track> t);

    int changeName(Integer id, String name);

    int changeDesc(Integer id, String desc);
    int changeFirst(Integer id, Integer first);
    int changeSecond(Integer id, Integer second);
    int changeThird(Integer id, Integer third);
    int changeFourth(Integer id, Integer fourth);
    int changeStatus(Integer id, String status);
    int changeDate(Integer id, String date);

}
