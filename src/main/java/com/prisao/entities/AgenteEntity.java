package com.prisao.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "agente")

public class AgenteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private String CPF;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataNasc;

	private String telefone;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CargosAgente")
	private CargosAgente type;
	
	@Column(name="cargo")
	private String cargo;
	
	public enum CargosAgente {
	    Diretor,Subdiretor,Chefe,Supervisor,Oficial
	}
	
	@OneToMany(mappedBy = "selas")
	 private List<SelaEntity> selas;
	
}
