package com.github.leser.controller;


import com.github.leser.request.UsernameRequest;
import com.github.leser.response.UsernameResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class inputController {
    private String username;

    @PostMapping("/api/input")
    public void upload(@RequestBody UsernameRequest request){
        log.info("upload request:{}", request);
        username = request.getUsername();
    }
    @GetMapping("/api/input")
    public UsernameResponse download(){
        log.info("download...");
        return new UsernameResponse(username);
    }
}
