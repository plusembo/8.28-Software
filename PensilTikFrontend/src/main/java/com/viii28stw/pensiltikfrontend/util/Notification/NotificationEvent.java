package com.viii28stw.pensiltikfrontend.util.Notification;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * User: hansolo Date: 29.04.14 Time: 10:03
 */
public class NotificationEvent extends Event {

    public static final EventType<NotificationEvent> NOTIFICATION_PRESSED = new EventType(ANY, "NOTIFICATION_PRESSED");
    public static final EventType<NotificationEvent> SHOW_NOTIFICATION = new EventType(ANY, "SHOW_NOTIFICATION");
    public static final EventType<NotificationEvent> HIDE_NOTIFICATION = new EventType(ANY, "HIDE_NOTIFICATION");

    public final Notification NOTIFICATION;

    // ******************** Constructors **************************************
    public NotificationEvent(final Notification NOTIFICATION, final Object SOURCE, final EventTarget TARGET, EventType<NotificationEvent> TYPE) {
        super(SOURCE, TARGET, TYPE);
        this.NOTIFICATION = NOTIFICATION;
    }
}