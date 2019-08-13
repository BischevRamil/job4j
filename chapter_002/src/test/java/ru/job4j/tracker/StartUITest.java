package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();                // создаём Tracker
        Item item = tracker.add(new Item("test name", "desc"));             //Напрямую добавляем заявку
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});    //создаём StubInput с последовательностью действий(производим замену заявки)
        new StartUI(input, tracker).init();         // создаём StartUI и вызываем метод init()
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenDeleteThenTrackerNotHasValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.delete(item.getId()), is(false));
    }
}
