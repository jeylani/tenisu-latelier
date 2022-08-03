package com.latelier.tall.tenisu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.latelier.tall.tenisu.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT AVG((weight*10)/(height*height)) AS IMC FROM Player")
    List<Object[]> getAvgImc();
}