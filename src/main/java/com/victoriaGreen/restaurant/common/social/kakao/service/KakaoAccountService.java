package com.victoriaGreen.restaurant.common.social.kakao.service;

import org.springframework.stereotype.Service;

public interface KakaoAccountService {
    public String requestLogin();

    public String getAccessToken(String code);
}
