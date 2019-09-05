package com.jcduhdt.dao;

import com.jcduhdt.domain.Items;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-09-05
 */
public interface ItemsDao {
    public List<Items> findAll() throws Exception;
}
