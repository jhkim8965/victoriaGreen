package com.victoriaGreen.restaurant.modules.member.controller;

import com.victoriaGreen.restaurant.modules.member.domain.Member;
import com.victoriaGreen.restaurant.modules.member.domain.enums.Gender;
import com.victoriaGreen.restaurant.modules.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberControllerTest {
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("Attempt to login")
    void login() {
        Member member = new Member.Builder()
                .setId(1L)
                .setName("홍김동")
                .setPhoneNumber("01012345678")
                .setGender(Gender.MALE)
                .setEmail("asdasd@asdasd.com")
                .build();

        Boolean result = memberService.login(member);
        System.out.println("result = " + result);
    }
}