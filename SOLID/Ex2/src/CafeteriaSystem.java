import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final IInvoiceRepository repo = new FileStore();

    private final BillCalculator calculator = new BillCalculator();
    private final ITaxPolicy taxPolicy = new TaxPolicy();
    private final IDiscountPolicy discountPolicy = new DiscountPolicy();
    private final InvoicePrinter printer = new InvoicePrinter();

    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        
        double subtotal = calculator.subtotal(menu, lines);
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        Invoice inv = new Invoice(invId, menu, lines, subtotal, taxPct, tax, discount, total);
        String invoice = printer.getInvoice(inv);
        System.out.print(invoice);

        repo.save(invId, invoice);
        System.out.println("Saved invoice: " + invId + " (lines=" + repo.countLines(invId) + ")");
    }
}
