//- POST: inserisce una nuova notifica
//	- PATCH: modifica la notifica
//	- GET: prende tutte le proprie notifiche
//	- GET: prende tutte le notifiche

package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	// @Query("SELECT n FROM Notification n WHERE n.destinatario=:destinatario")
	public List<Notification> findByDestinatario(Integer destinatario);
}
