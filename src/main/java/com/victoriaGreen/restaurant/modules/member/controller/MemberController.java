package com.victoriaGreen.restaurant.modules.member.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@Log4j2
@RequestMapping("member")
public class MemberController {

    @GetMapping("/login")
    public void login() throws IOException {
        System.out.println("============> login called");

        String destination = "https://kauth.kakao.com/oauth/authorize?response_type="
                + "code&client_id=" + "e2a6f9c8a3605c165ca74cf010835e4a"
                + "&redirect_uri=" + "http://localhost:9948/member/answer"
                + "&scope=" + "gender,age_range";

        URL url = new URL(destination);
        System.out.println("destination = " + destination);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);

        String newUrl = connection.getHeaderField("Location");
        System.out.println(newUrl);
    }

    @RequestMapping(value = "/answer", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public void answer(@RequestParam("code") String code, HttpSession session) throws IOException{
        System.out.println("============> answer called");
    }

    @GetMapping(value = "/aaa")
    public String kakaoConnect() {
        StringBuffer url = new StringBuffer();
        url.append("https://kauth.kakao.com/oauth/authorize?");
        url.append("&response_type=code");
        url.append("&client_id=" + "e2a6f9c8a3605c165ca74cf010835e4a");
        url.append("&redirect_uri=http://localhost:9948/member/answer");
        url.append("&scope=gender,age_range");

        return "redirect:" + url;
    }
}
