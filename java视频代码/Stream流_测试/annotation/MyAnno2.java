package annotation;

import java.lang.annotation.*;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-30
 */

/*
元注解：用于描述注解的注解
    @Target:描述注解能够作用的位置
    @Retention：描述注解被保留的阶段
    @Documented:描述注解是否被抽取到Api文档中
    @Inherited：描述注解是否被子类继承
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)//自己定义的一般取这个值
@Documented
@Inherited
public @interface MyAnno2 {
}
