package com.victoriaGreen.restaurant.common.social.kakao.service;

import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoOAuth;
import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoResponseAccessToken;
import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoUserInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Service
public class KakaoOAuthServiceImpl implements KakaoOAuthService {
    @Override
    public String requestLogin() {
        StringBuffer url = new StringBuffer();
        url.append("redirect:");
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("&response_type=code");
        url.append("&client_id=" + KakaoOAuth.REST_API_KEY);
        url.append("&redirect_uri=" + KakaoOAuth.REDIRECT_URI);
//        url.append("&scope=gender,age_range");

        return url.toString();
    }

    @Override
    public String requestLogout(String accessToken) {
        String logoutUserId = WebClient.create()
                .post()
                .uri("https://kapi.kakao.com/v1/user/logout")
                .headers(header -> {
                    header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    header.add("Authorization", "Bearer " + accessToken);
                })
                .retrieve()
                .bodyToMono(String.class).block();

        return logoutUserId;
    }

    @Override
    public String getAccessToken(String code) throws Exception{
        WebClient webClient = WebClient.builder()
                .baseUrl("https://kauth.kakao.com")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                    httpHeaders.set(HttpHeaders.ACCEPT_CHARSET, "UTF-8");})
                .build();

        KakaoResponseAccessToken kakaoResponseAccessToken = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/oauth/token")
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", KakaoOAuth.REST_API_KEY)
                        .queryParam("redirect_uri", KakaoOAuth.REDIRECT_URI)
                        .queryParam("code", code)
                        .build())
//                .body(BodyInserters.fromFormData("grant_type", "authorization_code")
//                        .with("client_id", KakaoOAuth.REST_API_KEY)
//                        .with("redirect_uri", KakaoOAuth.REDIRECT_URI)
//                        .with("code", code))
                .retrieve().bodyToMono(KakaoResponseAccessToken.class)
                .timeout(Duration.ofMillis(1000))
                .blockOptional().orElseThrow(() -> new Exception("Kakao Access 토큰을 가져오는데 실패 하였습니다."));

        return kakaoResponseAccessToken.getAccess_token();
    }

    @Override
    public KakaoUserInfo getUserInfo(String accessToken) {
        KakaoUserInfo kakaoUserInfo = WebClient.create()
                .get()
                .uri("https://kapi.kakao.com/v2/user/me")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(KakaoUserInfo.class).block();

        return kakaoUserInfo;
    }
}
