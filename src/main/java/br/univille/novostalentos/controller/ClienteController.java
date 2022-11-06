package br.univille.novostalentos.controller;

import java.util.HashMap;

import javax.validation.Valid;

//import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.service.CidadeService;
//import br.univille.novostalentos.entity.Cliente;
//import br.univille.novostalentos.repository.ClienteRepository;
import br.univille.novostalentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ModelAndView index(){
        /*ArrayList<Cliente> listaClientes = new ArrayList<>();

        Cliente zezinho = new Cliente();
        zezinho.setId(1);
        zezinho.setNome("Zezinho");
        zezinho.setEndereco("Rua lalala, 100");
        zezinho.setSexo("Masculino");
        zezinho.setTelefone("5555-1234");

        listaClientes.add(zezinho);

        Cliente mariazinha = new Cliente();
        mariazinha.setId(2);
        mariazinha.setNome("Mariazinha");
        mariazinha.setEndereco("Rua lelele, 200");
        mariazinha.setSexo("Feminino");
        mariazinha.setTelefone("5555-4321");

        listaClientes.add(mariazinha);*/

        var listaClientes = service.getAll();

        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("cliente/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cliente cliente, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            var listaCidades = cidadeService.getAll();
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("cliente", cliente);
            dados.put("listaCidades", listaCidades);
            return new ModelAndView("cliente/form", dados);
        }
        service.save(cliente);

        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umCliente = service.findById(id);
        var listaCidades = cidadeService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente", umCliente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("cliente/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/clientes");
    }
}
