import java.util.*;

public class Invoice {
    public final String id;
    public final List<OrderLine> lines;
    public final Map<String, MenuItem> menu;
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public Invoice(String id,
                   Map<String, MenuItem> menu,
                   List<OrderLine> lines,
                   double subtotal,
                   double taxPct,
                   double tax,
                   double discount,
                   double total) {

        this.id = id;
        this.menu = menu;
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}
