package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItems();
            } else if (DEL.equals(answer)) {
                this.delItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findByIdItem();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 125L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showItems() {
        System.out.println("-----------------Показать все заявки:---------------------");
        Item[] items = this.tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getId() + " " + items[i].getName() + " " + items[i].getDesc());
        }
    }

    private void editItems() {
        System.out.println("-------------------Редактирование заявки------------------------------");
        String ID = this.input.ask("Введите ID заявки :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, 125L);
        this.tracker.replace(ID, item);
        System.out.println("------------ Новая заявка с ID : " + ID + "-----------");
    }

    private void delItem() {
        System.out.println("---------------------Удаление заявки------------------------------------");
        String ID = this.input.ask("Введите ID заявки которую нужно удалить :");
        this.tracker.delete(ID);
        System.out.println("Заявка с ID :" + ID + "удалена");
    }

    private void findByIdItem() {
        System.out.println("---------------------Поиск заявки по ID------------------------------------");
        String ID = this.input.ask("Введите ID заявки, которую нужно найти");
        Item item = this.tracker.findById(ID);
        System.out.println(item);
    }

    private void findByNameItem() {
        System.out.println("---------------------Поиск заявок по имени-----------------------------------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        for (int i = 0; i < items.length; i++){
            System.out.println(items[i].getId() + " " + items[i].getName() + " " + items[i].getDesc());
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактирвать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти по ID");
        System.out.println("5. Найти по имени");
        System.out.println("6. Выход");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
