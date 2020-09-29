package cn.yx.bean;

import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * data
 * @author 杨国祥
 */
@Accessors(chain = true)
@lombok.Data

public class Data implements Serializable {
    /**
     * 数据编号
     */
    private String dataId;

    /**
     * 数据名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date dataDate;

    /**
     * 点击量
     */
    private Integer hits;

    /**
     * 收藏量
     */
    private Integer collection;

    /**
     * 数据类型
     */
    private String type;

    /**
     * 审核状态
     */
    private String status;

    /**
     * 作者
     */
    private String author;

    private static final long serialVersionUID = 1L;
}