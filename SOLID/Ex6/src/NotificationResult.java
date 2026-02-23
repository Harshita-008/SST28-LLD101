public class NotificationResult {
    public final boolean isSuccess;
    public final String errMsg;

    private NotificationResult(boolean isSuccess, String errMsg) {
        this.isSuccess = isSuccess;
        this.errMsg = errMsg;
    }

    public static NotificationResult success() {
        return new NotificationResult(true, null);
    }

    public static NotificationResult failure(String err) {
        return new NotificationResult(false, err);
    }
}
