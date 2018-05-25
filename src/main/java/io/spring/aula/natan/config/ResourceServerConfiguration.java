/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.aula.natan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) {
        resource.resourceId("restservice");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/usuario/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN")
                .anyRequest().denyAll();
    }

}
