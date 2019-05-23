package inheritance;

// 该类在这个文件夹并且是这个文件夹的一部分

/**
 * This program demonstrates object construction.
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */

import java.time.LocalDate;

public class Employee
{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n,double s,int year,int month,int day)
    {
        name = n;
        salary = s;
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
}
