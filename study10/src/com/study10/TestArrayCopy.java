package com.study10;

/**
 * @Auther: WSS
 * @Date:
 * @Description 数组拷贝
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = testBasicCopy3(s1,1);
        for (int i = 0;i<s2.length;i++){
            System.out.println(s2[i]);
        }
        }
        //基本数组拷贝
        public static void testBasicCopy() {
        String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1, 2, s2, 6, 3);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(i + "  " + s2[i]);
            }
        }
        //结果
        /*0  null
        1  null
        2  null
        3  null
        4  null
        5  null
        6  cc
        7  dd
        8  ee
        9  null*/

        //从数组中删除某个元素（本质上还是数组的拷贝）
        public static void testBasicCopy2() {
            String[] s1 = {"aa", "bb", "cc", "dd", "ee"};
//            String[] s2 = new String[5];
            System.arraycopy(s1, 3, s1, 3-1, s1.length-3);
            s1[s1.length-1] = null;
            for (int i = 0; i < s1.length; i++) {
                System.out.println(i + "  " + s1[i]);
            }
        }
        //结果
        /*0  aa
        1  bb
        2  dd
        3  ee
        4  null*/
        //删除数组中指定索引位置的元素，并将原数组返回
        public static String[] testBasicCopy3(String[] s,int index) {
            System.arraycopy(s, index+1, s, index, s.length-index-1);
            s[s.length-1] = null;
            return s;
        }

        //数组的扩容（本质上：先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中）
        public static String[] extendRange(String[] s,int index){
            String[] s2 = new String[s.length+index];
            System.arraycopy(s,0,s2,0,s.length);
            return s2;
        }
        //在数组指定索引位置插入一个元素...
}
