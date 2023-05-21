package com.victoriaGreen.restaurant.module.member.repository;

import com.victoriaGreen.restaurant.module.member.domain.Member;

public interface MemberRepository {
    public Boolean save(Member member);

    public Member findMemberByPhonenumber(int phoneNumber);

    public Member findMemberByEmail(String email);
}
