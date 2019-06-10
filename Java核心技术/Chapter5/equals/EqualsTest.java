package equals;


/**
 * this program demonstrates the equals method
 * @version V12.0.1 2019-6-10
 * @author Zhang Xiong
 */
public class EqualsTest
{
    public static void main(String[] args)
    {
        Employee alice1 = new Employee("Alice Adams",75000,1987,12,15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams",75000,1987,12,15);
        Employee bob = new Employee("Bob Brandson",50000,1989,10,1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));
        System.out.println("alice1 == alice3: " + (alice1 == alice3));
        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
        System.out.println("bob.toString(): " + bob);//调用x.toString() 的地方可以用"" + x代替
        //如果x是任意一个对象，并调用System.out.println(x); 就会直接调用x.toString()方法

        Manager carl = new Manager("Carl Cracker",80000,1987,12,15);
        Manager boss = new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);

        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
    }
}
