package com.bankloanapplication.repository;

import com.bankloanapplication.model.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
