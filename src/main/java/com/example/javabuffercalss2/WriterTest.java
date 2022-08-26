package com.example.javabuffercalss2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class WriterTest {
    // BufferedWriter 역시 BufferedReader 와 마찬가지로
    // IOException 처리를 별도로 해줘야 한다.
    // 보통 Exception 으로 throws 시키곤 한다.
    // try - catch 가 편리하면 tru - catch 로 처리해도 상관없다.

    public static void main(String[] args) throws Exception{
        // BufferedReader 는 입력값을 바이트스트림에서 문자스트림으로
        // 변환해주는 InputStreamReader 와 입력장치를 통해 값을 입력받아주는
        // System.in 을 사용했다고 한다면 BufferedWriter 는 출력이므로
        // 그에 반대로 작동하는 OutputStreamWriter 와
        // System.out 을 사용한다.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // BufferedWriter 객체를 이용하여 출력한다.


        bw.write("Hello World!");
        // write 한다고 해서 곧 바로 출력되지 않는다.
        // 직접 출력 stream 에 반영되는 것이 아니라 성능을 위해
        // buffer 에 저장해뒀다가 BufferedWriter 가 flush 되거나
        // close 되었을 때 한 번에 출력 stream 에 반영하기 때문이다.

        bw.flush();
        // close 는 stream 을 닫아버리기 때문에 계속 출력하고자 하거나, 버퍼를 초기화하고자 한다면
        // flush 를 사용한다.


        bw.newLine();
        // 출력 내용에서 줄바꿈이 필요하다면 newLine 함수를 사용한다.

        bw.write("new line\n");
        bw.write("new line2");
        // newLine 함수 또는 \n 을 통해 출력값의 앞뒤에 넣어서 줄바꿈으로 출력하기도 한다.

        bw.close();
        // 자바의 경우 GC를 통해 buffer 클래스 내부의 객체들이 자동으로 정리가 된다.
        // 하지만 GC에 의해 사용되지 않은 자원이 정리되기 전에 반복적으로 buffer 클래스가 close 되지 않고
        // 정상적으로 read 나 write 가 되지 않을 수 있다.
        // 그러므로 buffer 사용 후 자원관리를 위해서 반드시 close 함수를 통해 buffer 클래스를 닫아 주자.
    }
}
