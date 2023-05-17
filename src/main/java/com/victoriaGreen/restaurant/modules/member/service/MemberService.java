package com.victoriaGreen.restaurant.modules.member.service;

import com.victoriaGreen.restaurant.modules.member.domain.Member;

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
