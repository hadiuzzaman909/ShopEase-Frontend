package com.example.shopease.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Confirmation {

    RESET_PASSWORD("reset-password"),
    FORCE_CHANGE_PASSWORD("force-change-password"),
    OTP("otp"),
    LINK("link");

    private final String confirmationType;

}