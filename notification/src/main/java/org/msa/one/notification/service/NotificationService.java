package org.msa.one.notification.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.one.notification.repo.NotificationRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void register(Notification notification) {
        log.info("Try to store a new notification to DB {}", notification);
       notificationRepository.save(notification);
       log.info("Notification is stored to DB {}", notification);

    }

}
