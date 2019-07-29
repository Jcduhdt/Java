package supplier;

import java.util.function.Supplier;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-29
 */
/*
 * 练习：求数组元素最大值
 * 使用Supplier Lambda求出int数组最大值
 * 提示java.lang.Integer类
 */
public class SupplierTest {
    public static int getmax_vlaue(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {100,-50,880,99,33,-30};
        int max = getmax_vlaue(()->{
            int max_vlaue = arr[0];
            for (int i : arr) {
                if (i>max_vlaue)
                    max_vlaue = i;
            }
            return max_vlaue;
        });
        System.out.println("max = " + max);
    }
}
