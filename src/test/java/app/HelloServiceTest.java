package app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HelloServiceTest {
    private HelloService serviceTest = new HelloService(new LangRepository());
    @Test
    public void test_null_prepareGreeting_returnValue() throws Exception {

        String result = serviceTest.prepareGreeting(null);

        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);

    }

    @Test
    public void test_name_prepareGreeting_returnsWithName() throws Exception {
        String name = "test";

        String result = serviceTest.prepareGreeting(name);

        assertEquals("Hello " + name + "!", result);

    }
}
