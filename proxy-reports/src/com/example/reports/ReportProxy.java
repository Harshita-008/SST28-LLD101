package com.example.reports;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // Access Control
        if(!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED -> "
                + user.getName()
                + " cannot open report " + reportId
            );
            return;
        }

        // Lazy Loading
        if(realReport == null) {
            realReport = new RealReport(reportId, title, classification);
        }

        // Delegate to real subject
        realReport.display(user);
    }
}
