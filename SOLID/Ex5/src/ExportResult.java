public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final boolean isSuccess;
    public final String errMsg;

    public ExportResult(String contentType, byte[] bytes, boolean isSuccess, String errMsg) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.isSuccess = isSuccess;
        this.errMsg = errMsg;
    }

    public static ExportResult success(String contentType, byte[] bytes) {
        return new ExportResult(contentType, bytes, true, null);
    }

    public static ExportResult failure(String contentType, String errMsg) {
        return new ExportResult(contentType, new byte[0], false, errMsg);
    }
}
