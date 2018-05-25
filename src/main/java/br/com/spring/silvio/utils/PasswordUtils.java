/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.spring.silvio.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author silvio
 */
public class PasswordUtils {

    private static final Logger logger = LoggerFactory.getLogger(PasswordUtils.class);

    public PasswordUtils() {
    }

    /**
     * Gera um hash utilizando BCrypt
     *
     * @param senha
     * @return
     */
    public static String gerarBCrypt(String senha) {
        if (senha == null) {
            return senha;
        }

        logger.info("Gerando o hash da senha com BCrypt");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(senha);
    }
}
