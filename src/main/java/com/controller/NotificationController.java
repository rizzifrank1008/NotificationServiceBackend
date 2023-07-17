package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Notification;
import com.repository.NotificationRepository;
import com.service.NotificationService;

@RestController
@CrossOrigin
@RequestMapping("/api/notification-service")
public class NotificationController {

	/*
	 * Con l'implementazione di Spring Security - Base level bisogna fare
	 * l'autenticazione per usare i servizi esposti (come ad esempio le chiamate
	 * Rest mappate in questa classe). Le credenziali sono definite nel file
	 * application.properties. Se si usa la Swagger-UI (importando nel pom la sua
	 * dependency: springdoc-openapi-starter-webmvc-ui) ti verra' chiesto username e
	 * pass. Se usi Postman, per fare una qualsiasi operazione dovrai usare
	 * l'Authorization - Basic Auth impostando le credenziali.
	 */

	@Autowired
	private NotificationService notificationService;
	@Autowired
	private NotificationRepository nr;

	@PostMapping("/createNotification")
	public Notification saveNotification(@RequestBody Notification notification) {
		return notificationService.saveOrUpdateNotification(notification);
	}

	@PatchMapping("/updateNotification")
	public ResponseEntity<Notification> patchNotification(@RequestBody Notification notification) {
		Optional<Notification> n = nr.findById(notification.getId());
		n.get().setStatus(notification.getStatus());
		nr.save(n.get());
		return new ResponseEntity<Notification>(n.get(), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteNotification/{vatNumber}")
	public Map<Boolean, String> deleteNotification(@PathVariable String vatNumber) {
		return notificationService.deleteNotification(vatNumber);
	}

	@GetMapping(path = "/readNotifications", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notification> findAllNotification() {
		return notificationService.findAllNotification();
	}

	@GetMapping(path = "/readNotificationsByDestinatario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notification> findByDestinatario(Integer destinatario) {
		return notificationService.findByDestinatario(destinatario);
	}
}
