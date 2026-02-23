public interface IDiscountPolicy {
    double discount(String customerType, double subtotal, int lines);
}
