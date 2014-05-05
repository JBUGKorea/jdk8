package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest3 {
    @Test
    public void registerBean() {
        // IoC 컨테이너 생성
        StaticApplicationContext ac = new StaticApplicationContext();

        // Hello 클래스를 hello1이라는 이름의 싱글톤 빈으로 컨테이너에 등록
        ac.registerSingleton("hello1", Hello.class);

        // 빈 메타정보를 담은 오브젝트를 만든다. 빈 클래스는 Hello로 지정한다.
        // <bean class="springbook.learningtest...Hello" /> 에 해당하는 메타정보다.
        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        // 빈의 name 프로퍼티에 들어갈 값을 지정한다.
        // <property name="name" value="Spring" />에 해당한다.
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        // 설정을 마친 빈 메타정보를 hello2라는 이름을 가진 빈으로 컨테이너에 등록한다.
        // <bean id="hello2" ... />에 해당한다.
        ac.registerBeanDefinition("hello2", helloDef);

        // 컨테이너로 부터 hello1라는 이름을 가진 빈을 가져온다.
        Hello hello1 = ac.getBean("hello1", Hello.class);
        // 컨테이너로 부터 hello2라는 이름을 가진 빈을 가져온다.
        Hello hello2 = ac.getBean("hello2", Hello.class);

        // 두 빈이 모두 동일한 Hello 클래스지만 별개의 오브젝트로 생성됐다.
        assertThat(hello1, is(not(hello2)));

        // 컨테이너에 등록된 빈의 갯수를 출력한다.
        System.out.println(ac.getBeanFactory().getBeanDefinitionCount());

        // 컨테이너에 등록된 빈의 갯수를 확인한다.
        assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));
    }
}
