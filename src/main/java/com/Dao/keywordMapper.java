package com.Dao;

import com.entity.KeywordEntity;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: Ezra Zephyr
 * @date:2023/12/223:01
 */
public interface keywordMapper {
    KeywordEntity selectById(int id);

    // 通过关键字查询
    KeywordEntity selectByKeyword(String keyword);

    // 查询所有记录
    List<KeywordEntity> selectAll();

    // 插入记录
    void insert(KeywordEntity keywordEntity);

    // 更新记录
    void update(KeywordEntity keywordEntity);

    // 删除记录
    void delete(int id);
}
