package com.box.SocNet.security;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String email;
    private String password;

}