package com.victoriaGreen.restaurant.modules.member.repository;

import com.victoriaGreen.restaurant.modules.member.domain.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("memoryMemberRepository")
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Boolean save(Member member) {
        store.put(member.getId(), member);
        return true;
    }

    @Override
    public Member findMemberByPhonenumber(int phoneNumber) {
        return null;
    }

    @Override
    public Member findMemberByEmail(String email) {
        return null;
    }
}
