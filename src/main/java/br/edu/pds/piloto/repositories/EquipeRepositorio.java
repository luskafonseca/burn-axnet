package br.edu.pds.piloto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.pds.piloto.domains.Equipe;

public interface EquipeRepositorio extends JpaRepository<Equipe, Long> {

}
