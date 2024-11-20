package com.jae.nightevent;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ManualPassEncrypt {  
    public static void main(String[] args) {
        String pass = new BCryptPasswordEncoder().encode("pp");
        System.out.println(pass);
    }
}
