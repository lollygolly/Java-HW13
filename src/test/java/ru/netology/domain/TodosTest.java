package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeQuery() { // Поиск по запросу находит несколько задач
        SimpleTask simpleTask = new SimpleTask(1, "Купить подарки на Новый год");

        String[] subtasks = { "Конфеты", "Новогодние игрушки", "Гирлянда" };
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Ужин с гостями",
                "Новый год 2024",
                "31 декабря в 18:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.search("Нов");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotSearchQuery() { // Поиск по запросу не находит ни одной задачи
        SimpleTask simpleTask = new SimpleTask(1, "Купить подарки на Новый год");

        String[] subtasks = { "Конфеты", "Новогодние игрушки", "Гирлянда" };
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Ужин с гостями",
                "Новый год 2024",
                "31 декабря в 18:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Собрание");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneQuery() { // Поиск по запросу находит одну задачу
        SimpleTask simpleTask = new SimpleTask(1, "Купить подарки на Новый год");

        String[] subtasks = { "Конфеты", "Новогодние игрушки", "Гирлянда" };
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Ужин с гостями",
                "Новый год 2024",
                "31 декабря в 18:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { meeting };
        Task[] actual = todos.search("2024");
        Assertions.assertArrayEquals(expected, actual);
    }
}
