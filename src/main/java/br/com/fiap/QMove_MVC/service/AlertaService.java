package br.com.fiap.QMove_MVC.service;

import br.com.fiap.QMove_MVC.model.Alerta;
import br.com.fiap.QMove_MVC.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;

    public AlertaService(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    public List<Alerta> findAll() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> findById(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta save(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public void deleteById(Long id) {
        alertaRepository.deleteById(id);
    }
}
