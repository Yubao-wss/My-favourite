package www.wss;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: WSS
 * @Date: 2019/3/30 19:30
 * @Description: 公共程序类
 *
 * 本类主要负责实现自动的VO匹配处理操作
 */
public class BeanOperation {
    private BeanOperation(){}

    /***
     * 负责设置类中的属性操作
     * @param actionObject 表示当前发出设置请求的程序类的当前对象
     * @param msg 属性的具体内容，格式为："属性名称:内容|属性名称：内容..."  eg: emp.ename:zs|emp.job:Java Coder
     */
    public static void setBeanValue(Object actionObject,String msg) throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException, NoSuchFieldException {

        //想要进行内容的设置，必须将字符串拆分
        //按照竖线拆分，取出所有要设置的内容
        String[] result = msg.split("\\|");

        for(int i = 0;i < result.length;i++){
            //需要针对属性名称及内容做进一步拆分
            String[] temp = result[i].split(":");
            //属性名称 "emp.ename"
            String attribute = temp[0];
            //属性内容
            String value = temp[1];
            String[] fields = attribute.split("\\.");
            //获取当前操作的简单Java类对象
            Object currentObject = getObject(actionObject,fields[0]);
            //调用简单Java类的Setter方法
            setObjectValue(currentObject,fields[1],value);
        }
    }

    //适用于多级VO操作的setBeanValue
    public static void secoundSetBeanValue(Object actionObject,String msg) throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException, NoSuchFieldException {

        //想要进行内容的设置，必须将字符串拆分
        //按照竖线拆分，取出所有要设置的内容
        String[] result = msg.split("\\|");

        for(int i = 0;i < result.length;i++){
            //需要针对属性名称及内容做进一步拆分
            String[] temp = result[i].split(":");
            //属性名称 "emp.ename"
            String attribute = temp[0];
            //属性内容
            String value = temp[1];
            String[] fields = attribute.split("\\.");

            if (fields.length > 2){// 存在多级
                //多级VO操作
                //如果要想通过多级确定出属性的操作对象。就要一层层找出每一个getter方法返回的内容

                Object currentObject = actionObject;// 确定当前操作的对象
                for (int x = 0;x < fields.length-1;x++){
                    //对应getter的返回对象
                    //循环结束一定能拿到最后一层的当前对象
                    currentObject = getObject(currentObject,fields[x]);
                }
                setObjectValue(currentObject,fields[fields.length - 1],value);
            }else {
                // 单级VO
                //获取当前操作的简单Java类对象
                Object currentObject = getObject(actionObject,fields[0]);
                //调用简单Java类的Setter方法
                setObjectValue(currentObject,fields[1],value);
            }
        }
    }

    /***
     * 将给定字符串的首字母大写
     * @param str 给定的字符串
     * @return 返回首字母大写的字符串
     */
    public static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

    /***
     * 负责调用XXXAction类中的getter方法取得简单Java类对象(属性所在类的实例化对象)
     * @param obj 表示调用方法的所在类对象
     * @param attribute 表示属性名称
     * @return 调用对象结果
     */
    public static Object getObject(Object obj,String attribute) throws NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "get" + initCap(attribute);
        //调用指定属性的File对象，目的是取得对象类型，如果没有此属性意味着操作无法继续进行
        Field field = obj.getClass().getDeclaredField(attribute);
        if(field == null){
            //第二次尝试从父类中取得该属性
            field = obj.getClass().getField(attribute);
        }
        if (field == null){
            //两次都未取得指定属性的对象，表示该对象一定不存在
            return null;
        }
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }

    /***
     * 根据指定的类对象设置属性，调用setter方法
     * @param obj 属性所在类的实例化对象
     * @param attribute 属性名称
     * @param value 属性内容
     */
    public static void setObjectValue(Object obj,String attribute,String value) throws NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(attribute);
        //判断属性是否存在
        if(field == null){
            //第二次尝试从父类中取得该属性
            field = obj.getClass().getField(attribute);
        }
        if(field == null){
            // 两次都未取得指定属性的对象，表示该对象一定不存在
            return;
        }
        String methodName = "set" + initCap(attribute);
        Method setMethod = obj.getClass().getMethod(methodName,field.getType());
        setMethod.invoke(obj,value);
    }
}
