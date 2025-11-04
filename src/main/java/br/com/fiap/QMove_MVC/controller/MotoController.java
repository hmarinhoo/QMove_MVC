package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Moto;
import br.com.fiap.QMove_MVC.repository.MotoRepository;
import br.com.fiap.QMove_MVC.repository.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("motos", motoRepository.findAll());
        return "motos/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("moto", new Moto());
        model.addAttribute("setores", setorRepository.findAll());
        return "motos/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moto inválida"));
        model.addAttribute("moto", moto);
        model.addAttribute("setores", setorRepository.findAll());
        return "motos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Moto moto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("setores", setorRepository.findAll());
            return "motos/form";
        }
        motoRepository.save(moto);
        return "redirect:/motos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        motoRepository.deleteById(id);
        return "redirect:/motos";
    }
}
