/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spring.silvio.repository;

import br.com.spring.silvio.entity.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author silvio
 */
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
    
    
    
}
