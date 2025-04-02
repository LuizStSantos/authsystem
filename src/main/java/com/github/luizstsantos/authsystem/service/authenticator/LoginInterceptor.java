package com.github.luizstsantos.authsystem.service.authenticator;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.lang.NonNull;
import com.github.luizstsantos.authsystem.service.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        
    if (CookieService.getCookie(request,  "userId") != null) {
        return true;
    }

    response.sendRedirect("/login");
    return false;
    }
    
}
