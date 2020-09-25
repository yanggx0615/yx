package cn.yx.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comment
 * @author 杨国祥
 */
@Data
public class Comment implements Serializable {
    /**
     * 评论编号
     */
    private String commentId;

    /**
     * 数据编号
     */
    private String dId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 评论时间
     */
    private Date commentDate;

    /**
     * 评论类容
     */
    private String message;

    private static final long serialVersionUID = 1L;
}