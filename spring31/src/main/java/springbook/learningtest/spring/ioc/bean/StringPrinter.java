package springbook.learningtest.spring.ioc.bean;



public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

    // Printer 인터페이스의 메소드.
	public void print(String message) {
        // 내장 버퍼에 메시지를 추가해준다.
		this.buffer.append(message);
	}

	public String toString() {
        // 내장 버퍼에 추가해둔 메시지를 스트링으로 가져온다.
		return this.buffer.toString();
	}
}

