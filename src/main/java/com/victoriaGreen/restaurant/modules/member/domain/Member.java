package com.victoriaGreen.restaurant.modules.member.domain;

import com.victoriaGreen.restaurant.modules.member.domain.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Member {
    Long id;
    String name;
    int phoneNumber;
    String email;
    Gender gender;
}
