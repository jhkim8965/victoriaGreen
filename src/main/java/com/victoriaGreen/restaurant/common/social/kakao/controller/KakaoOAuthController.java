package com.victoriaGreen.restaurant.common.social.kakao.controller;

import com.victoriaGreen.restaurant.common.social.kakao.domain.KakaoUserInfo;
import com.victoriaGreen.restaurant.common.social.kakao.service.KakaoOAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("kakao")
public class KakaoOAuthController {

    private final KakaoOAuthService kakaoAccountService;

    @GetMapping("/login")
    public String login() throws IOException {
        return kakaoAccountService.requestLogin();
    }

    @GetMapping("/login/callback")
    public void loginCallback(@RequestParam("code") String code) throws Exception{
        String accessToken = kakaoAccountService.getAccessToken(code);
        System.out.println("accessToken = " + accessToken);

        KakaoUserInfo kakaoUserInfo = kakaoAccountService.getUserInfo(accessToken);
        System.out.println("kakaoUserInfo = " + kakaoUserInfo.toString());

        // Deactivate an Access token.
        String logoutUserId = kakaoAccountService.requestLogout(accessToken);
        System.out.println("logoutUserId = " + logoutUserId);
    }
}
