import java.util.function.Consumer;

abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void role();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Seller extends Person {
    private boolean isHonest;

    public Seller(String name, int age, boolean isHonest) {
        super(name, age);
        this.isHonest = isHonest;
    }

    public boolean isHonest() {
        return isHonest;
    }

    public void setHonest(boolean honest) {
        isHonest = honest;
    }

    @Override
    public void role() {
        System.out.println("Я продавец");
    }
}

class Buyer extends Person {
    private boolean hasDiscountCard;

    public Buyer(String name, int age, boolean hasDiscountCard) {
        super(name, age);
        this.hasDiscountCard = hasDiscountCard;
    }

    public boolean hasDiscountCard() {
        return hasDiscountCard;
    }

    @Override
    public void role() {
        System.out.println("Я покупатель");
    }
}

class Shop {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public void returnCost(String productName, double productCost, Seller seller, Buyer buyer) {
        double finalCost = productCost;
        if (buyer.hasDiscountCard()) {
            finalCost *= 0.9;


        }

        if (productName.toLowerCase().contains("алкоголь") && buyer.getAge() < 18) {
            if (seller.isHonest()) {
                System.out.println("Извините, продажа алкоголя не разрешена несовершеннолетним");
                return;
            } else {
                System.out.println("Продажа алкоголя несовершеннолетним разрешена продавцом " + seller.getName());
            }
        }

        System.out.println("Уважаемый_ая " + buyer.getName() + ", продавец " + seller.getName() + " нашего магазина \n" +
                " \"" +
                name + "\", \n продаст вам этот товар \"" + productName +
                "\", а ваш возраст " + buyer.getAge() + ". \n Стоимость вашей покупки равна " + finalCost);
        System.out.println("Вот вам скидка");

    }
}

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("Магазин продуктов");
        Seller seller = new Seller("Красавчик", 25, true);
        Buyer buyer = new Buyer("Колбаска", 18, true);
        shop.returnCost("алкоголь", 50.0, seller, buyer);
    }
}
