package ood.tdd.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Ignore
    @Test
    public void whenInsertNameAndSubjectThanReturnResult() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are ${subject}?";
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("name", "Petr");
        inputMap.put("subject", "you");
        String expected = "I am Petr, Who are you?";
        String result = generator.produce(text, inputMap);
        assertThat(result, is(expected));
    }

    @Ignore
    @Test
    public void whenInsertOneNameThenReturnName() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are you?";
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("name", "Petr");
        String expected = "I am Petr, Who are you?";
        String result = generator.produce(text, inputMap);
        assertThat(result, is(expected));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenAddNotEnoughKeysThenException() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are you?";
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("name", "Petr");
        inputMap.put("subject", "you");
        String expected = "I am Petr, Who are you?";
        String result = generator.produce(text, inputMap);
        assertThat(result, is(expected));
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenAddToManyKeysThenException() throws Exception {
        Generator generator = new SimpleGenerator();
        String text = "I am ${name}, Who are ${subject}? Where are ${object}?";
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("name", "Petr");
        inputMap.put("subject", "you");
        String expected = "I am Petr, Who are you?";
        String result = generator.produce(text, inputMap);
        assertThat(result, is(expected));
    }
}
