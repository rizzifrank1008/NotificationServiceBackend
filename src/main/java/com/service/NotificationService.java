package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Notification;

public interface NotificationService {

	public Notification saveOrUpdateCompany(Notification notification);

	// La convenzione e' restituire una mappa al RestController
	// in modo tale che abbia come ritorno un Object e il
	// JackSON Object Mapper possa mapparlo come un JSON
	public Map<Boolean, String> deleteCompany(String vatNumber);

	public List<Notification> findAllCompanies();

}
