package com.enchi.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {


    private RedirectStrategy redirectStrategy =  new DefaultRedirectStrategy();

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }


    protected String determineTargetUrl(Authentication authentication) {
        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : authorities){
            roles.add(authority.getAuthority());
        }

        System.out.println(roles);

        if (roles.contains("USER")){
            url = "/user";
        }else if (roles.contains("ADMIN")){
            url = "/admin";
        }else{
            url = "/accessDenied";
        }
        System.out.println("url:"+url);
        return url;


    }
}
