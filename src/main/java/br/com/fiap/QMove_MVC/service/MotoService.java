package br.com.fiap.QMove_MVC.service;

import br.com.fiap.QMove_MVC.model.Moto;
import br.com.fiap.QMove_MVC.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    public Optional<Moto> findById(Long id) {
        return motoRepository.findById(id);
    }

    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

    public void deleteById(Long id) {
        motoRepository.deleteById(id);
    }
}
