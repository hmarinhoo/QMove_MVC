package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Moto;
import br.com.fiap.QMove_MVC.model.Setor;
import br.com.fiap.QMove_MVC.repository.MotoRepository;
import br.com.fiap.QMove_MVC.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DetalhesController {

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private MotoRepository motoRepository;

    @GetMapping("/detalhes")
    public String detalhes(Model model) {
        Map<String, List<Moto>> veiculosPorSetor = new HashMap<>();

        List<Setor> setores = setorRepository.findAll();
        for (Setor setor : setores) {
            List<Moto> motos = motoRepository.findBySetor(setor);
            veiculosPorSetor.put(setor.getNome(), motos);
        }

        model.addAttribute("veiculosPorSetor", veiculosPorSetor);
        model.addAttribute("conteudo", "detalhes :: conteudo"); // fragmento da página
        return "layout"; // sempre retorna layout
    }

}
