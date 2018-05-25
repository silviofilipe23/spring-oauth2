/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.aula.natan.controller;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Silvio Filipe
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> listar() {
        return this.usuarioService.listaUsuario();
    }

    @GetMapping("/usuario/{id}")
    public Usuario getById(@PathVariable String id) {
        return this.usuarioService.getById(id);
    }

    @GetMapping("/usuario/{page}/{count}")
    public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count) {
        return this.usuarioService.listaPaginada(count, page);
    }

    @GetMapping("/usuario/{nome}/nome")
    public List<Usuario> listaPaginada(@PathVariable String nome) {
        return this.usuarioService.buscaPorNome(nome);
    }

    @PostMapping("/usuario")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/usuario")
    public Usuario editar(@RequestBody Usuario usuario) {
        return this.usuarioService.salvarUsuario(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void deletar(@PathVariable String id) {
        this.usuarioService.deleteUsuario(id);
    }

}
