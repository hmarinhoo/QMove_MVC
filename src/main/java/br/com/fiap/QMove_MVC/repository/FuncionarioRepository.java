package br.com.fiap.QMove_MVC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.QMove_MVC.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);

}
