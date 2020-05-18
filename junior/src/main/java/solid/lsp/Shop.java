package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements FoodContainer {
    List<Food> container = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        container.add(food);
    }

    @Override
    public void showFood() {
        container.forEach(
                food -> System.out.println(String.format("Name - %s", food.getName()))
        );
    }
}
