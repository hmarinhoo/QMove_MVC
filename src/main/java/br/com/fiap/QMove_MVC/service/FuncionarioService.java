package br.com.fiap.QMove_MVC.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import br.com.fiap.QMove_MVC.model.Funcionario;
import br.com.fiap.QMove_MVC.repository.FuncionarioRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void register(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");

        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findByEmail(email);
        if (funcionarioExistente.isEmpty()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setEmail(email);
            funcionario.setNome(oAuth2User.getAttribute("name"));
            funcionario.setSenha("oauth2"); // senha dummy, não usada
            funcionarioRepository.save(funcionario);
        }
    }
}
