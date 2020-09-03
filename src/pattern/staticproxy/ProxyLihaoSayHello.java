package pattern.staticproxy;

public class ProxyLihaoSayHello implements SayHello{
    private LihaoSayHello lihaoSayHello = new LihaoSayHello();
    ProxyLihaoSayHello(){
        System.out.println("init proxy lihao say hello");
    }
    @Override
    public void say() {
        System.out.println("before say");
        lihaoSayHello.say();
        System.out.println("after say");
    }
}
