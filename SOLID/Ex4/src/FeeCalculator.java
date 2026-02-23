public class FeeCalculator {
    public Money calculateMonthly(BookingRequest req) {
        Money total = RoomType.leagcy(req.roomType).getPrice();
        
        for(AddOn addOn : req.addOns) {
            total = total.plus(addOn.getPrice());
        }

        return total;
    }
}
