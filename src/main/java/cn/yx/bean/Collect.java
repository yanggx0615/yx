package cn.yx.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * collect
 * @author 杨国祥
 */
@Data
public class Collect implements Serializable {
    /**
     * 收藏编号
     */
    private String collectId;

    /**
     * 数据编号
     */
    private String dId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 收藏日期
     */
    private Date collectDate;

    /**
     * 数据的实体对象
     */
    private cn.yx.bean.Data data;

    private static final long serialVersionUID = 1L;
}