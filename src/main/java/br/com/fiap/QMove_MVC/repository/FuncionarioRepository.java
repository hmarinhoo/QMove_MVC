package br.com.fiap.QMove_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.QMove_MVC.model.Funcionario;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email);
}
