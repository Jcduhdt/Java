package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-28
 */
public class User {
    private String name;
    private int age;
    private Date birthday;

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    /**
     * 逻辑视图
     * @return
     */
    public String getBirStr(){
        if (birthday != null){
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//还必须大写MM,格式固定？
            //2.返回字符串即可
            return sdf.format(birthday);
        }else{
            return "";
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                 ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
