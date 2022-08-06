package com.latelier.tall.tenisu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.latelier.tall.tenisu.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    @Query( value = "WITH SUB_COUNT AS "
                + "( "
                    +"SELECT C.*, SUM(P.POINTS) AS TOTAL_PTS " 
                    +"FROM COUNTRIES C INNER JOIN PLAYERS P ON C.CODE = P.COUNTRY_CODE "
                    +"GROUP BY C.CODE "
                +"), "
                +"COUNTRY_RANK AS "
                +"( "
                    +"SELECT CODE, PICTURE, RANK() OVER(ORDER BY TOTAL_PTS DESC) C_RANK FROM SUB_COUNT " 
                +") "
                +"SELECT CODE, PICTURE FROM COUNTRY_RANK WHERE C_RANK = 1",
            nativeQuery=true)
    List<Country> getTopCountries();
}
