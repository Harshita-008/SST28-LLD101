public class PlagiarismChecker implements IPlagiarismService {
    public int check(Submission s) {
        return (s.code.contains("class") ? 12 : 40);
    }
}
