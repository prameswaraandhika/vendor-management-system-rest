package org.prameswaradev.vendormanagementsystem.exception;

public class RefreshTokenExpiredException extends RuntimeException {
    public RefreshTokenExpiredException() {
        super("Refresh token expired");
    }

    public RefreshTokenExpiredException(String message) {
        super(message);
    }
}
