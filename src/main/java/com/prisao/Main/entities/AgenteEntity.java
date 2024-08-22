package com.prisao.Main.entities;

import java.util.List;

import com.prisao.Main.enums.CargosEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String dataNasc;
	
	private String cpf;
	
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	private CargosEnum type;
	
	@Column(name="cargo")
	private String cargo;
	
	 @ManyToMany(mappedBy = "agentes")
	 private List<PresoEntity> presos;
	
	
}
