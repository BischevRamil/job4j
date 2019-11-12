package collections.generic;

/**
 * @author Bischev Ramil
 * @since 2019-11-12
 * Класс расширяет AbstractStore для работы с экземплярами класса User
 */

public class UserStore extends AbstractStore<User> {
    UserStore(int size) {
        super(size);
    }
}
