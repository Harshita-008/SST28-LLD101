public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public NotificationResult doSend(Notification n) {
        if(n.email == null) {
            return NotificationResult.failure("Email required");
        }
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
        return NotificationResult.success();
    }
}
