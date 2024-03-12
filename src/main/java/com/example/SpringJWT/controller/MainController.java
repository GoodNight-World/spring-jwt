package com.example.SpringJWT.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Iterator;

@Controller
@ResponseBody
public class MainController {

    @GetMapping("/")
    public String mainP() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = authentication.getName();

        Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = collection.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        return "Main Controller : " + name + " / " + role;
    }

}
