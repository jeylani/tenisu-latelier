package com.latelier.tall.tenisu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.latelier.tall.tenisu.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {}
