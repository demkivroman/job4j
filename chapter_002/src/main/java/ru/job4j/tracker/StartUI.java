package ru.job4j.tracker;


import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        UserAction[] actions = {
                new CreateAction(0, "Create Item"),
                new AllItems(1, "Show all Items"),
                new EditAction(2, "Edit Item"),
                new DeleteAction(3, "Delete Item"),
                new FindById(4, "Find Item by Id"),
                new FindByName(5, "Find Item by name")
        };
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }
    private void showMenu(UserAction[] actions) {
        this.output.accept("Menu.");
        for (int index = 0; index < actions.length; index++) {
            this.output.accept(actions[index].info());
        }
        this.output.accept("6. === Exit ===");
    }
    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        new StartUI(validate, tracker, System.out::println).init();
    }
}
