package com.service;

import com.Dao.keywordMapper;
import com.entity.KeywordEntity;
import com.util.MyBatisSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author: Ezra Zephyr
 * @date:2023/12/30:05
 */

public class KeywordService {

    public  KeywordEntity getKeywordById(int id) {
        try (SqlSession session = MyBatisSessionFactory.openSession()) {
            keywordMapper mapper = session.getMapper(keywordMapper.class);
            return mapper.selectById(id);
        }
    }

    public  List<KeywordEntity> getAllKeywords() {
        try (SqlSession session = MyBatisSessionFactory.openSession()) {
            keywordMapper mapper = session.getMapper(keywordMapper.class);
            return mapper.selectAll();
        }
    }

    public  KeywordEntity getKeywordByKeyword(String keyword) {
        try (SqlSession session = MyBatisSessionFactory.openSession()) {
            keywordMapper mapper = session.getMapper(keywordMapper.class);
            return mapper.selectByKeyword(keyword);
        }
    }

    public  void insertKeyword(KeywordEntity keywordEntity) {
        try (SqlSession session = MyBatisSessionFactory.openSession()) {
            keywordMapper mapper = session.getMapper(keywordMapper.class);
            mapper.insert(keywordEntity);
            session.commit();
        }
    }

    public  void updateKeyword(KeywordEntity keywordEntity) {
        try (SqlSession session = MyBatisSessionFactory.openSession()) {
            keywordMapper mapper = session.getMapper(keywordMapper.class);
            mapper.update(keywordEntity);
            session.commit();
        }
    }

    public static void deleteKeyword(int id) {
        try (SqlSession session = MyBatisSessionFactory.openSession()) {
            keywordMapper mapper = session.getMapper(keywordMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }
}
