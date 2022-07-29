/*package br.edu.pds.piloto.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.edu.pds.piloto.domains.Papel;
import br.edu.pds.piloto.domains.Permissao;
import br.edu.pds.piloto.domains.Usuario;
import br.edu.pds.piloto.repositories.PapelRepositorio;
import br.edu.pds.piloto.repositories.PermissaoRepositorio;
import br.edu.pds.piloto.repositories.UsuarioRepositorio;



@Component
public class InicializarDados implements CommandLineRunner{

@Autowired
private PapelRepositorio roleRepository;

@Autowired
private UsuarioRepositorio usuarioRepository;

@Autowired
private PermissaoRepositorio permissaoRepository;
@Override
public void run(String... args) throws Exception {



Papel role2 = new Papel();
role2.setNomeRole("tabela");
Papel role3 = new Papel();
role3.setNomeRole("admin");
Papel role4 = new Papel();
role4.setNomeRole("papel");
Papel role5 = new Papel();
role5.setNomeRole("usuario");
Papel role6 = new Papel();
role6.setNomeRole("equipe");
Papel role7 = new Papel();
role7.setNomeRole("permissao");

roleRepository.save(role2);
roleRepository.save(role3);
roleRepository.save(role4);
roleRepository.save(role5);
roleRepository.save(role6);
roleRepository.save(role7);


Usuario usuario1 = new Usuario();
usuario1.setNome("axnet");
usuario1.setSenha(new BCryptPasswordEncoder().encode("axnet8300"));
usuarioRepository.save(usuario1);


Permissao permissao2 = new Permissao();
permissao2.setPapel(role2);
permissao2.setUsuario(usuario1);
Permissao permissao3 = new Permissao();
permissao3.setPapel(role3);
permissao3.setUsuario(usuario1);
Permissao permissao4 = new Permissao();
permissao4.setPapel(role4);
permissao4.setUsuario(usuario1);
Permissao permissao5 = new Permissao();
permissao5.setPapel(role5);
permissao5.setUsuario(usuario1);
Permissao permissao6 = new Permissao();
permissao6.setPapel(role6);
permissao6.setUsuario(usuario1);
Permissao permissao7 = new Permissao();
permissao7.setPapel(role7);
permissao7.setUsuario(usuario1);


permissaoRepository.save(permissao2);
permissaoRepository.save(permissao3);
permissaoRepository.save(permissao4);
permissaoRepository.save(permissao5);
permissaoRepository.save(permissao6);
permissaoRepository.save(permissao7);


}

}*/
