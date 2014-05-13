package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest5 {
    @Test
    public void genericApplicationContext() {
        GenericApplicationContext ac = new GenericApplicationContext();

        // 리더 생성
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ac);
        // 기본적으로 클래스패스로 정의된 리소스로 부터 파일을 읽는다.
        reader.loadBeanDefinitions("springbook/learningtest/spring/ioc/genericApplicationContext.xml");

        // 모든 메타정보가 등록이 완료됐으니 애플리케이션 컨테이너를 초기화하라는 명령이다.
        ac.refresh();

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        System.out.println(ac.getBean("printer").toString());

        assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
    }
}
