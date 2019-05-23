package abstractClasses;

/**
 * This program demonstrates abstract classes.
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */

public class PersonTest
{
    public static void main(String[] args)
    {
        Person[]  people = new Person[2];

        people[0] = new Employee("夜",50000,1989,10,1);
        people[1] = new Student("星","人工智能");

        for (Person p:people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}
