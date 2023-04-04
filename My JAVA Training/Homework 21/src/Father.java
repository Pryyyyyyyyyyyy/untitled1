import java.util.*;

public class Father {
    private String name;
    private double money;

    public Father(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void goToShop(List<Product> products) throws NotEnoughMoneyException, ForbiddenProductException, NotDivisibleByThreeException {
        double totalPrice = 0;
        Map<ProductType, Integer> productsCount = new EnumMap<>(ProductType.class);

        // Проверяем, что в списке товаров нет запрещенных продуктов
        for (Product product : products) {
            if (product.getProductType() == ProductType.BEER || product.getProductType() == ProductType.TOBACCO) {
                throw new ForbiddenProductException(product.getProductType());
            }
        }

        // Покупаем продукты и считаем общую стоимость
        for (Product product : products) {
            totalPrice += product.getPrice();
            productsCount.merge(product.getProductType(), 1, Integer::sum);
        }

        // Проверяем, что общая стоимость покупки не превышает количество денег у отца
        if (totalPrice > money) {
            throw new NotEnoughMoneyException();
        }

        // Проверяем, что количество каждого купленного продукта делится на 3
        for (Map.Entry<ProductType, Integer> entry : productsCount.entrySet()) {
            if (entry.getValue() % 3 != 0) {
                throw new NotDivisibleByThreeException(entry.getKey());
            }
        }

        System.out.println("Уважаемый " + name + "," + " стоимость ваших покупок " + totalPrice + ".");
        for (Map.Entry<ProductType, Integer> entry : productsCount.entrySet()) {
            System.out.println("Вы приобрели " + entry.getKey() + " в количестве " + entry.getValue() + " шт" + ".");
        }
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(ProductType.APPLE, 10),
                new Product(ProductType.APPLE, 10),
                new Product(ProductType.APPLE, 10),
                new Product(ProductType.MILK, 5),
                new Product(ProductType.MILK, 5),
                new Product(ProductType.MILK, 5)
        );

        Father father = new Father("Валентин", 100);
        try {
            father.goToShop(products);
        } catch (NotEnoughMoneyException | ForbiddenProductException | NotDivisibleByThreeException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Product {
    private ProductType productType;
    private double price;

    public Product(ProductType productType, double price) {
        this.productType = productType;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }
}

enum ProductType {
    APPLE,
    POTATO,
    MILK,
    BEER,
    TOBACCO
}

class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("У отца недостаточно денег для покупки.");
    }
}

class ForbiddenProductException extends Exception {
    public ForbiddenProductException(ProductType productType) {
        super("Отцу запрещено покупать");
    }
}