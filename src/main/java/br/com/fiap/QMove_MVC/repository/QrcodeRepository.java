package br.com.fiap.QMove_MVC.repository;

import br.com.fiap.QMove_MVC.model.Qrcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrcodeRepository extends JpaRepository<Qrcode, Long> {
}