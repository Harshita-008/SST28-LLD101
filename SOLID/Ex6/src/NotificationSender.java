public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    public final NotificationResult send(Notification n) {
        if(n == null) {
            return NotificationResult.failure("Notification cannot be null");
        }
        return doSend(n);
    }

    public abstract NotificationResult doSend(Notification n);
}
