package collections.questions;

import java.util.List;
import java.util.Objects;

/**
 * @author Bischev Ramil
 * @since 2019-12-03
 * Сколько добавлено новых пользователей.
 * Сколько изменено пользователей. Изменённым считается объект в котором изменилось имя. а id осталось прежним.
 * Сколько удалено пользователей.
 */

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.setChanged(diffChange(previous, current));
        info.setAdded(diffAdded(previous, current));
        info.setDeleted(diffDeleted(previous, current));
        return info;
    }

    /**
     * Метод возвращает количество измененных юзеров. Проверяет хеш-коды юзеров каждый с каждым, если коды
     * одинаковые, но equals == false, значит было изменение имени.
     * @param previous
     * @param current
     * @return
     */
    private int diffChange(List<User> previous, List<User> current) {
        int changed = 0;
        for (User userPrev : previous) {
            for (User userCur : current) {
                if (userPrev.hashCode() == userCur.hashCode() && !(userPrev.equals(userCur))) {
                    changed++;
                }
            }
        }
        return changed;
    }

    /**
     * Метод возвращает количество добавленных юзеров.
     * @param previous
     * @param current
     * @return
     */
    private int diffAdded(List<User> previous, List<User> current) {
        int added = 0;
        for (User userCur : current) {
            if (!userCur.contains(previous)) {
                added++;
            }
        }
        return added;
    }

    /**
     * Метод возвращает количество удаленных юзеров.
     * @param previous
     * @param current
     * @return
     */
    private int diffDeleted(List<User> previous, List<User> current) {
        int deleted = 0;
        for (User userPrev : previous) {
            if (!userPrev.contains(current)) {
                deleted++;
            }
        }
        return deleted;
    }

    public static class User {
        final int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        boolean contains(List<User> list) {
            boolean rsl = false;
            for (User user : list) {
                if (this.hashCode() == user.hashCode()) {
                    rsl = true;
                    break;
                }
            }
            return rsl;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        void setAdded(int added) {
            this.added = added;
        }

        void setChanged(int changed) {
            this.changed = changed;
        }

        void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        int getAdded() {
            return added;
        }

        int getChanged() {
            return changed;
        }

        int getDeleted() {
            return deleted;
        }
    }
}
