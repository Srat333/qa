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
    private String uid;

    private String nickname;

    private int gender;

    private String url;

    private String city;

    private String country;
}
