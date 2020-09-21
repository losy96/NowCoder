package pattern.SingleInstance;

public class SingleHungryMan {
    private static SingleHungryMan singleHungryMan = new SingleHungryMan();
    //饿汉模式
    public static SingleHungryMan getSingle0(){
        return singleHungryMan;
    }
}
