package com.victoriaGreen.restaurant.modules.member.repository;

import com.victoriaGreen.restaurant.modules.member.domain.Member;

public interface MemberRepository {
    public Boolean save(Member member);

    public Member findMemberByPhonenumber(int phoneNumber);

    public Member findMemberByEmail(String email);
}
