package com.victoriaGreen.restaurant.module.member.service;

import com.victoriaGreen.restaurant.module.member.domain.Member;

public interface MemberService {
    public Boolean join(Member member);
    public Boolean joinWithKakao(Member member);
    public Boolean joinWithNaver(Member member);
    public Boolean joinWithGoogle(Member member);
    public Member findMember(Long memberId);
    public Member findLostMemberId(String name, String phoneNumber, String email);
    public Member generateTemporaryPassword(String name, String phoneNumber, String email);
    public Boolean login(Member member);
    public Boolean loginWithKakao(Member member);
    public Boolean loginWithNaver(Member member);
    public Boolean loginWithGoogle(Member member);
}
