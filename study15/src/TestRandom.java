import java.util.Random;

/**
 * @Auther: WSS
 * @Date:
 * @Description Random类
 *              Math类中虽然为我们提供了产生随机数的方法Math.random()，但是通常我们需要的随机数范围并不是[0, 1)之间的double类型的数据，这就需要对其进行一些复杂的运算。
 *              如果使用Math.random()计算过于复杂的话，我们可以使用例外一种方式得到随机数，即Random类，
 *              这个类是专门用来生成随机数的，并且Math.random()底层调用的就是Random的nextDouble()方法。
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        //随机生成[0,1)之间的double类型的数据
        System.out.println(random.nextDouble());//0.7375961612144067
        //随机生成int类型允许范围内的整型数据
        System.out.println(random.nextInt());//843573711
        //随机生成[0,1)之间的float类型的数据
        System.out.println(random.nextFloat());//0.35971642
        //随机生成false或true
        System.out.println(random.nextBoolean());//true
        //随机生成[0,10)之间的int类型的数据
        System.out.println(random.nextInt(10));//6
        //随机生成[10,20)之间的int类型的数据
        System.out.println(10+random.nextInt(10));//11
        //随机生成[10,20)之间的int类型的数据(另一种计算方法）
        System.out.println(10+(int)(random.nextDouble()*10));//18
    }
}
