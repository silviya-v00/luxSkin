package com.ss.luxSkin.controllers;


public interface ErrorController {
    default String getErrorPath() {
        return null;
    }
}
