package com.alafourcadev.portfoliojavaweb.repositories;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Portfolio Repository in charge of interaction with the database
 */
public interface PortFolioRepository extends JpaRepository<Portfolio, Long> {

    Optional<Portfolio> findByTwitterUserName(String username);
}
