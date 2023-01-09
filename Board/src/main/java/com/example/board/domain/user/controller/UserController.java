package com.example.board.domain.user.controller;

import com.example.board.domain.user.controller.dto.request.SignUpRequest;
import com.example.board.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@RequestMapping("/user") //요청을 특정 메서드와 매핑하기 위해 사용, 공통적인 url 설정
@RestController //ResponseBody(json, xml과 같은 데이터를 return) + Controller(Controller의 역할을 한다고 명시하기 위해 사용하는 Annotation)
public class UserController {
    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED) //HTTP 상태코드 설정 : 201 CREATED
    @PostMapping("/signup") //Method 설정 어노테이션
    public void signUp(@RequestBody @Valid SignUpRequest request) { //@RequestBody : HttpRequest의 requestBody의 내용을 자바 객체로 매핑, @Valid : 유효성 검사
        userSignUpService.execute(request);
    }
}
