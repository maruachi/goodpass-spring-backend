package com.goodchalk.goodpass.exception;

import java.io.IOException;

public class GoodPassSystemException extends RuntimeException {
    public GoodPassSystemException(Exception e) {
        super(e);
    }
}
