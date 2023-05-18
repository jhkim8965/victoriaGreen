package com.victoriaGreen.restaurant.common.social.kakao.service;

import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoOAuth;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KakaoAccountServiceImpl implements KakaoAccountService {
    @Override
    public String requestLogin() {
        StringBuffer url = new StringBuffer();
        url.append("redirect:");
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("&response_type=code");
        url.append("&client_id=" + KakaoOAuth.REST_API_KEY);
        url.append("&redirect_uri=" + KakaoOAuth.REDIRECT_URI);
        url.append("&scope=gender,age_range");

        return url.toString();
    }

    @Override
    public String getAccessToken(String code) {
        // Request a AccessToken.
        WebClient webClient = WebClient.builder()
                .baseUrl("https://kauth.kakao.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        JSONObject response = webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/oauth/token")
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", KakaoOAuth.REST_API_KEY)
                        .queryParam("redirect_uri", KakaoOAuth.REDIRECT_URI)
                        .queryParam("code", code)
                        .build())
                .retrieve().bodyToMono(JSONObject.class).block();

        return (String)response.get("access_token");
    }
}
