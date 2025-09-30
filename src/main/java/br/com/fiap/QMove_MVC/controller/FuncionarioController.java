package br.com.fiap.QMove_MVC.controller;

import br.com.fiap.QMove_MVC.model.Funcionario;
import br.com.fiap.QMove_MVC.repository.FuncionarioRepository;
import br.com.fiap.QMove_MVC.repository.SetorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", funcionarioRepository.findAll());
        return "funcionario/listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("setores", setorRepository.findAll());
        return "funcionario/form";
    }

    @PostMapping
    public String salvar(@Valid Funcionario funcionario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("setores", setorRepository.findAll());
            return "funcionario/form";
        }
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("setores", setorRepository.findAll());
        return "funcionario/form";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
        return "redirect:/funcionarios";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "funcionario/login"; // HTML do login
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
        @RequestParam String senha,
        Model model) {
        Funcionario funcionario = funcionarioRepository.findByEmail(email);
    
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            // login válido
            return "redirect:/funcionarios"; // manda para lista
        } else {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "funcionario/login"; // volta pro form com erro
        }
    }

}
