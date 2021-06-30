package com.ss.luxSkin.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ErrorHandlerController implements ErrorController, com.ss.luxSkin.controllers.ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ResponseEntity<?> error(){
        return ResponseEntity.badRequest().body("Въвели сте грешен адрес!");
    }

    @Override
    public String getErrorPath() {
        return null;
    }

}
