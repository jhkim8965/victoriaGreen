package com.victoriaGreen.restaurant.module.member.repository;

import com.victoriaGreen.restaurant.module.member.domain.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mysqlMemberRepository")
public class MysqlMemberRepository implements MemberRepository{
    @Override
    public Boolean save(Member member) {
        return null;
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
