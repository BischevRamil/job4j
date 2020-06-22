package multithreading.pool;

import org.junit.Test;

public class EmailNotificationTest {

    @Test
    public void test() {
        EmailNotification emailNotification = new EmailNotification();
        for (int i = 0; i < 10; i++) {
            emailNotification.emailTo(new User("name" + i, "name" + i + "@name.net"));
        }
        emailNotification.close();
        assert true;
    }
}
