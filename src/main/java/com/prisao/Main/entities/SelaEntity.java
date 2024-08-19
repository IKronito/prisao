package com.prisao.Main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "sela")

public class SelaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int Capacidade;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="TiposSela")
	private TiposSela type;
	
	@Column(name="tipo")
	private String tipo;
	
	public enum TiposSela {
	   Solitaria,Coletiva
	}
	
	private int OcupacaoAtual;
	
	
}
