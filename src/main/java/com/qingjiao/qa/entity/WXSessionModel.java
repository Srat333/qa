package com.qingjiao.qa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class WXSessionModel {

    private String session_key;
    private String openid;
}

