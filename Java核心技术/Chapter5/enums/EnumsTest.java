package enums;

import java.util.Scanner;

/**
 * This program demostrates enumerated types.
 * @version V12.0.1 2019-6-20
 * @author Zhang Xiong
 */

/*
 * 枚举类enum
 * 每个枚举类型都有一个静态的values方法，他将返回一个包含全部枚举值的数组
 */
public class EnumsTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL,MEDIUM,LARGE,EXTRA_LARGE)");
        String input = in.next().toUpperCase();//这个toUpperCase()是啥
        Size size = Enum.valueOf(Size.class,input);//toSring的逆方法是静态方法valueOf
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}

enum Size
{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    private String abbreviation;
    private Size(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation()
    {
        return abbreviation;
    }
}