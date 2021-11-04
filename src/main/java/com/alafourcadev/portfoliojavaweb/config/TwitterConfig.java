package com.alafourcadev.portfoliojavaweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Class that stores the configuration that belongs to Twitter
 */

@Configuration
public class TwitterConfig {
    @Value("${spring.social.twitter.appId}")
    private String consumerKey;
    @Value("${spring.social.twitter.appSecret}")
    private String consumerSecret;
    @Value("${twitter.access.token}")
    private String accessToken;
    @Value("${twitter.access.token.secret}")
    private String accessTokenSecret;

    @Bean
    TwitterTemplate getTwtTemplate(){
        return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }
}

