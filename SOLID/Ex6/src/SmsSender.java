public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public NotificationResult doSend(Notification n) {
        if(n.phone == null) {
            return NotificationResult.failure("Phone required");
        }
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
        return NotificationResult.success();
    }
}
