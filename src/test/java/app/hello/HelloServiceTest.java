package app.hello;

import app.lang.LangRepository;
import app.lang.Lang;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class HelloServiceTest {
    private final static String WELCOME = "Hello";
    private final static String FALLBACK_HOLA = "Hola";

    @Test
    public void test_nullName_prepareGreeting_returnValue() {

        LangRepository mockReposetory = getMockLangReposetory();

        HelloService serviceTest = new HelloService(mockReposetory);

        //when
        String result = serviceTest.prepareGreeting(null, "-1");

        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);

    }

    @Test
    public void test_name_prepareGreeting_returnsWithName() {
        LangRepository mockReposetory = getMockLangReposetory();

        HelloService serviceTest = new HelloService(mockReposetory);

        String name = "test";

        String result = serviceTest.prepareGreeting(name, "-1");

        assertEquals(WELCOME + " " + name + "!", result);

    }

    @Test
    public void test_nullLang_prepareGreeting_returnsIdLang() {

        LangRepository mockReposetory = fallbackLangIdReposetory();

        HelloService serviceTest = new HelloService(mockReposetory);

        String result = serviceTest.prepareGreeting(null, null);

        assertEquals(FALLBACK_HOLA + " " + HelloService.FALLBACK_NAME + "!", result);

    }

    @Test
    public void test_textLang_prepareGreeting_returnsIdLang() {

        LangRepository mockReposetory = fallbackLangIdReposetory();

        HelloService serviceTest = new HelloService(mockReposetory);

        String result = serviceTest.prepareGreeting(null, "aaa");

        assertEquals(FALLBACK_HOLA + " " + HelloService.FALLBACK_NAME + "!", result);

    }

    @Test
    public void test_nonExistingLang_returnsGreetingWithFallbackLang() {
        LangRepository mockReposetory = new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.empty();
            }
        };

        HelloService serviceTest = new HelloService(mockReposetory);

        String result = serviceTest.prepareGreeting(null, "-1");

        assertEquals(HelloService.FALLBACK_LANG.getGreetingMsg() + " " + HelloService.FALLBACK_NAME + "!", result);

    }

    private LangRepository fallbackLangIdReposetory() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                if (id.equals(HelloService.FALLBACK_LANG.getId())) {
                    return Optional.of(new Lang(null, FALLBACK_HOLA, null));
                }
                return Optional.empty();
            }
        };
    }

    private LangRepository getMockLangReposetory() {
        /**
        * Always return Hello Repository
         */
        return new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }

}
