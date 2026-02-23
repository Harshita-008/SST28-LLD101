public enum RoomType {
    SINGLE(14000),
    DOUBLE(15000),
    TRIPLE(12000),
    DELUXE(16000);

    private Money price;

    RoomType(double price) {
        this.price = new Money(price);
    }

    public Money getPrice() {
        return price;
    }

    public static RoomType leagcy(int t) {
        return switch(t) {
            case LegacyRoomTypes.SINGLE -> SINGLE;
            case LegacyRoomTypes.DOUBLE -> DOUBLE;
            case LegacyRoomTypes.TRIPLE -> TRIPLE;
            default -> DELUXE;
        };
    }
}
