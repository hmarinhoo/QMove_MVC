package br.com.fiap.QMove_MVC.repository;

import br.com.fiap.QMove_MVC.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
}
