package pattern.staticproxy;

public class StaticProxyPattern {
    //写个静态代理
    public static void main(String[] args) {
        SayHello sayHello = new ProxyLihaoSayHello();
        sayHello.say();
    }
}
