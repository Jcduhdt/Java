import java.util.Random;

/**
 * This program demonstrates object construction.
 * @version V12.0.1 2019-5-21
 * @author Zhang Xiong
 */
public class ConstructorTest
{
    public static void main(String[] args)
    {
        //fill the staff array with three Employee objects
        Employee_3[] staff = new Employee_3[3];

        staff[0] = new Employee_3("星",180000);
        staff[1] = new Employee_3(250000);
        staff[2] = new Employee_3();

        //print out information zhout all Employee objects
        for (Employee_3 e:staff)
            System.out.println("name="+e.getName()+", id="+e.getId()+", salary="+e.getSalary());
    }
}

class Employee_3
{
    private static int nextId;

    private String name = "";//instance filed initialization
    private double salary;
    private int id;

    // static initialization block
    static
    {
        Random generator = new Random();//随机数生成器
        nextId = generator.nextInt(10000);//生成一个0-9999之间的随机整数
    }

    // 对象产生时初始化
    {
        id = nextId;
        nextId++;
    }

    public Employee_3(String n,double s)
    {
        name = n;
        salary = s;
    }

    public Employee_3(double s)
    {
        //call the Employee(String, double) constructor
        this("Employee #" + nextId, s);
    }

    public Employee_3()
    {
        // name initialized to "" --see above
        // salary not explicitly set --initialized to 0
        // id initialized in initialization block
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
}
