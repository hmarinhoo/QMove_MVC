package br.com.fiap.QMove_MVC.auth;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import br.com.fiap.QMove_MVC.service.FuncionarioService;

@Component
public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final FuncionarioService userService;

    public LoginListener(FuncionarioService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        userService.register((OAuth2User) event.getAuthentication().getPrincipal());
    }
}

