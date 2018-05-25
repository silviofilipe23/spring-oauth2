/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package br.com.spring.silvio.controller;

import br.com.spring.silvio.entity.Endereco;
import br.com.spring.silvio.entity.Usuario;
import br.com.spring.silvio.response.Response;
import br.com.spring.silvio.service.EnderecoService;
import br.com.spring.silvio.service.UsuarioService;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EnderecoService enderecoService;

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
    public ResponseEntity<Response<Usuario>> salvar(@RequestBody Usuario usuario) {

        Response<Usuario> response = new Response<>();

        if (usuarioService.verificaEmail(usuario.getEmail())) {
            logger.info("Email já cadastrado!");
            
            response.getErrors().add("Email " + usuario.getEmail() + " já cadastrado!");
            return ResponseEntity.ok(response);
            
        } else {
            Endereco endereco = enderecoService.salvarEndereco(usuario.getEndereco());
            usuario.setEndereco(endereco);

            response.setData(this.usuarioService.salvarUsuario(usuario));
            return ResponseEntity.ok(response);
        }
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
