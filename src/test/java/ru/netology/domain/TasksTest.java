package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Поставить будильник");

        boolean expected = true;
        boolean actual = simpleTask.matches("будильник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить продукты");

        boolean expected = false;
        boolean actual = simpleTask.matches("будильник");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldMatchesEpicInOne() {
        String[] subtasks = {"Мандарины", "Шампанское", "Продукты для оливье"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("оливье");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicInTwo() {
        String[] subtasks = {"Мандарины", "Новогодние подарки", "Шампанское", "Новогодние украшения"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Новогод");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicInAll() {
        String[] subtasks = {"новая скатерть", "циновка", "фоновая музыка"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("нов");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldNotMatchesEpic() {
        String[] subtasks = {"Мандарины", "Шампанское", "Продукты"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("оливье");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesMeeting() {
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
    public void shouldMatchesMeetingInOne() {
        Meeting meeting = new Meeting(
                111,
                "Новогоднее поздравление",
                "Новый год",
                "31 декабря в 12:00"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("год");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingInTwo() {
        Meeting meeting = new Meeting(
                111,
                "Новогоднее поздравление",
                "Новый год",
                "31 декабря в 12:00"
        );
        Todos todos = new Todos();
        todos.add(meeting);

        boolean expected = true;
        boolean actual = meeting.matches("Нов");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesAtAll() {
        SimpleTask simpleTask = new SimpleTask(1, "Поздравить бабушку с др");

        Task task = new Task(1);

        boolean expected = false;
        boolean actual = task.matches("год");
        Assertions.assertEquals(expected, actual);
    }
}
