package com.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String text;

	private String status;

	private Integer mittente;

	private Integer destinatario;
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime created_date;

	public Notification(Integer id, String text, String status, Integer mittente, Integer destinatario,
			LocalDateTime created_date) {

		this.id = id;
		this.text = text;
		this.status = status;
		this.mittente = mittente;
		this.destinatario = destinatario;
		this.created_date = created_date;
	}

	public Notification() {

	}

//costruttore insert
	public Notification(String text, String status, Integer mittente, Integer destinatario) {

		this.text = text;
		this.status = status;
		this.mittente = mittente;
		this.destinatario = destinatario;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMittente() {
		return mittente;
	}

	public void setMittente(Integer mittente) {
		this.mittente = mittente;
	}

	public Integer getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Integer destinatario) {
		this.destinatario = destinatario;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", text=" + text + ", status=" + status + ", mittente=" + mittente
				+ ", destinatario=" + destinatario + ", created_date=" + created_date + "]";
	}

}
