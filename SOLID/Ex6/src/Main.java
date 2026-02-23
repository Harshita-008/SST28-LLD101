public class Main {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        execute("EMAIL", new EmailSender(audit), n);
        execute("SMS", new SmsSender(audit), n);
        execute("WA", new WhatsAppSender(audit), n);

        System.out.println("AUDIT entries=" + audit.size());
    }

    private static void execute(String type, NotificationSender s, Notification n) {
        NotificationResult result = s.send(n);

        if(!result.isSuccess) {
            System.out.println(type + " ERROR: " + result.errMsg);
            s.audit.add(type + " failed");
        }
    }
}
