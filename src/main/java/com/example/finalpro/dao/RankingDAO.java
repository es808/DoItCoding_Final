package com.example.finalpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingDAO extends JpaRepository<Ranking, Integer> {
    @Query(value = "select t.ticketid, ticket_name, img_fname, score from ticket t, review r where t.ticketid = r.ticketid and cateid = ?1 order by score desc", nativeQuery = true)
    public List<Ranking> findAllRanking(int cateid);
}
