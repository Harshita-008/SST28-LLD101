public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");

        IPlagiarismService pc = new PlagiarismChecker();
        IGradingService gs = new CodeGrader(new Rubric());
        IReportService rs = new ReportWriter();

        new EvaluationPipeline(pc, gs, rs).evaluate(sub);
    }
}
