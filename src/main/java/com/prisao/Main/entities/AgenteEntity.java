package com.prisao.Main.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "agente")
@Table(name = "agente")
public class AgenteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String dataNasc;
	private String cpf;
	private String telefone;

	@Column(name = "cargo")
	private String cargo;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "preso_agente",
			joinColumns = @JoinColumn(name = "agente_id"),
			inverseJoinColumns = @JoinColumn(name = "preso_id"))
	private List<PresoEntity> presos = new ArrayList<>();
}
