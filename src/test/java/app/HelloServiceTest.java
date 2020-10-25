package app;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class HelloServiceTest {
    private final static String WELCOME = "Hello";

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
        String hola = "Hola";
        LangRepository mockReposetory = new LangRepository() {
            @Override
            Optional<Language> findById(Long id) {
                if(id.equals(HelloService.FALLBACK_LANG.getId())) {
                    return Optional.of(new Language(null, hola, null));
                }
                return Optional.empty();
            }
        };

        HelloService serviceTest = new HelloService(mockReposetory);

        String name = "test";

        String result = serviceTest.prepareGreeting(null, null);

        assertEquals(hola + " " + HelloService.FALLBACK_NAME + "!", result);

    }

    private LangRepository getMockLangReposetory() {
        /**
        * Always return Hello Repository
         */
        return new LangRepository() {
            @Override
            Optional<Language> findById(Long id) {
                return Optional.of(new Language(null, WELCOME, null));
            }
        };
    }
}
