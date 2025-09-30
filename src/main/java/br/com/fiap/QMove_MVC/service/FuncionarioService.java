package br.com.fiap.QMove_MVC.service;

import br.com.fiap.QMove_MVC.model.Funcionario;
import br.com.fiap.QMove_MVC.repository.FuncionarioRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario register(OAuth2User user) {
        String email = user.getAttribute("email");
        Optional<Funcionario> optionalFuncionario = Optional.of(funcionarioRepository.findByEmail(email));

        if (optionalFuncionario.isEmpty()) {
            Funcionario novoFuncionario = new Funcionario();
            novoFuncionario.setEmail(email);
            novoFuncionario.setNome(user.getAttribute("name"));
            return funcionarioRepository.save(novoFuncionario);
        } else {
            Funcionario funcionarioExistente = optionalFuncionario.get();
            // Atualize outros dados se quiser, por exemplo o nome:
            funcionarioExistente.setNome(user.getAttribute("name"));
            return funcionarioRepository.save(funcionarioExistente);
        }
    }
}
