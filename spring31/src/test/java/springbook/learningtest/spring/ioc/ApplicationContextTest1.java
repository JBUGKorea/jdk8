package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.*;
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

        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        ac.registerBeanDefinition("hello2", helloDef);

        Hello hello2 = ac.getBean("hello2", Hello.class);
        System.out.println(hello2.sayHello());
        assertThat(hello2.sayHello(), is("Hello Spring"));
        assertThat(hello1, is(not(hello2)));

        assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));
    }
}
