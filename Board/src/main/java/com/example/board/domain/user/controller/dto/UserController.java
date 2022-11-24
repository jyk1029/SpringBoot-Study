package com.example.board.domain.user.controller.dto;

import com.example.board.domain.user.controller.dto.request.SignUpRequest;
import com.example.board.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userSignUpService.execute(request);
    }
}
