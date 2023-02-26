package ru.relex.cryptoexg.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AddUserRequestDto {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;
}
