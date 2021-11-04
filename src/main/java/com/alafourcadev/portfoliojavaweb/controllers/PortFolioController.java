package com.alafourcadev.portfoliojavaweb.controllers;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import com.alafourcadev.portfoliojavaweb.services.PortFolioService;
import org.springframework.data.domain.Page;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PortFolioController {

    private final PortFolioService portFolioService;


    public PortFolioController(PortFolioService portFolioService) {
        this.portFolioService = portFolioService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "idportfolio", "asc", model);
    }

    @GetMapping("/displayInformation/{id}")
    public String displayInformation(@PathVariable(value = "id") long id, Model model) {

        List<Tweet> tweetList = null;
        Portfolio portfolio = portFolioService.getPortfolioById(id);
        if (portfolio != null)
            tweetList = portFolioService.getAllTweetsFromUser(portfolio.getTwitterUserName());

        model.addAttribute("portfolio", portfolio);
        model.addAttribute("tweetList", tweetList);
        return "view_information";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Portfolio> page = portFolioService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Portfolio> portfolioList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("portfolioList", portfolioList);
        return "index";
    }
}
