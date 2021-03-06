package br.edu.pds.piloto.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecutitySettings extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select usuarios.nome as username, usuarios.senha as password, 1 as enable from usuarios where nome=?")
	.authoritiesByUsernameQuery("select usuarios.nome as username, papeis.role as authority from permissoes inner join usuarios on usuarios.id=permissoes.usuario_id inner join papeis on papeis.id=permissoes.papel_id where usuarios.nome=?")
	.passwordEncoder(new BCryptPasswordEncoder());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/cadastrarEquipe2", "/salvarEquipe").permitAll().and()
		.csrf().disable().authorizeRequests()
		.antMatchers("/listarPapel", "/cadastrarPapel", "/salvarPapel", "/editarPapel","/excluirPapel").hasAuthority("papel")
		.antMatchers("/listarPermissao", "/cadastrarPermissao", "/salvarPermissao", "/editarPermissao", "/excluirPermissao").hasAuthority("permissao")
		.antMatchers("/listarUsuario", "/cadastrarUsuario", "/salvarUsuario", "/editarUsuario", "/excluirUsuario").hasAuthority("usuario")
		.antMatchers("/listarTabela", "/cadastrarTabela", "/salvarTabela", "/editarTabela", "/excluirTabela").hasAuthority("tabela")
		.antMatchers("/listarEquipe", "/editarEquipe", "/excluirEquipe").hasAuthority("equipe")
		.antMatchers("/areaAdmin").hasAuthority("admin")
		 .and().formLogin().loginPage("/login").permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 .logoutSuccessUrl("/areaAdmin").and().exceptionHandling().accessDeniedPage("/negarAcesso");
	}
}
