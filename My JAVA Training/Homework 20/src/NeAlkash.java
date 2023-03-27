
public class NeAlkash {
    public static void main(String[] args) {
        Seller seller = new Seller("Мавка", true);
        Buyer buyer = new Buyer("Зюзя", 18, true);
        Shop shop = new Shop("Генделик");
        shop.returnCost(seller, buyer, "drink", 10.0);
    }
}