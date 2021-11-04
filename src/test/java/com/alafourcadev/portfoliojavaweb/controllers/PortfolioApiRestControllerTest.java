package com.alafourcadev.portfoliojavaweb.controllers;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import com.alafourcadev.portfoliojavaweb.services.PortFolioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PortfolioApiRestController.class)
class PortfolioApiRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PortFolioService portFolioService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    public Optional<Portfolio> createPortfolio001() {
        return Optional.of(Portfolio.builder()
                .description("2")
                .experienceSummary("2")
                .title("2").build());
    }

    @Test
    void getInformation() throws Exception {

        // Given
        when(portFolioService.getPortfolioByTwitterUser("DAENERYS")).thenReturn(createPortfolio001().get());

        // When
        mvc.perform(get("http://localhost:8080/portfolio/api/profile/DAENERYS").contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("2"))
                .andExpect(jsonPath("$.experienceSummary").value("2"))
                .andExpect(jsonPath("$.title").value("2"));

        verify(portFolioService).getPortfolioByTwitterUser("DAENERYS");
    }
}