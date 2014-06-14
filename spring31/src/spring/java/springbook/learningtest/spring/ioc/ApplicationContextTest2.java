package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest2 {
    @Test
    public void registerBean() {
        // IoC 컨테이너 생성
        StaticApplicationContext ac = new StaticApplicationContext();

        // 빈 메타정보를 담은 오브젝트를 만든다. 빈 클래스는 Hello로 지정한다.
        // <bean class="springbook.learningtest...Hello" /> 에 해당하는 메타정보다.
        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        // 빈의 name 프로퍼티에 들어갈 값을 지정한다.
        // <property name="name" value="Spring" />에 해당한다.
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        // 설정을 마친 빈 메타정보를 hello2라는 이름을 가진 빈으로 컨테이너에 등록한다.
        // <bean id="hello2" ... />에 해당한다.
        ac.registerBeanDefinition("hello2", helloDef);

        // 컨테이너로 부터 hello2라는 이름을 가진 빈을 가져온다.
        Hello hello2 = ac.getBean("hello2", Hello.class);
        // 설정한 속성이 잘 반영되었는지 출력해 본다.
        System.out.println(hello2.sayHello());
        // 출력 되는 결과를 확인한다.
        assertThat(hello2.sayHello(), is("Hello Spring"));
    }
}
