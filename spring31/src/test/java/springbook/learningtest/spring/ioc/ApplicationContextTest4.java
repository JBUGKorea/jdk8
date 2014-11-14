package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;
import springbook.learningtest.spring.ioc.bean.StringPrinter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest4 {
    @Test
    public void registerBeanWithDependency() {
        StaticApplicationContext ac = new StaticApplicationContext();

        // StringPrinter 클래스 타입이며 printer라는 이름을 가진 빈을 등록한다.
        ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));

        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        // 단순 값을 갖는 프로퍼티 등록
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        // 아이디가 printer인 빈에 대한 레퍼런스를 프로퍼티로 등록
        helloDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));
        ac.registerBeanDefinition("hello", helloDef);

        Hello hello = ac.getBean("hello", Hello.class);
        // StringPrinter 타입의 printer 객체의 버퍼에 sayHello() 결과를 담는다.
        hello.print();

        // StringPrinter 타입의 printer 객체의 toString() 메서드를 호출하여 출력한다.
        System.out.println(ac.getBean("printer").toString());

        // Hello 클래스의 print()메소드는 DI 된 Printer 타입의 오브젝트에게 요청해서 인사말을 출력한다.
        // 이 결과를 스트링으로 저장해두는 printer 빈을 통해 확인한다.
        assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
    }
}
