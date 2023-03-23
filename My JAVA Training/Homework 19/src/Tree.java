
public class Tree {
    String type;
    int height, countOfSticks;
    String color;

    public Tree(String type, int height) {
        this.type = type;
        this.height = height;
        this.countOfSticks = 13;
        this.color = "Зеленый";
    }

    public Tree(int height, int countOfSticks, String color) {
        this.type = "пихта";
        this.height = height;
        this.countOfSticks = countOfSticks;
        this.color = color;
    }

    public Tree() {
        this.height = 350;
        this.countOfSticks = 29;
        this.color = "Желтый";
    }

    public Tree(String type) {
        this();
        this.type = type;
    }

    public static void main(String[] args) {
        Tree tree1 = new Tree("сосна", 200);
        Tree tree2 = new Tree(300, 15, "Красный");
        Tree tree3 = new Tree();
        Tree tree4 = new Tree("дуб");

        System.out.println(tree1.type + " " + tree1.height + " " + tree1.countOfSticks + " " + tree1.color);
        System.out.println(tree2.type + " " + tree2.height + " " + tree2.countOfSticks + " " + tree2.color);
        System.out.println(tree3.type + " " + tree3.height + " " + tree3.countOfSticks + " " + tree3.color);
        System.out.println(tree4.type + " " + tree4.height + " " + tree4.countOfSticks + " " + tree4.color);
    }
}
