package ru.job4j.tracker;


public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].info());
        }
        System.out.println("6. === Exit ===");
    }
    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(0, "Create Item"),
                new AllItems(1, "Show all Items"),
                new EditAction(2, "Edit Item"),
                new DeleteAction(3, "Delete Item"),
                new FindById(4, "Find Item by Id"),
                new FindByName(5, "Find Item by name")
        };
        new StartUI().init(validate, tracker, actions);
    }
}
