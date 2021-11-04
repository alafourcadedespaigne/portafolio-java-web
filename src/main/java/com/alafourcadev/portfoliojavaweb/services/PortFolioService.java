package com.alafourcadev.portfoliojavaweb.services;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of portfolio related business services
 */
@Service
public interface PortFolioService {

    /**
     * Get all tweets from a user
     * @param username User whose tweets list you want to know
     * @return List containing the first 5 tweets
     */
   List<Tweet> getAllTweetsFromUser(String username);

    /**
     * Obtain all the information of the portfolio of a user given his username on twitter
     * @param user User whose information is needed
     * @return User portfolio information
     */
    Portfolio getPortfolioByTwitterUser(String user);

    /**
     * Update the information in the user portfolio. Only the description, title and summary of the experience will be updated
     * @param username User whose information is to be updated
     * @param newPortfolio Transfer entity with the information you want to update
     * @return Portfolio object with updated information
     */
    Portfolio updatePortFolio(String username, Portfolio newPortfolio);

    /**
     * Obtain portfolio information given its identifier
     * @param id Portfolio identifier
     * @return Portfolio object that matches the search criteria
     */
    Portfolio getPortfolioById(long id);


    Page<Portfolio> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
