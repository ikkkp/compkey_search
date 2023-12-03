package com.entity;

/**
 * @Title:
 * @Description:
 * @author: Ezra Zephyr
 * @date:2023/12/222:57
 */
public class KeywordEntity {
    private int id;
    private String keyword;
    private String between;
    private String compete;
    private float correlation;


    public KeywordEntity() {
    }


    public KeywordEntity(int id, String keyword, String between, String compete, float correlation) {
        this.id = id;
        this.keyword = keyword;
        this.between = between;
        this.compete = compete;
        this.correlation = correlation;
    }

    public KeywordEntity(String keyword, String between, String compete, float correlation) {
        this.keyword = keyword;
        this.between = between;
        this.compete = compete;
        this.correlation = correlation;
    }



    @Override
    public String toString() {
        return "KeywordEntity{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", between='" + between + '\'' +
                ", compete='" + compete + '\'' +
                ", correlation='" + correlation + '\'' +
                '}';
    }
}
