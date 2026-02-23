public enum AddOn {
    MESS(1000),
    LAUNDRY(500),
    GYM(300);

    private Money price;

    AddOn(double price) {
        this.price = new Money(price);
    }

    public Money getPrice() {
        return price;
    }
}
