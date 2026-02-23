public class DiscountPolicy implements IDiscountPolicy {
    public double discount(String customerType, double subtotal, int lines) {
        return DiscountRules.discountAmount(customerType, subtotal, lines);
    }
}
