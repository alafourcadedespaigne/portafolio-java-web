package com.alafourcadev.portfoliojavaweb.services;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import com.alafourcadev.portfoliojavaweb.repositories.PortFolioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PortFolioServiceImpl implements PortFolioService {

    private final PortFolioRepository portFolioRepository;
    private final Twitter twitter;

    public PortFolioServiceImpl(PortFolioRepository portFolioRepository, Twitter twitter) {
        this.portFolioRepository = portFolioRepository;
        this.twitter = twitter;
    }

    @Override
    public List<Tweet> getAllTweetsFromUser(String username) {

        try {
            List<Tweet> publicTimeline = twitter.timelineOperations().getUserTimeline(username);
            return publicTimeline.stream().limit(5).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }


    @Override
    public Portfolio getPortfolioByTwitterUser(String user) {
        Optional<Portfolio> optional = portFolioRepository.findByTwitterUserName(user);
        Portfolio portfolio;
        if (optional.isEmpty()) {
            throw new RuntimeException(" Portfolio not found for username :: " + user);
        } else {
            portfolio = optional.get();
        }
        return portfolio;
    }


    @Override
    public Portfolio updatePortFolio(String username, Portfolio newPortfolio) {

        Portfolio portfolio = portFolioRepository.findByTwitterUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio twitter user", username));

        portfolio.setDescription(newPortfolio.getDescription());
        portfolio.setTitle(newPortfolio.getTitle());
        portfolio.setExperienceSummary(newPortfolio.getExperienceSummary());

        Portfolio updatedPortfolio = portFolioRepository.save(portfolio);
        return updatedPortfolio;

    }

    @Override
    public Portfolio getPortfolioById(long id) {
        Optional<Portfolio> optional = portFolioRepository.findById(id);
        Portfolio portfolio;
        if (optional.isEmpty()) {
            throw new RuntimeException(" Portfolio not found for id :: " + id);
        } else {
            portfolio = optional.get();
        }
        return portfolio;
    }

    @Override
    public Page<Portfolio> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.portFolioRepository.findAll(pageable);
    }
}
