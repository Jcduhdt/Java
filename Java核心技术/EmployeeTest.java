import java.time.LocalDate;

/**
 * time:2019-5-20
 * author: Zhang Xiong
 * This program tests the Employee class
 * 员工信息以及加薪
 */
public class EmployeeTest
{
    public static void main(String[] args)
    {
        //fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("星",180000,2020,6,30);
        staff[1] = new Employee("幻",250000,2022,8,25);
        staff[2] = new Employee("逸",350000,2024,4,6);

        //raise everyone's salary by 5%
        for (Employee e:staff)
            e.raiseSalary(5);

        //print out information zhout all Employee objects
        for (Employee e:staff)
            System.out.println("name="+e.getName()+", salary="+e.getSalary()+", hireDay="+e.getHireDay());
    }
}

class Employee
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
