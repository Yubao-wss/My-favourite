import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.print.DocFlavor;

public class Main {

    public static void main(String[] args) {
        /*double d = Math.random();   //返回【0,1)之间的随机数
        System.out.println(d);
        System.out.println((int)(6*Math.random()+1));
        System.out.println("################骰子游戏###################");
        int i = (int)(6*Math.random())+1;
        int j = (int)(6*Math.random())+1;
        int k = (int)(6*Math.random())+1;
        int count = i + j + k;
        if(count > 15){
            System.out.println("今天手气不错");
        }
        if(count >= 10 && count <= 15){
            System.out.println("今天手气一般");
        }
        if(count < 10){
            System.out.println("今天手气不怎么样");
        }
        System.out.println("得了" + count + "分");*/
        /*1*/



        /*double r = 4 * Math.random();
        double area = Math.PI * Math.pow(r, 2);
        double circle = 2 * Math.PI * r;
        System.out.println("半径为：" + r);
        System.out.println("面积为：" + area);
        System.out.println("周长为：" + circle);
        if (area >= circle) {
            System.out.println("面积大于等于周长");
        } else {
            System.out.println("周长大于面积");
        }*/
        /*2*/



        /*int age = (int)(100*Math.random());
        System.out.println("年龄是" + age + ",属于");
        if (age<15){
            System.out.println("儿童，喜欢玩");
        }
        else if (age<25){
            System.out.println("青年，要学习");
        }
        else if (age<45){
            System.out.println("中年，要工作");
        }
        else if (age<65){
            System.out.println("中老年，要补钙");
        }
        else if (age<85){
            System.out.println("老年，多运动");
        }
        else {
            System.out.println("老寿星，古来稀");
        }*/
        /*3*/




        /*char c = 'a';
        int rand = (int)(26*Math.random());
        char c2 = (char)(c+ rand);
        System.out.print(c2+":");

        switch (c2){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.print("元音");
                break;
            case 'y':
            case 'w':
                System.out.print("半元音");
                break;
            default:
                System.out.print("辅音");
        }*/
        /*4*/



        /*int i = 1;
        int sum = 0;
        while (i<=100){
            sum = sum + i;
            i++;
        }
        System.out.println(sum);

        sum = 0;
        i = 1;
        do {
            sum += i;
            i++;
        }while (i <= 200);
        System.out.println(sum);*/
        /*5.while,do-while*/



        /*for (int i = 1,j = i + 10;i < 5;i++,j=i*2){
            System.out.println("i="+i+"j="+j);
        }
        for (int i = 1;i<=5;i++){
            for (int j=1;j<=5;j++){
                System.out.print(i+"\t");
            }
            System.out.println();
        }*/
        /*6.for*/



        /*int sum1=0;
        int sum2=0;
        for (int i=0;i<=100;i++){
            if (i%2 == 0){
                sum1+=i;
            }else {
                sum2+=i;
            }
        }
        System.out.println("100以内的偶数和："+sum1+"\t"+"100以内的奇数和："+sum2);*/
        /*计算100以内的奇数及偶数和，并输出*/



        /*int count=0;
        for (int i=1;i<=1000;i++){
            if (i%5 == 0){
                System.out.print(i+"\t");
                count++;
                if (count%5 == 0){
                    System.out.println();
                }
            }
        }*/
        /*输出1~1000之间能被5整除的数，且每行输出5个*/



        /*int total = 0;
        while (true){
            total++;
            int i= (int) Math.round(100*Math.random());
            if (i == 88){
                break;
            }
        }
        System.out.println(total);*/
        /*7.break*/




        /*int count=0;
        for (int i=100;i<150;i++){
            if (i%3==0){
                continue;
            }
            System.out.print(i+"、");
            count++;
            if (count%5==0){
                System.out.println();
            }
        }*/
        /*8.continue,把100~150之间不能被3整除的数输出*/



        /*outer:for (int i=101;i<150;i++){
            for (int j=2;j<i/2;j++){
                if(i%j==0){
                    continue outer;
                }
            }
            System.out.println(i);
        }*/
        /*9.continue调到外循环，实现输出101~150之间的所有质数*/



    }
}
