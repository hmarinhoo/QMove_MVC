package br.com.fiap.QMove_MVC.service;

import org.springframework.stereotype.Service;

import br.com.fiap.QMove_MVC.model.Qrcode;
import br.com.fiap.QMove_MVC.repository.QrcodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QrcodeService {

    private final QrcodeRepository qrCodeRepository;

    public QrcodeService(QrcodeRepository qrCodeRepository) {
        this.qrCodeRepository = qrCodeRepository;
    }

    public List<Qrcode> findAll() {
        return qrCodeRepository.findAll();
    }

    public Optional<Qrcode> findById(Long id) {
        return qrCodeRepository.findById(id);
    }

    public Qrcode save(Qrcode qrcode) {
        return qrCodeRepository.save(qrcode);
    }

    public void deleteById(Long id) {
        qrCodeRepository.deleteById(id);
    }
}
