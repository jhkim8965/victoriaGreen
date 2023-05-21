package com.victoriaGreen.restaurant.common.social.kakao.service;

import com.victoriaGreen.restaurant.common.exception.OAuthAccessTokenException;
import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoUserInfo;
import jakarta.servlet.http.HttpSession;

public interface KakaoOAuthService {
    /**
     * 인가코드 받아오기
     * @return 인가코드
     */
    public String getAuthorizationCode();

    /**
     * 액세스 토큰 받아오기
     * @param code
     * @return 액세스 토큰
     * @throws Exception
     */
    public String getAccessToken(String code) throws OAuthAccessTokenException;

    /**
     * 유저 정보 가져오기
     * @param accessToken
     * @return
     */
    public KakaoUserInfo getUserInfo(String accessToken);
}