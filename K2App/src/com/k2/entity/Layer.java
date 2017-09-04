package com.k2.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NamedQueries({
	@NamedQuery(name="Layer.findAll", query="SELECT n FROM Layer n"),
	@NamedQuery(name="Layer.findByID", query="SELECT n FROM Layer n WHERE n.id = :id"),
	@NamedQuery(name="Layer.findRegioni", query="SELECT n FROM Layer n WHERE tipo = 0"),
//	@NamedQuery(name="Layer.findByCODE", query="SELECT n FROM Layer n WHERE n.code = :code")
	//	@NamedQuery(name="Layer.findByID", query="SELECT n FROM Layer n WHERE n.code = :code")
	//	@NamedQuery(name="Layer.findByID", query="SELECT n FROM Layer n WHERE n.code = :code")
	//	@NamedQuery(name="Layer.findByID", query="SELECT n FROM Layer n WHERE n.code = :code")
	//	@NamedQuery(name="Layer.findByID", query="SELECT n FROM Layer n WHERE n.code = :code")
	//	@NamedQuery(name="Layer.findByID", query="SELECT n FROM Layer n WHERE n.code = :code")
})

public class Layer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;

	// Indica per una maggiore chiarezza Regione| Provincia | Comune 
	@NotNull
	@Size(min=1,max=2000)
	private String codice;


	private int tipo;



	private static final long serialVersionUID = 1L;

	public Layer() {
		super();
	}



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

	public String getCodice() {
		return codice;
	}


	public void setCodice(String codice) {
		this.codice = codice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
