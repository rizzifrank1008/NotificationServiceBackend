package com.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity

public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private String text;

	private String status;

	private String mittente;

	private String destinatario;

	@UpdateTimestamp
	private Timestamp created_date;

//costruttore insert
	public Notification(String text, String status, String mittente, String destinatario) {

		this.text = text;
		this.status = status;
		this.mittente = mittente;
		this.destinatario = destinatario;

	}

}
