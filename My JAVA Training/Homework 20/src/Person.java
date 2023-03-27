/*В этом примере у нас есть абстрактный класс Person, от которого наследуются классы Seller и Buyer.
        У каждого объекта этого класса есть имя и метод role(), который выводит на консоль
        информацию о том, является ли объект продавцом или покупателем.
        У продавца есть дополнительный параметр isHonest, который говорит о том,
        честный ли продавец. Если продавец нечестный, он продаст алкоголь покупателю в любом случае.
        У покупателя есть дополнительные параметры age и hasDiscountCard,
        которые говорят о возрасте покупателя и наличии у него скидки*/


abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void role();
}

class Seller extends Person {
    private boolean isHonest;

    public Seller(String name, boolean isHonest) {
        super(name);
        this.isHonest = isHonest;
    }

    public boolean isHonest() {
        return isHonest;
    }

    public void setHonest(boolean isHonest) {
        this.isHonest = isHonest;
    }

    @Override
    public void role() {
        System.out.println("я продавец");
    }
}

class Buyer extends Person {
    private int age;
    private boolean hasDiscountCard;

    public Buyer(String name, int age, boolean hasDiscountCard) {
        super(name);
        this.age = age;
        this.hasDiscountCard = hasDiscountCard;
    }

    public int getAge() {
        return age;
    }

    public boolean hasDiscountCard() {
        return hasDiscountCard;
    }

    @Override
    public void role() {
        System.out.println("я покупатель");
    }
}

interface ShopInterface {
    void returnCost(Seller seller, Buyer buyer, String productName, double price);
}

class Shop implements ShopInterface {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    @Override
    public void returnCost(Seller seller, Buyer buyer, String productName, double price) {
        System.out.print("Дорог_ая " + buyer.getName() + ", ");
        seller.role();
        System.out.println("наш магазин \"" + name + "\" может предложить вам продукт \"" + productName + "\".");
        if (productName.toLowerCase().contains("alcohol")) {
            if (seller.isHonest()) {
                System.out.println("Мы не можем продать вам алкашку.");
                return;
            }
        }
        double cost = price;
        if (buyer.hasDiscountCard()) {
            cost *= 0.9;
            System.out.println("Ваша скидка:");
        }
        System.out.println("Сумма покупки " + cost);
    }
}
