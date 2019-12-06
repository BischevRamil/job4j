package collections.questions;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Bischev Ramil
 * @since 2019-12-03
 * Сколько добавлено новых пользователей.
 * Сколько изменено пользователей. Изменённым считается объект в котором изменилось имя. а id осталось прежним.
 * Сколько удалено пользователей.
 */

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> map = current.stream().collect(Collectors.toMap(User::getId, i -> i));
        int changed = 0;
        int deleted = 0;
        for (User userPrev : previous) {
            User removed = map.remove(userPrev.getId());
            if (removed == null) {
                deleted++;
            }
            for (User userCur : current) {
                if (userPrev.hashCode() == userCur.hashCode() && !(userPrev.equals(userCur))) {
                    changed++;
                }
            }
        }

        return new Info(map.size(), changed, deleted);
    }

    public static class User {
        final int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
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

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

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
