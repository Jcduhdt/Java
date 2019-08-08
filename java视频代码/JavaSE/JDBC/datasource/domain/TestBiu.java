package domain;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-04
 */
public class TestBiu {
    private Integer id;
    private String name;
    private String password;
    private Double money;

    @Override
    public String toString() {
        return "TestBiu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
