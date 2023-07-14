//- POST: inserisce una nuova notifica
//	- PATCH: modifica la notifica
//	- GET: prende tutte le proprie notifiche
//	- GET: prende tutte le notifiche

package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
