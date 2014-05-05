package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest1 {
    @Test
    public void registerBean() {
        // IoC 컨테이너 생성
        StaticApplicationContext ac = new StaticApplicationContext();
        // Hello 클래스를 hello1이라는 이름의 싱글톤 빈으로 컨테이너에 등록
        ac.registerSingleton("hello1", Hello.class);

        // IoC 컨테이너에 등록된 hello1이라는 빈을 얻어온다.
        Hello hello1 = ac.getBean("hello1", Hello.class);
        // setter 호출
        hello1.setName("oopchoi");
        // 정상적으로 출력되는지 확인
        System.out.println(hello1.sayHello());
        // null이 아닌지 테스트한다.
        assertThat(hello1, is(notNullValue()));
    }
}
