import com.horstmann.corejava.*;
// 导入该文件所在当前目录下的com/horstmann/corejava中的所有类
//其实就是导入Employee类  所以要将Employee.java文件放置在正确路径才能编译运行
import static java.lang.System.*;
/**
 * This program demonstrates object construction.
 * @version V12.0.1 2019-5-23
 * @author Zhang Xiong
 */
public class PackageTest
{
    public static void main(String[] args)
    {
        // 因为导入语句我们不必去用
        // com.horstmann.corejava.Employee here
        Employee harry = new Employee("Harry Hacker",50000,1989,10,1);

        harry.raiseSalary(5);

        //因为导入了静态语句，所以我们没必要使用System.out
        out.println("name="+harry.getName()+", salary="+harry.getSalary());
    }
}
