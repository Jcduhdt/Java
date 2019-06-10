package equals;

// 该类在这个文件夹并且是这个文件夹的一部分

/**
 * This program demonstrates object construction.
 * @version V12.0.1 2019-6-10
 * @author Zhang Xiong
 */

import java.time.LocalDate;
import java.util.Objects;

public class Employee
{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public LocalDate getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary*byPercent/100;
        salary += raise;
    }

    public boolean equals(Object otherObject)//比较两个对象是否相等，如果两个对象指向同一块存储区域，方法返回true
            //自定义类中，应覆盖这个方法
    {
        //a quick test to see if the objects are identical
        if (this == otherObject)
            return true;

        //must return false if the explicit parameter is null
        if (otherObject == null)
            return false;

        //now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;

        //test whether the fields have identical values
        return Objects.equals(name, other.name) && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode()
    {
        return Objects.hash(name,salary,hireDay);
    }

    public String toString()//返回描述该对象值的字符串，自定义类中，应该覆盖这个方法
    {
        //Class getClass()  返回包含对象信息的类对象
        return getClass().getName() + "[name=" + name + ",salary=" + salary +",hireDay" + hireDay + "]";
    }
}
