package com.example.finalpro.service;

import com.example.finalpro.dao.RankingDAO;
import com.example.finalpro.entity.Ranking;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class RankingService {
    @Autowired
    private RankingDAO dao;

    // 리뷰 스코어가 높은 순으로 랭킹을 보여주기
    public List<Ranking> findAllRankingOrderByScore(int ticketid, int score){
        return dao.findAllRanking(ticketid, score);
    }
}
