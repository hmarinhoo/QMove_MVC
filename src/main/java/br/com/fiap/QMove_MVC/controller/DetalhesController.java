package br.com.fiap.QMove_MVC.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.QMove_MVC.model.Moto;
import br.com.fiap.QMove_MVC.repository.MotoRepository;
import br.com.fiap.QMove_MVC.repository.SetorRepository;

@Controller
public class DetalhesController {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping("/detalhes")
    public String detalhes(Model model) {
        Map<String, List<Moto>> veiculosPorSetor = new HashMap<>();

        setorRepository.findAll().forEach(setor -> {
            List<Moto> motos = motoRepository.findBySetor(setor); 
            veiculosPorSetor.put(setor.getNome(), motos);
        });

        model.addAttribute("veiculosPorSetor", veiculosPorSetor);
        return "detalhes";
    }
}
