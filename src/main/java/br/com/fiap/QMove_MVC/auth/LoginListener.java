package br.com.fiap.QMove_MVC.auth;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.user.OAuth2User;

import br.com.fiap.QMove_MVC.service.FuncionarioService;

public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent>{
    private final FuncionarioService funcionarioService;
    
    public LoginListener(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        funcionarioService.register((OAuth2User) event.getAuthentication().getPrincipal());
    }
}
