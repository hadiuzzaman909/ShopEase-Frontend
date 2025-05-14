package com.example.shopease.authentication.exception;

import com.example.shopease.authentication.dto.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    public static final String BAD_REQUEST_CODE = "BAD_REQUEST";
    public static final String NOT_FOUND_CODE = "NOT_FOUND";
    public static final String EXPIRED_CODE = "EXPIRED";
    public static final String NOT_AUTHORIZED_CODE = "NOT_AUTHENTICATED";
    public static final String FORBIDDEN_CODE = "NOT_AUTHORIZED";
    public static final String NOT_VERIFIED_CODE = "NOT_VERIFIED";
    public static final String AUTHENTICATION_EXCEPTION_MESSAGE = "Not authenticated";
    public static final String AUTHORIZATION_EXCEPTION_MESSAGE = "Not authorized";
    public static final String ACCOUNT_LOCKED = "ACCOUNT LOCKED";

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException exception) {
        log.warn("Functional error occurred (not authenticated).", exception);
        String code = NOT_AUTHORIZED_CODE;
        /* We mapped isEnabled(UserDetails) attribute to isVerified(User) attribute in UserDetailsImpl class. */
        if (exception.getMessage().equals("User is disabled")) {
            code = NOT_VERIFIED_CODE;
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse(code, AUTHENTICATION_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException exception) {
        log.warn("Functional error occurred (not authorized).", exception);
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorResponse(FORBIDDEN_CODE, AUTHORIZATION_EXCEPTION_MESSAGE));
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception) {
        log.warn("Validation error; request object does not meet conditions.", exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(BAD_REQUEST_CODE, exception.getMessage()));
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        log.warn("Functional error occurred; object cannot be found.", exception);
        if (exception.getMessage().equals("USER EMAIL NOT FOUND FOR LOGIN")){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(NOT_AUTHORIZED_CODE, AUTHENTICATION_EXCEPTION_MESSAGE));
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(NOT_FOUND_CODE, exception.getMessage()));
    }

    @ExceptionHandler(value = EmailException.class)
    public ResponseEntity<ErrorResponse> handleEmailException(EmailException exception) {
        log.warn("Functional error occurred; failed to send mail.", exception);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(BAD_REQUEST_CODE, exception.getMessage()));
    }

    @ExceptionHandler(value = AccountLockedException.class)
    public ResponseEntity<ErrorResponse> handleAccountLockedException(AccountLockedException exception) {
        log.warn("Functional error occurred; account locked.", exception);
        return ResponseEntity
                .status(HttpStatus.LOCKED)
                .body(new ErrorResponse(ACCOUNT_LOCKED, exception.getMessage()));
    }

    @ExceptionHandler(value = ExpiredException.class)
    public ResponseEntity<ErrorResponse> handleExpiredException(ExpiredException exception) {
        log.warn("Functional error occurred; value expired.", exception);
        return ResponseEntity
                .status(HttpStatus.GONE)
                .body(new ErrorResponse(EXPIRED_CODE, exception.getMessage()));
    }
}