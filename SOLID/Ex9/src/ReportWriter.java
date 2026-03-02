public class ReportWriter implements IReportService {
    public String write(Submission s, int plag, int code) {
        return "report-" + s.roll + ".txt";
    }
}
