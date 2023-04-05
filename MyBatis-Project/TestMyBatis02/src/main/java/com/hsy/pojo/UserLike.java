package com.hsy.pojo;

import java.util.List;

/**
 * @Auther: 李晓龙
 * @Date: 2023/3/21
 * @Description: com.hsy.pojo
 * @deprecated none
 * @version: 1.0
 */
public class UserLike {
    // 姓名模糊
    private String LikeName;
    // 地址模糊
    private String LikeAddr;
    // 多个id进行查询
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserLike() {
    }

    public UserLike(String likeName, String likeAddr) {
        LikeName = likeName;
        LikeAddr = likeAddr;
    }

    public String getLikeName() {
        return LikeName;
    }

    public void setLikeName(String likeName) {
        LikeName = likeName;
    }

    public String getLikeAddr() {
        return LikeAddr;
    }

    public void setLikeAddr(String likeAddr) {
        LikeAddr = likeAddr;
    }
}
