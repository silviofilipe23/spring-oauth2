/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package br.com.spring.silvio.repository;

import br.com.spring.silvio.entity.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Silvio Filipe
 */
public interface PerfilRepository extends MongoRepository<Perfil, String> {

    Perfil findByNome(String role_admin);

}
