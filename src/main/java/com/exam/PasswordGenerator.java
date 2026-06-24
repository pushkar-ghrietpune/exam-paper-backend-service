package com.exam;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        String password =

                encoder.encode(

                        "ProfuzAdmin@2026");

        System.out.println(

                password);

    }

}