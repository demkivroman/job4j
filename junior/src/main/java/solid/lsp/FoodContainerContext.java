package solid.lsp;

public class FoodContainerContext {
    private FoodContainer container;

    public FoodContainerContext(FoodContainer container) {
        this.container = container;
    }
    public void addFood(Food food) {
        container.addFood(food);
    }
}