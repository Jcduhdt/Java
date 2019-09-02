package proxy;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-30
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"元买了一台联想电脑...");
        return "联想电脑";

    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
