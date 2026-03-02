public class TransportBookingService {
    private final IDistanceService distanceService;
    private final IDriverService driverService;
    private final IPaymentService paymentService;
    private final IFarePolicy farePolicy;

    public TransportBookingService(IDistanceService distanceService, IDriverService driverService, IPaymentService paymentService, IFarePolicy farePolicy) {
        this.distanceService = distanceService;
        this.driverService = driverService;
        this.paymentService = paymentService;
        this.farePolicy = farePolicy;
    }

    public void book(TripRequest req) {
        double km = distanceService.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverService.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = farePolicy.calculate(km);

        String txn = paymentService.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
