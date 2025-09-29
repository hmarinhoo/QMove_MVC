package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Alerta;
import br.com.fiap.QMove_MVC.repository.AlertaRepository;
import br.com.fiap.QMove_MVC.repository.MotoRepository;
import br.com.fiap.QMove_MVC.repository.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private MotoRepository motoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alertas", alertaRepository.findAll());
        return "alerta/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("alerta", new Alerta());
        model.addAttribute("setores", setorRepository.findAll());
        model.addAttribute("motos", motoRepository.findAll());
        return "alerta/form";
    }

    @PostMapping
    public String salvar(@Valid Alerta alerta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("setores", setorRepository.findAll());
            model.addAttribute("motos", motoRepository.findAll());
            return "alerta/form";
        }
        alertaRepository.save(alerta);
        return "redirect:/alertas";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Alerta alerta = alertaRepository.findById(id).orElseThrow();
        model.addAttribute("alerta", alerta);
        model.addAttribute("setores", setorRepository.findAll());
        model.addAttribute("motos", motoRepository.findAll());
        return "alerta/form";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        alertaRepository.deleteById(id);
        return "redirect:/alertas";
    }
}
