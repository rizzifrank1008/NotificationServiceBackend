package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Notification;
import com.service.NotificationService;

@RestController

@RequestMapping("/api/company-service")
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

	@PostMapping("/createNotification")
	public Notification saveCompany(@RequestBody Notification notification) {
		return notificationService.saveOrUpdateCompany(notification);
	}

	@PutMapping("/updateNotification")
	public Notification updateCompany(@RequestBody Notification notification) {
		return notificationService.saveOrUpdateCompany(notification);
	}

	@DeleteMapping("/deleteNotification/{vatNumber}")
	public Map<Boolean, String> deleteCompany(@PathVariable String vatNumber) {
		return notificationService.deleteCompany(vatNumber);
	}

	@GetMapping(path = "/readNotifications", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notification> findAllCompanies() {
		return notificationService.findAllCompanies();
	}

}
