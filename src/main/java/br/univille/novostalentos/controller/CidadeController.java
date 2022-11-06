package br.univille.novostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Cidade;
//import br.univille.novostalentos.repository.CidadeRepository;
import br.univille.novostalentos.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;
    
    @GetMapping
    public ModelAndView index(){
        var listaCidades = service.getAll();

        return new ModelAndView("cidade/index", "listaCidades", listaCidades);
    }

    @GetMapping("/nova")
    public ModelAndView nova(){
        var cidade = new Cidade();
        return new ModelAndView("cidade/form", "cidade", cidade);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Cidade cidade){
        service.save(cidade);
        return new ModelAndView("redirect:/cidades");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaCidade = service.findById(id);
        return new ModelAndView("cidade/form", "cidade", umaCidade);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/cidades");
    }
}
