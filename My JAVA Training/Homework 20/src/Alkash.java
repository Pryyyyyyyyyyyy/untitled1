
public class Alkash {
    public static void main(String[] args) {
        Seller seller = new Seller("Мавка", true);
        Buyer buyer = new Buyer("Кицюня", 25, true);
        Shop shop = new Shop("Генделик");
        shop.returnCost(seller, buyer, "alcohol drink", 10.0);
    }
}