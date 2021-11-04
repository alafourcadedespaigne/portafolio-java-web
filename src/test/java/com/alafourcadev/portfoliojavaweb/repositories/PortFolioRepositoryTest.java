package com.alafourcadev.portfoliojavaweb.repositories;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PortFolioRepositoryTest {

    @Autowired
    PortFolioRepository portFolioRepository;

    @Test
    public void findByTwitterUserName() {
        Optional<Portfolio> portfolio = portFolioRepository.findByTwitterUserName("DAENERYS");
        assertTrue(portfolio.isPresent());
        assertEquals("DAENERYS", portfolio.orElseThrow().getTwitterUserName());
    }
}