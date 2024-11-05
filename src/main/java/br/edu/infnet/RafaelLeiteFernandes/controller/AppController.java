package br.edu.infnet.RafaelLeiteFernandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.RafaelLeiteFernandes.model.service.LinhaProducaoService;

@Controller
public class AppController {
    
    @Autowired
    private LinhaProducaoService linhaProducaoService;
    
    @GetMapping(value = "/")
    public String telaHome(Model model) {
        return "home";
    }
}