package solid.lsp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class ControllQuality {
    List<FoodContainer> containers = new LinkedList<>();
    public ControllQuality() {
    }

    public ControllQuality(List<FoodContainer> containers) {
        this.containers = containers;
    }

    public int getExpired(Food food) {
        int msPerDay = 86400000;
        Calendar currentDate = Calendar.getInstance();
        food.getCreateDate().add(Calendar.MONTH, -1);
        food.getExpaireDate().add(Calendar.MONTH, -1);
        double allExpaire = (food.getExpaireDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / msPerDay;
        double currentPeriod = (currentDate.getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / msPerDay;
        return (int) (currentPeriod / allExpaire * 100);
    }

    public void distibute(Food food) {
        for (FoodContainer container : containers) {
            if (container.accept(food)) {
                container.addFood(food);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Food milk = new Food(
                "milk", new GregorianCalendar(2020, 5, 20),
                new GregorianCalendar(2020, 4, 10), 23.45, 0);
        Food pasta = new Food(
                "pasta", new GregorianCalendar(2021, 10,  20),
                new GregorianCalendar(2020, 4, 10), 12.45, 0);

        Food oil = new Food(
                "oil", new GregorianCalendar(2020, 4,  20),
                new GregorianCalendar(2020, 3, 10), 12.45, 0);

        WareHouse wareHouse = new WareHouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality control = new ControllQuality(List.of(wareHouse, shop, trash));
        control.distibute(milk);
        control.distibute(oil);
        control.distibute(pasta);
        System.out.println("WareHouse:");
        wareHouse.showFood();
        System.out.println("Shop:");
        shop.showFood();
        System.out.println("Trash:");
        trash.showFood();
    }
}

