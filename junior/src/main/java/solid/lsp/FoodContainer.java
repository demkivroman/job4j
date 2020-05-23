package solid.lsp;

public interface FoodContainer {
    void addFood(Food food);
    void showFood();
    boolean accept(Food food);
}
