package br.edu.pds.piloto.domains;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tabelas")
public class Tabela {

	public Tabela() {
		
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;	
	private String nome;
	private int ponto;
	private int abate;
	private int boya;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPonto() {
		return ponto;
	}
	public void setPonto(int ponto) {
		this.ponto = ponto;
	}
	public int getAbate() {
		return abate;
	}
	public void setAbate(int abate) {
		this.abate = abate;
	}
	public int getBoya() {
		return boya;
	}
	public void setBoya(int boya) {
		this.boya = boya;
	}
	@Override
	public int hashCode() {
		return Objects.hash(abate, boya, id, nome, ponto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabela other = (Tabela) obj;
		return abate == other.abate && boya == other.boya && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && ponto == other.ponto;
	}
	
}

