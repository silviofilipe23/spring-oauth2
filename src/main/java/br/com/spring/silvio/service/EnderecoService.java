/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spring.silvio.service;

import br.com.spring.silvio.entity.Endereco;
import br.com.spring.silvio.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author silvio
 */
@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;
    
    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

}
