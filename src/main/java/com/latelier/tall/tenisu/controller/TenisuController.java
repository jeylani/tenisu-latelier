package com.latelier.tall.tenisu.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latelier.tall.tenisu.dto.PlayerDto;
import com.latelier.tall.tenisu.model.Country;
import com.latelier.tall.tenisu.model.Player;
import com.latelier.tall.tenisu.repository.CountryRepository;
import com.latelier.tall.tenisu.repository.PlayerRepository;

@RestController
@RequestMapping("/api")
public class TenisuController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/players")
    public List<Player> findAllPlayers() {
        return (List<Player>) playerRepository.findAll(Sort.by(Sort.Direction.ASC, "rank"));
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> findPlayerById(@PathVariable(value = "id") long id){
        return playerRepository.findById(id)
        .map(player -> ResponseEntity.ok().body(player))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/players")
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerDto playerDto) {
        return createPlayer(playerDto)
        .map(player -> ResponseEntity.ok().body(playerRepository.save(player)))
        .orElse(ResponseEntity.badRequest().build());
    }

    private Optional<Player> createPlayer(PlayerDto playerDto) {
        return countryRepository.findById(playerDto.getCountryCode())
        .map(country -> modelMapper.map(playerDto, Player.class).setCountry(country));
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleException() {
        return ResponseEntity.internalServerError().body("Le serveur rencontre des difficultes!");
    }
}
