package com.qingjiao.qa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
    private long uid;

    private String nickname;

    private String url;

    private String bio;

    private double rating;
}
