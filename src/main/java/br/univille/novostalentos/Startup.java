package br.univille.novostalentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.novostalentos.entity.Usuario;
import br.univille.novostalentos.repository.UsuarioRepository;

@Component
public class Startup {
    @Autowired
    private UsuarioRepository repositorio;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        if(repositorio.findByNome("admin") == null){
            var adminUser = new Usuario();
            adminUser.setNome("admin");
            adminUser.setSenha("admin");
            repositorio.save(adminUser);
        }
    }
}