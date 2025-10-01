package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Moto;
import br.com.fiap.QMove_MVC.repository.SetorRepository;
import br.com.fiap.QMove_MVC.service.MotoService;
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
    private MotoService motoService;

    @Autowired
    private SetorRepository setorRepository;

    // LISTAR MOTOS
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("motos", motoService.findAll());
        return "moto/listar"; // -> resources/templates/moto/listar.html
    }

    // FORM NOVA MOTO
    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("moto", new Moto());
        model.addAttribute("setores", setorRepository.findAll());
        model.addAttribute("conteudo", "motos/form :: conteudo");
        return "layout"; 
    }

    // SALVAR
    @PostMapping
    public String salvar(@Valid Moto moto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("setores", setorRepository.findAll());
            return "moto/form";
        }
        motoService.save(moto);
        return "redirect:/motos";
    }

    // EDITAR
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Moto moto = motoService.findById(id).orElseThrow();
        model.addAttribute("moto", moto);
        model.addAttribute("setores", setorRepository.findAll());
        return "moto/form";
    }

    // EXCLUIR
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        motoService.deleteById(id);
        return "redirect:/motos";
    }
}
