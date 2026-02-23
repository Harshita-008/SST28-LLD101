import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final FeeCalculator calc;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.calc = new FeeCalculator();
    }

    public void process(BookingRequest req) {
        Money monthly = calc.calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }
}
