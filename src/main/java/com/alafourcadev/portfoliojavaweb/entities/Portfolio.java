package com.alafourcadev.portfoliojavaweb.entities;

import lombok.*;

import javax.persistence.*;


/**
 * Domain class that handles the information regarding a user's portfolio
 */

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idportfolio;
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "twitter_user_name")
    private String twitterUserName;
    @Column(name = "title")
    private String title;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "experience_summary")
    private String experienceSummary;
    @Column(name = "last_names")
    private String lastNames;
    @Column
    private String names;
    @Column(name = "twitter_user_id")
    private String twitterUserId;

}
