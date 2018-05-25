/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package br.com.spring.silvio.service;

import br.com.spring.silvio.config.MyUserDetails;
import br.com.spring.silvio.entity.Usuario;
import br.com.spring.silvio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Silvio Filipe
 */
@Service
public class MyUserDetailService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException("Usuaŕio ou senha inválidos");
        }
        
        return new MyUserDetails(usuario);
        
    }
    
}
