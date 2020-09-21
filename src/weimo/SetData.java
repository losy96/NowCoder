package weimo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SetData {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); //该方法调用多次,出现IllegalThreadStateException
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("hellow_world!");
    }
}
