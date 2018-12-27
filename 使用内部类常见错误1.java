class A{ 
 int y=6; 
 class Inner{ 
 static int y=3; 
 void show(){ 
 System.out.println(y); 
 } 
 } 
} 
class Demo{ 
 public static void main(String [] args){ 
 A.Inner inner=new A().new Inner(); 
 inner.show(); 
 } 
} 
