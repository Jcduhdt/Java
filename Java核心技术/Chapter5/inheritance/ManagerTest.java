package inheritance;

/**
 * This program demonstrates inheritance
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */
public class ManagerTest
{
    public static void main(String[] args)
    {
	    // construct a Manager object
        Manager boss = new Manager("幽",80000,1987,12,15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;//Employee是Manager的超类  staff[0]对应Manager对象
        staff[1] = new Employee("游",50000,1989,10,1);
        staff[2] = new Employee("白",40000,1990,3,15);

        for (Employee e:staff)// 因为Manager Employee 两类 动态绑定 自动选择调用哪个方法
            System.out.println("name="+e.getName()+", salary="+e.getSalary());
    }
}
