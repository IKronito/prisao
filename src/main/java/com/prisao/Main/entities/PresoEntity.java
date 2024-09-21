package com.prisao.Main.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prisao.Main.enums.ComportamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "preso")
public class PresoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cpf;
	private String dataNasc;
	private String crime;
	private String sentenca;

	@Enumerated(EnumType.STRING)
	private ComportamentoEnum comportamento;

	@ManyToOne
	@JoinColumn(name = "cela_id")
	@JsonBackReference
	private CelaEntity cela;

	@OneToMany(mappedBy = "preso", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<VisitaEntity> visitas = new ArrayList<>();
}
