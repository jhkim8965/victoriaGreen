package com.victoriaGreen.restaurant.common.social.kakao.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KakaoResponseAccessToken {
    private String token_type;
    private String access_token;
    private String id_token;
    private int expires_in;
    private String refresh_token;
    private int refresh_token_expires_in;
    private String scope;
}
