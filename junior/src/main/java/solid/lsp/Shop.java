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

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        int percent = new ControllQuality().getExpired(food);
        if (percent >= 25 && percent <= 75) {
            rsl = true;
        } else if (percent > 75 && percent < 100) {
            rsl = true;
            food.setDiscount(10);
        }
        return rsl;
    }
}
