package abstractClasses;

/**
 * This program demonstrates abstract classes.
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */

public class Student extends Person
{
    private String major;

    /**
     * @param name the student's name
     * @param major the student's major
     */
    public Student(String name, String major)
    {
        super(name);
        this.major = major;
    }

    public String getDescription()
    {
        return "a student majoring in "+ major;
    }
}
