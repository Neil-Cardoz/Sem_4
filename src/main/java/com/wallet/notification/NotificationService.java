package com.wallet.notification;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class NotificationService {
    // Thread pool for notification processing
    private final ExecutorService notificationExecutor;
    // Queue for notifications
    private final BlockingQueue<Notification> notificationQueue;
    // Set of notification subscribers
    private final Set<Consumer<Notification>> subscribers;
    // Cleanup scheduler
    private final ScheduledExecutorService cleanupExecutor;

    public NotificationService() {
        this.notificationExecutor = Executors.newFixedThreadPool(2);
        this.notificationQueue = new LinkedBlockingQueue<>();
        this.subscribers = new CopyOnWriteArraySet<>();
        this.cleanupExecutor = Executors.newSingleThreadScheduledExecutor();
        startNotificationProcessor();
        startCleanupTask();
    }

    /**
     * Starts the notification processing thread
     */
    private void startNotificationProcessor() {
        notificationExecutor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Notification notification = notificationQueue.take();
                    processNotification(notification);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }

    /**
     * Starts periodic cleanup task
     */
    private void startCleanupTask() {
        cleanupExecutor.scheduleAtFixedRate(
                this::cleanup,
                1, 1, TimeUnit.HOURS);
    }

    /**
     * Processes a single notification
     */
    private void processNotification(Notification notification) {
        for (Consumer<Notification> subscriber : subscribers) {
            try {
                subscriber.accept(notification);
            } catch (Exception e) {
                // Log error but continue processing
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends a notification
     */
    public void notify(String message, NotificationType type) {
        Notification notification = new Notification(message, type);
        notificationQueue.offer(notification);
    }

    /**
     * Adds a notification subscriber
     */
    public void subscribe(Consumer<Notification> subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * Removes a notification subscriber
     */
    public void unsubscribe(Consumer<Notification> subscriber) {
        subscribers.remove(subscriber);
    }

    /**
     * Cleans up old notifications
     */
    private void cleanup() {
        notificationQueue.clear();
    }

    /**
     * Shuts down the notification service
     */
    public void shutdown() {
        notificationExecutor.shutdownNow();
        cleanupExecutor.shutdownNow();
    }

    /**
     * Represents a notification
     */
    public static class Notification {
        private final String message;
        private final NotificationType type;
        private final long timestamp;

        public Notification(String message, NotificationType type) {
            this.message = message;
            this.type = type;
            this.timestamp = System.currentTimeMillis();
        }

        // Getters
        public String getMessage() {
            return message;
        }

        public NotificationType getType() {
            return type;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }

    public enum NotificationType {
        INFO, SUCCESS, WARNING, ERROR
    }
}