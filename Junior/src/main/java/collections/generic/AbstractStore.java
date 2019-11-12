package collections.generic;

/**
 * @author Bischev Ramil
 * @since 2019-11-12
 * Абстрактный класс с обобщением с ограничением сверху классом Base. Реализует методы работы с данными.
 * @param <T>
 */

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> data;

    /**
     * Конструктор
     * @param size размер массива
     */
    public AbstractStore(int size) {
        this.data = new SimpleArray<>(size);
    }

    /**
     * Добавление нового User или Role
     * @param model User или Role
     */
    public void add(T model) {
        this.data.add(model);
    }

    /**
     * Метод проверяет совпадение строки с именем элемента El
     * @param id строка
     * @param el User или Role имя которого нужно сравнить со строкой id
     * @return true если совпадает
     */
    private boolean checkId(String id, T el) {
        return id.equals(el.getId());
    }

    /**
     * Метод заменяет модель с именем id на новую модель model
     * @param id
     * @param model
     * @return true если есть такая модель и она заменена
     */
    public boolean replace(String id, T model) {
     boolean result = false;
        for (int i = 0; i < this.data.lenght(); i++) {
            if (checkId(id, data.get(i))) {
                result = data.set(i, model);
                break;
            }
        }
     return result;
    }

    /**
     * Метод удалет модель с именем id
     * @param id
     * @return true если есть такая модель и она удалена
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.data.lenght(); i++) {
            if (checkId(id, data.get(i))) {
                result = data.remove(i);
                break;
            }
        }
        return result;
    }


    public T findById(String id) {
        T result = null;
        for (int i = 0; i < data.lenght(); i++) {
            if (checkId(id, data.get(i))) {
                result = data.get(i);
                break;
            }
        }
        return result;
    }
}
