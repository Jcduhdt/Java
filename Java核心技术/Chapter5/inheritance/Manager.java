package inheritance;

/**
 * This program demonstrates object construction.
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */
// extends 继承
public class Manager extends Employee
{
    private double bonus; //管理人员有奖金

    /**
     * @param name the employee's name
     * @param salary the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public Manager(String name,double salary,int year,int month,int day)
    {
        super(name,salary,year,month,day);//调用超类的构造函数
        bonus = 0;
    }

    public double getSalary()
    {
        double baseSalary = super.getSalary();//调用超类的方法 因为这是改变子类继承于父类相同名字方法
        return baseSalary + bonus;
    }

    public void setBonus(double b)
    {
        bonus = b;
    }
}
