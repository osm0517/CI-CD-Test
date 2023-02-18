package com.example.dockerTest.controller;

import com.example.dockerTest.domain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public ResponseEntity<?> returnHello(){
        return new ResponseEntity<>(new domain("hello", 20), HttpStatus.OK);
    }

    @PostMapping("return")
    public ResponseEntity<?> returnContent(
            @RequestBody String content
    ){
        if(content == null){
            return new ResponseEntity<>("content is not null", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @GetMapping("hello-fail")
    public ResponseEntity<?> returnHelloFail(){
        return new ResponseEntity<>("hello-fail", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("bye")
    public ResponseEntity<?> returnBye(){
        return new ResponseEntity<>("bye", HttpStatus.OK);
    }
}
