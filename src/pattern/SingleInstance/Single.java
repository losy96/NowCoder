package pattern.SingleInstance;


public class Single {
    /**
     * volatile关键字
     * 因为 single = new Single(); 这句话可以分为三步：
     *      1. 为 single 分配内存空间；
     *      2. 初始化 single；
     *      3. 将 single 指向分配的内存空间。
     *      但是由于JVM具有指令重排的特性，执行顺序有可能变成 1-3-2。 指令重排在单线程下不会出现问题，但是在多线程下会导致一个线程获得一个未初始化的实例。
     *      例如：线程T1执行了1和3，此时T2调用 getInstance() 后发现 single 不为空，因此返回 single， 但是此时的 single 还没有被初始化。
     *      使用 volatile 会禁止JVM指令重排，从而保证在多线程下也能正常执行。
     */
    private static volatile Single single;

    public static Single getInstance(){
        //双重循环验证
        if (null == single){
            //开始进入加锁
            //当前t1线程，在开始加锁之前如果时间片被线程t2抢走，如果不进行二次验证，则依旧会重复创建
            synchronized (Single.class){
                if (null == single){
                    single = new Single();
                }
                return single;
            }
        }else {
            return single;
        }
    }
}
