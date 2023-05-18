package com.victoriaGreen.restaurant.modules.member.domain;

import com.victoriaGreen.restaurant.modules.member.domain.enums.Gender;

public class Member {
    private final Long id;
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final Gender gender;

    public static class Builder {

        private Long id;
        private String name;
        private String phoneNumber;
        private String email;
        private Gender gender;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    private Member(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.gender = builder.gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }
}
