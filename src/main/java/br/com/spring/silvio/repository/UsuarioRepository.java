
package br.com.spring.silvio.repository;

import br.com.spring.silvio.entity.Usuario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Silvio Filipe
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNomeLikeIgnoreCase(String nome);

    Usuario findByEmail(String username);
    
    boolean existsByEmail(String email);
}
