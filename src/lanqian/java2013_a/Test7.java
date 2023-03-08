package lanqian.java2013_a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-06 14:32
 * @Copyright © 2024未来可期
 * 7、错误票据
 */

public class Test7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int len = s.nextInt();
        s.nextLine();//去掉整数后的换行符
        for (int i = 0; i < len; i++) {
            String line = s.nextLine();
            String[] s1 = line.split(" ");//以空格分割为string[]
            for (int j = 0; j < s1.length; j++) {
                list.add(Integer.parseInt(s1[j]));
            }
        }

        //先对list进行排序
        Collections.sort(list);
        int a = 0,b = 0;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).equals(list.get(i-1))){
                b = list.get(i);
            }
            if (list.get(i)-list.get(i-1) == 2){
                a = list.get(i)-1;
                //a = list.get(i-1)+1;
            }
        }
        System.out.println(a+" "+b);
    }
}
