package springbook.learningtest.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import springbook.learningtest.spring.ioc.bean.Hello;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationContextTest6 {
    private String basePath = StringUtils.cleanPath(ClassUtils.classPackageAsResourcePath(getClass())) + "/";
    @Test
    public void genericXmlApplicationContext() {
        // 애플리케이션 컨텍스트 생성과 동시에 XML 파일을 읽어오고 초기화까지 수행한다.
        GenericApplicationContext ac = new GenericXmlApplicationContext(basePath + "genericApplicationContext.xml");

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        System.out.println(ac.getBean("printer").toString());

        assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
    }
}
