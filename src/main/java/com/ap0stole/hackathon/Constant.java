package com.ap0stole.hackathon;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public final static String API_KEY = "nmWU1ndR17sf9fTmmi2VbyEAFzxMjUQulYt9u9hz3xuzaVPciy9cl1l46Gin";
    @UtilityClass
    public class Authentication {
        public static final String ACCESS_DENIED = "access_denied";
        public static final String UNAUTHORIZED_ACCESS = "unauthorized_access";
        public static final String BAD_CREDENTIALS = "bad_credentials";
        public static final String ACCOUNT_LOCKED = "account_locked";
    }

    @UtilityClass
    public class Common {
        public static final String OBJECT_NOT_FOUND = "object_not_found";
        public static final String OBJECT_ALREADY_EXISTS = "object_already_exists";
        public static final String SERVER_ERROR = "server_error";
        public static final String NOT_SUPPORTED = "not_supported";
        public static final String NOT_IMPLEMENTED = "not_implemented";
        public static final String VALIDATION_FAILED = "validation_failed";
        public static final String TYPE_MISMATCH = "type_mismatch";

    }

    @UtilityClass
    public class Header {
        public static final String HEADER_AUTHORIZATION_BEARER = "Bearer ";
        public static final String HEADER_AUTH_TOKEN = "authToken";
        public static final String HEADER_REFRESH_TOKEN = "refreshToken";
    }

    @UtilityClass
    public class User {
        public static final String USER_NOT_FOUND = "user_not_found";
        public static final String USER_SUSPENDED = "user_suspended";
        public static final String USER_EMAIL_ALREADY_EXISTS = "user_email_already_exists";
        public static final String EMAIL_REQUIRED = "email_required";
        public static final String WRONG_EMAIL = "wrong_email";
        public static final String PASSWORD_REQUIRED = "password_required";
        public static final String PASSWORD_MISMATCH = "password_mismatch";
        public static final String PASSWORD_TOO_SHORT = "password_too_short";
        public static final String FIRST_NAME_REQUIRED = "first_name_required";
        public static final String LAST_NAME_REQUIRED = "last_name_required";
        public static final String ROLE_NOT_FOUND = "role_not_found";
    }


}
