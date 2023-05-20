package com.victoriaGreen.restaurant.common.social.kakao.service;

import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoUserInfo;
import jakarta.servlet.http.HttpSession;

public interface KakaoOAuthService {
    public String requestLogin();
    public String requestLogout(String accessToken);
    public String getAccessToken(String code) throws Exception;
    public KakaoUserInfo getUserInfo(String accessToken);
}
