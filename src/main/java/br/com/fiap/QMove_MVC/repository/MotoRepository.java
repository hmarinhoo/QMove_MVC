package br.com.fiap.QMove_MVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.QMove_MVC.model.Moto;
import br.com.fiap.QMove_MVC.model.Setor;

public interface MotoRepository extends JpaRepository<Moto, Long> {
    List<Moto> findBySetor(Setor setor);

}