package com.victoriaGreen.restaurant.common.social.kakao.controller;

import com.victoriaGreen.restaurant.common.social.kakao.service.KakaoAccountService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("kakao")
public class KakaoAccountController {

    private final KakaoAccountService kakaoAccountService;

    @GetMapping("/login")
    public String login() throws IOException {
        return kakaoAccountService.requestLogin();
    }

    @RequestMapping(value = "/login/callback", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public void loginCallback(@RequestParam("code") String code, HttpSession session) throws IOException{

        System.out.println("access_token = " + kakaoAccountService.getAccessToken(code));





//        // 카카오에 요청 보내기 및 응답 받기
//        WebClient webClient = WebClient.builder()
//                .baseUrl("https://kapi.kakao.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        JSONObject response = webClient.post()
//                .uri(uriBuilder -> uriBuilder.path("/v2/user/me").build())
//                .header("Authorization", "Bearer " + access_token)
//                .retrieve().bodyToMono(JSONObject.class).block();
//
//        // 받은 응답에서 원하는 정보 추출하기 (여기의 경우 회원 고유번호와 카카오 닉네임)
//        Integer id = (Integer) response.get("id");
//        Map<String, Object> map = (Map<String, Object>)response.get("kakao_account");
//        Map<String, Object> profile = (Map<String, Object>)map.get("profile");
//        String name = (String) profile.get("nickname");
//        // 추출한 정보로 원하는 처리를 함
    }

    @GetMapping(value = "/logout")
    public String kakaoLogout(HttpSession session) {
        String accessToken = (String) session.getAttribute("access_token");

        // 카카오에 요청 보내기
        WebClient webClient = WebClient.builder()
                .baseUrl("https://kapi.kakao.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        JSONObject response = webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/v1/user/logout").build())
                .header("Authorization", "Bearer " + accessToken)
                .retrieve().bodyToMono(JSONObject.class).block();

        // 로그아웃하면서 만료된 토큰을 세션에서 삭제
        session.removeAttribute("access_token");

        return "redirect:" + "초기화면 링크";
    }
}
