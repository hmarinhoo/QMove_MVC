package br.com.fiap.QMove_MVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.QMove_MVC.model.Setor;
import br.com.fiap.QMove_MVC.repository.SetorRepository;

@Service
public class SetorService {

    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

    public Optional<Setor> buscarPorId(Long id) {
        return setorRepository.findById(id);
    }

    public Setor salvar(Setor setor) {
        return setorRepository.save(setor);
    }

    public void excluir(Long id) {
        setorRepository.deleteById(id);
    }

    public Setor buscarPorNome(String nome) {
        return setorRepository.findByNome(nome);
    }
}