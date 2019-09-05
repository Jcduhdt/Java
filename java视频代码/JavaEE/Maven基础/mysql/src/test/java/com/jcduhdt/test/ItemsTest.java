package com.jcduhdt.test;

import com.jcduhdt.dao.impl.ItemsDaoImpl;
import com.jcduhdt.domain.Items;
import org.junit.Test;

import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-05
 */
public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDaoImpl itemsDao = new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items items : list) {
            System.out.println(items.getId()+":"+items.getName());
        }
    }
}
