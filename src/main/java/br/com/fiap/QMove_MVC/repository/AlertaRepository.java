package br.com.fiap.QMove_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.QMove_MVC.model.Alerta;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
