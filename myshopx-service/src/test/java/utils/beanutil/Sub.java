package utils.beanutil;

import com.alibaba.fastjson.JSON;

/**
 * Created by dell on 2016/2/2.
 */
public class Sub  extends  Sup{

    private int name;

//    public int getName() {
//        return name;
//    }
//
//    public void setName(int name) {
//        this.name = name;
//    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.setName("123");
        System.out.println(JSON.toJSONString(sub));
        //sub.name = "abc";
    }
}
