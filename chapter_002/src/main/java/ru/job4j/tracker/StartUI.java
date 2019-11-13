package ru.job4j.tracker;


public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select > actions.length - 1) {
                run = false;
            } else {
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            }
        }
    }
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
        System.out.println("6. === Exit ===");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new AllItems(),
                new EditAction(),
                new DeleteAction(),
                new FindById(),
                new FindByName()
        };
        new StartUI().init(input, tracker, actions);
    }
}
