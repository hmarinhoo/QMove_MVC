package br.com.fiap.QMove_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.QMove_MVC.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}