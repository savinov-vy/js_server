package com.example.js_server.controller;

import com.example.js_server.dto.Menu;
import com.example.js_server.dto.Request;
import com.example.js_server.service.JsonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class ServerController {

    private JsonService jsonService;

    @PostMapping(value = "/request")
    public ResponseEntity<Request> postForm(@ModelAttribute Request request) {
        System.out.println(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PostMapping(value = "/request/json")
    public ResponseEntity<Request> postRequest(@RequestBody Request form) throws IOException {
        jsonService.saveRequest(form);
        return new ResponseEntity<>(form, HttpStatus.OK);
    }
    @PostMapping(value = "/menu/json")
    public ResponseEntity<Menu> postMenu(@RequestBody Menu menu) throws IOException {
        jsonService.saveMenu(menu);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

}
