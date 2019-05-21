import java.time.LocalDate;

/**
 * time:2019-5-20
 * author: Zhang Xiong
 * This program demonstrates static methods
 * 员工信息以及加薪
 */
public class StaticTest
{
    public static void main(String[] args)
    {
        //fill the staff array with three Employee objects
        Employee_1[] staff = new Employee_1[3];

        staff[0] = new Employee_1("星",180000);
        staff[1] = new Employee_1("幻",250000);
        staff[2] = new Employee_1("逸",350000);

        //raise everyone's salary by 5%
        for (Employee_1 e:staff)
        {
            e.setId();//更新id
            System.out.println("name="+e.getName()+", id="+e.getId()+", salary= "+e.getSalary());
        }

       int n = Employee_1.getNextId();
        System.out.println("Next available id = "+n);
    }
}

class Employee_1
{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee_1(String n,double s)
    {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }

    public void setId()
    {
        id = nextId;
        nextId++;
    }
    public static int getNextId()
    {
        return nextId;
    }
    public static void main(String[] args) //静态的main方法用于单元测试
    {
        Employee_1 e = new Employee_1("Harry",500000);
        System.out.println(e.getName()+" "+e.getSalary());
    }
}
