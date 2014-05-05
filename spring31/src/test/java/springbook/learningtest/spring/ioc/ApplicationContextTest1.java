package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 14. 5. 5.
 * Time: 오후 6:27
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextTest1 {
    @Test
    public void registerBean() {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("hello1", Hello.class);

        Hello hello1 = ac.getBean("hello1", Hello.class);
        hello1.setName("oopchoi");
        System.out.println(hello1.sayHello());
        assertThat(hello1, is(notNullValue()));
    }
}
