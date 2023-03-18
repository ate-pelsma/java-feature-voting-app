package com.projectfeaturevoting.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Entity
@Embeddable
public class Votes {

    private Boolean isUpvote;
}
