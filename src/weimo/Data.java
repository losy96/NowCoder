package weimo;

import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Integer> data = new ArrayList<>();
    static volatile Integer set_i = 0;
    static volatile Integer get_i = 0;
    synchronized public Integer getData(){
        Integer num = null;
        if (get_i<set_i){
            num = data.get(get_i);
            get_i++;
        }
        return num;
    }
    public void setData(Integer num){
        synchronized (this){
            data.add(num);
            set_i++;
        }
    }
}
