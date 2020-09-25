package cn.yx.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * click
 * @author 杨国祥
 */
@Data
public class Click implements Serializable {
    /**
     * 点赞编号
     */
    private String clickId;

    /**
     * 数据编号
     */
    private String dId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 点赞日期
     */
    private Date clickDate;

    private static final long serialVersionUID = 1L;
}