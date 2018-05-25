/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package br.com.spring.silvio.config;

import br.com.spring.silvio.entity.Perfil;
import br.com.spring.silvio.entity.Usuario;
import br.com.spring.silvio.repository.PerfilRepository;
import br.com.spring.silvio.repository.UsuarioRepository;
import br.com.spring.silvio.utils.PasswordUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Silvio Filipe
 */
@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<Perfil> perfis = perfilRepository.findAll();

        if (perfis.isEmpty()) {
            perfilRepository.save(new Perfil("ROLE_ADMIN"));

            Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

            List<Perfil> perfisUsuario = new ArrayList<>();

            perfisUsuario.add(perfil);

            usuarioRepository.save(new Usuario("Silvio Filipe", perfisUsuario, "silvio.dionizio23@gmail.com", PasswordUtils.gerarBCrypt("123456")));
        }
    }

}
