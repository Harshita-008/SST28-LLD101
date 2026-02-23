public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public final ExportResult export(ExportRequest req) {
        if(req == null) {
            return ExportResult.failure("text/plain", "Request cannot be null");
        }
        return doExport(req);
    }
    public abstract ExportResult doExport(ExportRequest req);
}
