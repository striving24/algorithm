package lanqian.java2013_a;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 马祥
 * @Package lanqian.java2013_a
 * @date 2023-02-03 15:15
 * @Copyright © 2024未来可期
 */

public class Test1 {

    //基础知识补充
    //1、DataFormat类常用方法
    //public String format(Date date)：将Date对象格式化为字符串
    @Test
    public void test3() throws Exception{
        Date date = new Date();
        //创建一个日期格式化对象，将其转化为指定的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String s = dateFormat.format(date);
        System.out.println(s);
    }

    //public Date parse(String source)：将字符串解析为Date对象
    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String str = "2023年2月3日";
        Date date = dateFormat.parse(str);
        System.out.println(date);
    }

    //综合练习：题目：请使用日期时间相关的API，计算出一个人已经出生了多少天。
    /*
    * 思路：1、获取当前的时间并转换为秒数
    *      2、通过键盘输入得到出生日期并将其转换为秒数
    *      3、相减即可得到结果
    */
    @Test
    public void test1() throws ParseException {
        System.out.println("请输入您的生日：格式为yyyy-MM-dd");
        //键盘输入出生日期
        String birthday = new Scanner(System.in).next();
        //将输入的字符串对象转换为Data对象-日期模式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(birthday);
        //获得当前日期
        Date curData = new Date();
        //将两个日期转换为秒来计算
        long time = date.getTime();
        long curTime = curData.getTime();
        //计算得到结果
        long res = curTime - time;
        //再将其进行判断一下
        if (res < 0){
            System.out.println("未出生");
        }else {
            System.out.println(res/60/60/24);
        }
    }
    //3、Calendar日历类
    //注：该类为抽象类，通过getInstance返回子类对象
    //常用get和set方法来获得，指定当前所需要的时间
    /*
    常用的日历字段代表及含义：
    YEAR:年
    MONTH:月（从0开始，可以加1使用）
    DAY_OF_MONTH:月中的几天（几号）
    HOUR_OF_DAY:时（24小时制）
    MINUTE:分
    SECOND:秒
    DAY_OF_WEEK:周中的几天（周几，周日为1，可减一使用）
    */


    //该题解答如下：
    /*
    思路：从1999年以一百年为单位向后遍历，通过api得到当天是周几并判断即可
    * */
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        for (int year = 1999; year < 10000; year+=100) {
            //设置好要求日期：xx99-12-31
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, 11);
            cal.set(Calendar.DAY_OF_MONTH,31);
            //获取结果
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if (day == 1){
                System.out.println(year);//答案：2299
                break;
            }
        }
    }
}
