package www.wss;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: WSS
 * @Date: 2019/3/30 19:20
 * @Description: 反射与简单Java类
 *
 *  avaEE使用到的所有开发框架里面到处都是反射的身影，没有反射就没有开发框架
 *
 *  1.反射与单级VO操作
 *      如果现在有一个简单Java类，按照原始的做法使用getter与setter对属性进行操作
 *      假设一个类中存在有几十个属性，要按照原始做法，要调用几十次setter方法，这样操作就太麻烦了。
 *      现在希望能对程序做简化，输入字符串"属性名称:属性值|属性名称:属性值|属性名称:属性值|...."，就可以将类中
 *      的属性设置好。希望通过此程序实现任意的简单Java类的属性设置。
 *
 *      设计思路:所有的操作是通过TestDemo类调用EmpAction类实现的，而EmpAction类的主要作用是在于定位要操作的属性类型。
 *      同时该程序应该符合于所有简单的Java类开发形式，因此对于我们的设计而言必须有一个单独的类(BeanOperation)(实现此适配。
 *
 *  2.多级VO设置实现
 *      假设现在一个雇员(EMP)属于一个部门(dept)，一个部门属于一个公司。这种类似的关系都可以通过字符串的配置来设置内容。
 *      所有的引用关系上都自动进行了对象实例化。而现在希望程序既可以满足单级VO或多级VO操作，所以对于内容的设置可能采用如下代码出现：
 *      String value = "emp.ename:yuisama|emp.job:Java Coder|emp.dept.name:教务部|emp.dept.company.cname=bit" ;
 */
/*Emp类设计*/
class Emp {
    private String ename ;
    private String job ;
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

/*测试多级VO操作*/
/*Company类*/
class Company{
    private String cname;
    private String address;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

/*Dept类*/
class Dept{
    private String dname;
    private String loc;
    private Company company = new Company();

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", company=" + company +
                '}';
    }
}

class SecoundEmp{
    private String ename;
    private String job;
    private Dept dept = new Dept();

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "SecoundEmp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", dept=" + dept +
                '}';
    }
}



/*EmpAction类设计*/
class EmpAction{
    private Emp emp = new Emp();
    private SecoundEmp secoundEmp = new SecoundEmp();
    //单级VO
    public void setValue(String value) throws NoSuchMethodException,
            NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        BeanOperation.setBeanValue(this,value);
    }
    //多级VO
    public void secoundSetValue(String value) throws NoSuchMethodException,
            NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        BeanOperation.secoundSetBeanValue(this,value);
    }
    public Emp getEmp(){
        return emp;
    }

    public SecoundEmp getSecoundEmp() {
        return secoundEmp;
    }
}
public class ReflectionAndSimpleJavaClass {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        /*
            原始做法：多次调用setter方法，太麻烦
            Emp emp = new Emp();
            emp.setEname("zs");
            emp.setJob("Java Coder");
            System.out.println(emp);
        */

        //VO操作
//        String value = "emp.ename:zs|emp.job:Java Coder";
//        EmpAction empAction = new EmpAction();
//        empAction.setValue(value);
//        System.out.println(empAction.getEmp());
        /*
            结果：
            Emp{ename='zs', job='Java Coder'}
        */

        /*多级VO操作*/
        String value2 = "secoundEmp.ename:zs|secoundEmp.job:Java Coder|secoundEmp.dept.dname:kfb|secoundEmp.dept.company.cname:bit";
        EmpAction empAction2 = new EmpAction();
        empAction2.secoundSetValue(value2);
        System.out.println(empAction2.getSecoundEmp());
        /*
            结果：
            SecoundEmp{ename='zs', job='Java Coder', dept=Dept{dname='kfb', loc='null', company=Company{cname='bit', address='null'}}}
        */
    }
}
