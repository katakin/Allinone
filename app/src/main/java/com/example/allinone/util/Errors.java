package com.example.allinone.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import retrofit2.HttpException;

/**
 * Created by katakin on 22/07/17.
 */

public class Errors {
    public static final String CODE_PASSWORD_ERROR = "100001";
    public static final String CODE_USER_NOT_FOUND = "100002";
    public static final String CODE_USERNAME_ERROR = "100003";
    public static final String CODE_PASSWORD_TIMES = "100004";
    public static final String CODE_LOGIN_TIMES = "100005";
    public static final String CODE_SINGN_TIMEOUT = "100006";
    public static final String CODE_TOKEN_INVALID = "100007";
    public static final String CODE_VERIFICATION_CODE_INVALIDED = "100008";

    public static String errorMessage(Throwable throwable) {
        try {
            if (throwable instanceof ErrorException) {
                return getErrorMessage(new Gson().fromJson(throwable.getMessage(), ErrorResponse.class));
            } else if (throwable instanceof HttpException) {
                return getErrorMessage(errorResponse((HttpException) throwable));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return throwable.getMessage();
    }

    public static ErrorResponse errorResponse(HttpException throwable) throws Exception {
        String errorInfo = throwable.response().errorBody().string();
        JsonElement jsonElement = new JsonParser().parse(errorInfo);
        return new Gson().fromJson(jsonElement.getAsJsonObject().get("error"), ErrorResponse.class);
    }

    private static String getErrorMessage(ErrorResponse errorResponse) {
        String message = "Get the data error";
        String code = errorResponse.getCode();
        switch (code) {
            case CODE_PASSWORD_ERROR:
            case CODE_USERNAME_ERROR:
                message = "Username or password error";
                break;
            case CODE_USER_NOT_FOUND:
                message = "The user name does not exist";
                break;
            case CODE_PASSWORD_TIMES:
                message = "Wrong password number of times over the day limit";
                break;
            case CODE_LOGIN_TIMES:
                message = "Log on too often";
                break;
            case CODE_SINGN_TIMEOUT:
                message = "Request timeout";
                break;
            case CODE_TOKEN_INVALID:
                message = "Authentication failed, please re-login";
                break;
            case CODE_VERIFICATION_CODE_INVALIDED:
                message = "Phone verification code is invalid";
                break;
        }
        return message;
    }
}
