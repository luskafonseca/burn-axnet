package br.edu.pds.piloto.domains;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="equipes2")
public class Equipe2 {

	public Equipe2() {
		
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	
	private Long id;
	@NotBlank(message = "Preencha o campo nome da equipe devidamente!!!")
	private String nome;
	@NotBlank(message = "Preencha o campo Jogador1 devidamente!!!")
	private String player1;
	@NotBlank(message = "Preencha o campo Jogador2 devidamente!!!")
	private String player2;
	@NotBlank(message = "Preencha o campo Jogador3 devidamente!!!")
	private String player3;
	@NotBlank(message = "Preencha o campo Jogador4 devidamente!!!")
	private String player4;

	private int contato;
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
	public String getPlayer1() {
		return player1;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	public String getPlayer2() {
		return player2;
	}
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	public String getPlayer3() {
		return player3;
	}
	public void setPlayer3(String player3) {
		this.player3 = player3;
	}
	public String getPlayer4() {
		return player4;
	}
	public void setPlayer4(String player4) {
		this.player4 = player4;
	}
	public int getContato() {
		return contato;
	}
	public void setContato(int contato) {
		this.contato = contato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contato, id, nome, player1, player2, player3, player4);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe2 other = (Equipe2) obj;
		return contato == other.contato && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(player1, other.player1) && Objects.equals(player2, other.player2)
				&& Objects.equals(player3, other.player3) && Objects.equals(player4, other.player4);
	}
	
	
	
}
