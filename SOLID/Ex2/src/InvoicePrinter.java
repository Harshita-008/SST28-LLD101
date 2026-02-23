public class InvoicePrinter {
    public String getInvoice(Invoice invoice) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoice.id).append("\n");

        for (OrderLine l : invoice.lines) {
            MenuItem item = invoice.menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", invoice.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", invoice.taxPct, invoice.tax));
        out.append(String.format("Discount: -%.2f\n", invoice.discount));
        out.append(String.format("TOTAL: %.2f\n", invoice.total));

        return out.toString();
    }
}
