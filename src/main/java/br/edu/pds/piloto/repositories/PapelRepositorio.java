package br.edu.pds.piloto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.pds.piloto.domains.Papel;


public interface PapelRepositorio extends JpaRepository<Papel, Long> {

}
