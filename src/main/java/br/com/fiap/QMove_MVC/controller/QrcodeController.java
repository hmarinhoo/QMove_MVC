package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Qrcode;
import br.com.fiap.QMove_MVC.repository.QrcodeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/qrcodes")
public class QrcodeController {

    @Autowired
    private QrcodeRepository qrcodeRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("qrcodes", qrcodeRepository.findAll());
        return "qrcode/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("qrcode", new Qrcode());
        return "qrcode/form";
    }

    @PostMapping
    public String salvar(@Valid Qrcode qrcode, BindingResult result) {
        if (result.hasErrors()) {
            return "qrcode/form";
        }
        qrcodeRepository.save(qrcode);
        return "redirect:/qrcodes";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Qrcode qrcode = qrcodeRepository.findById(id).orElseThrow();
        model.addAttribute("qrcode", qrcode);
        return "qrcode/form";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        qrcodeRepository.deleteById(id);
        return "redirect:/qrcodes";
    }
}
