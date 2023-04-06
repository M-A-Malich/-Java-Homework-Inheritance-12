package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testWhenSimpleTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenSimpleTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

       boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);
    }
    @Test
    public void testWhenSimpleTaskFoundTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenEpicFound() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хлеб");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenEpicNotFound() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Батон");
        Assertions.assertFalse(actual);
    }
    @Test
    public void testWhenEpicFoundSubtasks() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);


        String [] expected = { "Молоко", "Яйца", "Хлеб" };
        String [] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenMeetingFoundTopic() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenMeetingFoundStar() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenMeetingFoundProject() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenMeetingFound() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("Выкатка");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenMeetinNotFound() {
        Meeting meeting = new Meeting(555,"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean actual = meeting.matches("Размещение");
        Assertions.assertFalse(actual);
    }


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


}