import java.util.*;

public class OnboardingService {
    private final IStudentRepository repo;
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final Printer printer = new Printer();

    public OnboardingService(IStudentRepository repo) {
        this.repo = repo;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String,String> kv = parser.parse(raw);

        List<String> errors = validator.validate(kv);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, kv.get("name"), kv.get("email"), kv.get("phone"), kv.get("program"));
        repo.save(rec);

        printer.printSuccess(rec, repo.count());
    }
}
