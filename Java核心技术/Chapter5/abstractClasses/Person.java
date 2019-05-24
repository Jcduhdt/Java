package abstractClasses;

/**
 * This program demonstrates abstract classes.
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */

/*
 * 定义一个抽象的类
 * 有抽象的域或方法，该类一定为抽象
 * 但是抽象的类不一定有抽象的域或方法
 * 抽象的类不能创建对象，但是它的子类可以创建
 */
public abstract class Person
{
    public abstract String getDescription();
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
