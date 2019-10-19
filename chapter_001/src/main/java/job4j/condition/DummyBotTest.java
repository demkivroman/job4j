package job4j.condition;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.jupiter.api.Test;


public class DummyBotTest {
    @Test
    public void whenGreetBot() {
        assertThat(
             DummyBot.answer("Привет, Бот."),
                is("Привет, умник")
        );

    }
    @Test
    public void whenByeBot() {
        assertThat(
                DummyBot.answer("Пока."),
                is("До скорой встречи")
        );
    }
    @Test
    public void whenUnknownBot() {
        assertThat(
                DummyBot.answer("Сколько будет 2 + 2?"),
                is("Єто ставит меня в тупик. Задайте другой вопрос.")
        );
    }

}
