package com.example.js_server.controller;

import com.example.js_server.dto.PhoneFormDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServerController {

    @PostMapping(value = "/request")
    public ResponseEntity<String> postForm(@ModelAttribute PhoneFormDto form) {
        System.out.println(form);
        return new ResponseEntity<>("Status is ok", HttpStatus.OK);
    }

    @PostMapping(value = "/request/json")
    public ResponseEntity<String> postFormJson(@RequestBody PhoneFormDto form) {
        System.out.println(form);
        return new ResponseEntity<>("Status is ok", HttpStatus.OK);
    }
}
