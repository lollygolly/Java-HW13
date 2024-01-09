package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesSimpleTask() { // Есть искомое слово в SimpleTask
        SimpleTask simpleTask = new SimpleTask(1, "Поставить будильник");

        boolean expected = true;
        boolean actual = simpleTask.matches("будильник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesSimpleTask() { // Нет искомого слова в SimpleTask
        SimpleTask simpleTask = new SimpleTask(1, "Купить продукты");

        boolean expected = false;
        boolean actual = simpleTask.matches("будильник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpic() { // Есть искомое слово в Epic
        String[] subtasks = {"Мандарины", "Шампанское", "Продукты для оливье"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("оливье");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesEpic() { // Нет искомого слова в Epic
        String[] subtasks = {"Мандарины", "Шампанское", "Продукты"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("оливье");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesMeeting() { // Нет искомого слова в Meeting
        Meeting meeting = new Meeting(
                111,
                "Новогоднее поздравление",
                "Новый год",
                "31 декабря в 12:00"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = false;
        boolean actual = meeting.matches("новый");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingInTopic() { // Есть одно искомое слово в Meeting
        Meeting meeting = new Meeting(
                111,
                "Новогоднее поздравление",
                "Новый год",
                "31 декабря в 12:00"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("поздравление");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingInProject() { // Есть несколько искомх слов в Meeting
        Meeting meeting = new Meeting(
                111,
                "Новогоднее поздравление",
                "Новый год",
                "31 декабря в 12:00"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Новый");
        Assertions.assertEquals(expected, actual);
    }
}
