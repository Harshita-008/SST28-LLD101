public class TaxPolicy implements ITaxPolicy {
    public double taxPercent(String customerType) {
        return TaxRules.taxPercent(customerType);
    }
}
