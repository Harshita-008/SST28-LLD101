public class CodeGrader implements IGradingService {
    private final Rubric rubric;

    public CodeGrader(Rubric rubric) {
        this.rubric = rubric;
    }

    public int grade(Submission s) {
        // fake scoring (but deterministic)
        int base = Math.min(80, 50 + s.code.length() % 40);
        return base + rubric.bonus;
    }
}
