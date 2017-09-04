package com.k2.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class UploadedFile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{NotEmpty.upFile.nome}")
	@Size(min=1)
	private String nome;
    
    @NotNull(message = "{NotEmpty.upFile.dataCaricamento}")
    @Temporal(TemporalType.TIMESTAMP)
	private Date dataCaricamento;
    

	private static final long serialVersionUID = 1L;

	public UploadedFile() {
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

	public Date getDataCaricamento() {
		return dataCaricamento;
	}

	public void setDataCaricamento(Date dataCaricamento) {
		this.dataCaricamento = dataCaricamento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
