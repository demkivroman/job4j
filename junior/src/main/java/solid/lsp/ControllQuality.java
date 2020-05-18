package solid.lsp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllQuality {
    private WareHouse wareHouse;
    private Shop shop;
    private Trash trash;

    public ControllQuality(WareHouse wareHouse, Shop shop, Trash trash) {
        this.wareHouse = wareHouse;
        this.shop = shop;
        this.trash = trash;
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

    public void contribute(Food food) {
        int percent = getExpired(food);
        FoodContainerContext foodContext;
        if (percent < 25) {
            foodContext = new FoodContainerContext(wareHouse);
            foodContext.addFood(food);
        } else if (percent >= 25 && percent <= 75) {
            foodContext = new FoodContainerContext(shop);
            foodContext.addFood(food);
        } else if (percent > 75 && percent < 100) {
            food.setDiscount(10);
            foodContext = new FoodContainerContext(shop);
            foodContext.addFood(food);
        } else {
            foodContext = new FoodContainerContext(trash);
            foodContext.addFood(food);
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
        ControllQuality control = new ControllQuality(wareHouse, shop, trash);
        control.contribute(milk);
        control.contribute(oil);
        control.contribute(pasta);
        System.out.println("WareHouse:");
        wareHouse.showFood();
        System.out.println("Shop:");
        shop.showFood();
        System.out.println("Trash:");
        trash.showFood();
    }
}

