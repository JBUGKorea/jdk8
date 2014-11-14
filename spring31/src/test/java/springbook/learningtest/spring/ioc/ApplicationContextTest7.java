package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import springbook.learningtest.spring.ioc.bean.Hello;
import springbook.learningtest.spring.ioc.bean.Printer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest7 {
    private String basePath = StringUtils.cleanPath(ClassUtils.classPackageAsResourcePath(getClass())) + "/";
    @Test
    public void genericXmlApplicationContext() {
        // 애플리케이션 컨텍스트를 부모 컨텍스트 메타 정보를 읽어서 생성한다.
        ApplicationContext parent = new GenericXmlApplicationContext(basePath + "parentContext.xml");
        // 부모를 받아서 자식 애플리케이션 컨텍스트를 생성하도록 하여 부모 자식 관계를 만든다.
        GenericApplicationContext child = new GenericApplicationContext(parent);
        // 자식 컨텍스트로 부터 리더를 생성한다.
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(child);
        // 리더를 사용해서 자식 컨텍스트 메타 정보를 로딩한다.
        reader.loadBeanDefinitions(basePath + "childContext.xml");
        // 리더를 통해서 메타 정보를 읽어들이는 경우에는 반드시 refresh()를 호출해서 초기화 해주어야 한다.
        child.refresh();

        // printer 빈을 자식 컨텍스트로 부터 얻어온다. (부모 컨텍스트에서 반환해준다.)
        Printer printer = child.getBean("printer", Printer.class);
        assertThat(printer, is(notNullValue()));

        // hello 빈을 자식 컨텍스트로 부터 얻어온다.
        // (부모 컨텍스트에도 존재하지만 자신 안에서 먼저 찾아왔기 때문에 부모 컨텍스트를 검색하지 않는다.)
        Hello hello = child.getBean("hello", Hello.class);
        assertThat(hello, is(notNullValue()));

        hello.print();
        assertThat(printer.toString(), is("Hello Child"));
    }
}
