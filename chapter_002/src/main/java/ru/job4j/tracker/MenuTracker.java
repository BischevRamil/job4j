package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new FindAllItem());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindByIdItem());
        this.actions.add(new FindByNameItem());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
            this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с ID : " + item.getId());
            System.out.println("------------ Новая заявка с именем : " + item.getName());
            System.out.println("------------ Новая заявка с описанием : " + item.getDesc());
        }

        @Override
        public String info() {
            return "0. Добавить заявку";
        }
    }

    public class FindAllItem implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-----------------Показать все заявки:---------------------");
            Item[] items = tracker.findAll();
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i].getId() + " " + items[i].getName() + " " + items[i].getDesc());
            }
        }

        @Override
        public String info() {
            return "1. Показать все заявки";
        }
    }

    public class UpdateItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------------Редактирование заявки------------------------------");
            String id = input.ask("Введите ID заявки :");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            boolean rsl = tracker.replace(id, item);
            if (rsl) {
                System.out.println("------------ Новая заявка с ID : " + id + "-----------");
            } else {
                System.out.println("------------ Заявка с таким ID не найдена--------------");
            }
        }

        @Override
        public String info() {
            return "2. Редактирвать заявку";
        }
    }

    public class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------------Удаление заявки------------------------------------");
            String id = input.ask("Введите ID заявки которую нужно удалить :");
            boolean rsl = tracker.delete(id);
            if (rsl) {
                System.out.println("-----------------Заявка с ID :" + id + "удалена--------------------");
            } else {
                System.out.println("------------ Заявка с таким ID не найдена--------------");
            }
        }

        @Override
        public String info() {
            return "3. Удалить заявку";
        }
    }

    public class FindByIdItem implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------------Поиск заявки по ID------------------------------------");
            String id = input.ask("Введите ID заявки, которую нужно найти");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.getId() + " " + item.getName() + " " + item.getDesc());
            } else {
                System.out.println("------------ Заявка с таким ID не найдена--------------");
            }
        }

        @Override
        public String info() {
            return "4. Найти по ID";
        }
    }

    public class FindByNameItem implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------------------Поиск заявок по имени-----------------------------------");
            String name = input.ask("Введите имя заявки: ");
            Item[] items = tracker.findByName(name);
            if (items != null) {
                for (Item item : items) {
                    System.out.println(item.getId() + " " + item.getName() + " " + item.getDesc());
                }
            } else {
                System.out.println("------------ Заявок с таким именем не найдено--------------");
            }
        }

        @Override
        public String info() {
            return "5. Найти по имени";
        }
    }

    public class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return "6. Выход";
        }
    }
}
