package com.victoriaGreen.restaurant.common.exception;

/**
 * 액세스 토큰 발급 중 에러가 발생한 경우
 */
public class OAuthAccessTokenException extends Exception {
    public OAuthAccessTokenException() {
        super();
    }

    public OAuthAccessTokenException(String message) {
        super(message);
    }

    public OAuthAccessTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
