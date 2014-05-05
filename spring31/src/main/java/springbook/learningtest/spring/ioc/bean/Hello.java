package springbook.learningtest.spring.ioc.bean;


public class Hello {
    private String name;
    private Printer printer;

    public Hello() {
    }

    public Hello(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    public String sayHello() {
        return "Hello " + name;	// 프로퍼티로 DI 받은 이름을 이용해 간단한 인사문구 만들기
    }

    public void print() {
        // DI에 의해 의존 오브젝트로 제공받은 Printer 타입의 오브젝트에게 출력 작업을 위임한다.
        // 구체적으로 어떤 방식으로 출력하는지는 상관하지 않는다.
        // 또한 어떤 방식으로 출력하도록 변경해도 Hello의 코드는 수정할 필요가 없다.
        this.printer.print(this.sayHello());
    }

    // 인사문구에 쓸 이름을 스트링 값으로 DI 받을 수 있다.
    public void setName(String name) {
        this.name = name;
    }

    // 출력을 위해 사용할 Printer 인터페이스를 구현한 오브젝트를 DI 받는다.
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Printer getPrinter() {
        return printer;
    }
}