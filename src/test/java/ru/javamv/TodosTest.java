package ru.javamv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTaskOne = new SimpleTask(6, "Позвонить друзьям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Todos todos = new Todos();
    Meeting meeting = new Meeting(
            25,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Meeting newMeeting = new Meeting(
            37,
            "Релиз проекта",
            "Позвонить кому-либо",
            "В среду"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTask() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEpic() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindMeetingByTopic() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindMeetingByProject() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindMeetingByStart() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("после обеда");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindNothing() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {};
        Task[] actual = todos.search("Пончик");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанк");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSeveralTasks() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTaskOne);
        todos.add(newMeeting);

        Task[] expected = {simpleTask, simpleTaskOne, newMeeting};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }
}
