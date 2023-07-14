package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Notification;
import com.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public Notification saveOrUpdateCompany(Notification notification) {
		Notification c = null;
		try {
			c = notificationRepository.save(notification);
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			// TODO loggare l'errore
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Notification> findAllCompanies() {
		return notificationRepository.findAll();
	}

	@Override
	public Map<Boolean, String> deleteCompany(String vatNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
