package com.victoriaGreen.restaurant.common.social.kakao.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class KakaoUserInfo {
    private Long id;
    private String connected_at;
    private KakaoAccount kakao_account;

    @Getter @Setter @ToString
    public static class KakaoAccount {
        private Boolean name_needs_agreement;
        private String name;
        private Boolean email_needs_agreement;
        private Boolean is_email_valid;
        private Boolean is_email_verified;
        private String email;
        private Boolean age_range_needs_agreement;
        private String age_range;
        private Boolean birthyear_needs_agreement;
        private String birthyear;
        private Boolean birthday_needs_agreement;
        private String birthday;
        private String birthday_type;
        private Boolean gender_needs_agreement;
        private String gender;
        private Boolean phone_number_needs_agreement;
        private String phone_number;
    }
}
