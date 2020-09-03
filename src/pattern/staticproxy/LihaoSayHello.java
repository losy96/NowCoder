package pattern.staticproxy;

public class LihaoSayHello implements SayHello{
    LihaoSayHello(){
        System.out.println("init lihao say hello");
    }
    @Override
    public void say() {
        System.out.println("lihao say hello");
    }
}
