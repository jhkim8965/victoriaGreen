package com.victoriaGreen.restaurant.modules.member.service;

import com.victoriaGreen.restaurant.modules.member.domain.Member;
import com.victoriaGreen.restaurant.modules.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
//    private final SmsMessageService smsMessageService;
//    private final KakaoMessageService kakaoMessageService;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(@Qualifier("memoryMemberRepository") MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Boolean join(Member member) { return null; }

    @Override
    public Boolean joinWithKakao(Member member) {
        return null;
    }

    @Override
    public Boolean joinWithNaver(Member member) {
        return null;
    }

    @Override
    public Boolean joinWithGoogle(Member member) {
        return null;
    }

    @Override
    public Member findMember(Long memberId) {
        return null;
    }

    @Override
    public Member findLostMemberId(String name, String phoneNumber, String email) {
        return null;
    }

    @Override
    public Member generateTemporaryPassword(String name, String phoneNumber, String email) {
        return null;
    }

    @Override
    public Boolean login(Member member) {
        return true;
    }

    @Override
    public Boolean loginWithKakao(Member member) {
        return null;
    }

    @Override
    public Boolean loginWithNaver(Member member) {
        return null;
    }

    @Override
    public Boolean loginWithGoogle(Member member) {
        return null;
    }
}
