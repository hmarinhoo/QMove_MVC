package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Setor;
import br.com.fiap.QMove_MVC.repository.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("setores", setorRepository.findAll());
        return "setor/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("setor", new Setor());
        return "setor/form";
    }

    @PostMapping
    public String salvar(@Valid Setor setor, BindingResult result) {
        if (result.hasErrors()) {
            return "setor/form";
        }
        setorRepository.save(setor);
        return "redirect:/setores";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Setor setor = setorRepository.findById(id).orElseThrow();
        model.addAttribute("setor", setor);
        return "setor/form";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        setorRepository.deleteById(id);
        return "redirect:/setores";
    }
}
