package pattern.SingleInstance;

public class SingleNotHungryMan {
    //饱汉模式
    private static SingleNotHungryMan singleNotHungryMan;
    public static SingleNotHungryMan getSingleInstance(){
        if (null == singleNotHungryMan){
            singleNotHungryMan = new SingleNotHungryMan();
            return singleNotHungryMan;
        }else {
            return singleNotHungryMan;
        }
    }
}
