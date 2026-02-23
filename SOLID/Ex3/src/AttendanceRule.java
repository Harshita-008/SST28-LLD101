public class AttendanceRule implements IEligibilityRule {
    private final int minAttendance;

    public AttendanceRule(int minAttendance) {
        this.minAttendance = minAttendance;
    }

    public String check(StudentProfile s) {
        if(s.attendancePct < minAttendance) {
            return "attendance below " + minAttendance;
        }
        return null;
    }
}
