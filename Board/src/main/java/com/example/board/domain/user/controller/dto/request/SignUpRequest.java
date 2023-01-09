package com.example.board.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor //
public class SignUpRequest {

    @NotBlank(message = "계정 아이디는 Null, 공백, 띄어쓰기를 허용하지 않습니다.") //NotBlank(Null, "", " ") > NotEmpty(Null, "") > NuoNull(Null)
    @Size(min = 8, max = 16, message = "최소 8자 ~ 최대 16자까지 가능합니다.")
    private String accountId;

    @NotBlank(message = "비밀번호은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$") //비밀번호 정규식(
    @Size(min = 8, max = 16, message = "최소 8자 ~ 최대 16자까지 가능합니다.")
    private String password;

    @NotBlank(message = "이름은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 2, max = 5, message = "최소 8자 ~ 최대 16자까지 가능합니다.")
    private String name;

    @NotBlank(message = "이메일은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") //이메일 정규식
    @Size(min = 4, max = 64, message = "최소 4자 ~ 최대 64자까지 가능합니다.")
    private String email;
}
