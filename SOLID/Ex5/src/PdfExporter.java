import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult doExport(ExportRequest req) {
        if(req.body != null && req.body.length() > 20) {
            return ExportResult.failure("application/pdf", "PDF cannot handle content > 20 chars");
        }
        
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return ExportResult.success("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
