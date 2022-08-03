package com.latelier.tall.tenisu.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import com.latelier.tall.tenisu.model.Country;
import com.latelier.tall.tenisu.model.Player;
import com.latelier.tall.tenisu.repository.CountryRepository;
import com.latelier.tall.tenisu.repository.PlayerRepository;

@Component
public class DataLoader {

    private CountryRepository countryRepository;
    private PlayerRepository playerRepository;

    public DataLoader(@Autowired CountryRepository countryRepository, @Autowired PlayerRepository playerRepository) {
        this.countryRepository = countryRepository;
        this.playerRepository = playerRepository;
        loadData();
    }

    private void loadData() {
        //Countries
        Country srbCountry = new Country("SRB", "https://data.latelier.co/training/tennis_stats/resources/Serbie.png");
        Country usaCountry = new Country("USA", "https://data.latelier.co/training/tennis_stats/resources/USA.png");
        Country suiCountry = new Country("SUI", "https://data.latelier.co/training/tennis_stats/resources/Suisse.png");
        Country espCountry = new Country("ESP", "https://data.latelier.co/training/tennis_stats/resources/Espagne.png");
        countryRepository.save(srbCountry);
        countryRepository.save(usaCountry);
        countryRepository.save(suiCountry);
        countryRepository.save(espCountry);

        //Players
        Player player = new Player();
        player.setFirstname("Novak");
        player.setLastname("Djokovic");
        player.setShortname("N.DJO");
        player.setSex("M");
        player.setCountry(srbCountry);
        player.setPicture("https://data.latelier.co/training/tennis_stats/resources/Djokovic.png");
        player.setRank(2);
        player.setPoints(2542);
        player.setWeight(80000);
        player.setHeight(188);
        player.setAge(31);
        ArrayList<Integer> last = new ArrayList<>();
        last.add(1);
        last.add(1);
        last.add(1);
        last.add(1);
        last.add(1);
        player.setLast(last);
        playerRepository.save(player);

        player = new Player();
        player.setFirstname("Venus");
        player.setLastname("Williams");
        player.setShortname("V.WIL");
        player.setSex("F");
        player.setCountry(usaCountry);
        player.setPicture("https://data.latelier.co/training/tennis_stats/resources/Venus.webp");
        player.setRank(52);
        player.setPoints(1105);
        player.setWeight(74000);
        player.setHeight(185);
        player.setAge(38);
        last.clear();
        last.add(1);
        last.add(0);
        last.add(1);
        last.add(0);
        last.add(0);
        player.setLast(last);
        playerRepository.save(player);

    }
}