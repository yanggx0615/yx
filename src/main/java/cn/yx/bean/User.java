package cn.yx.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 杨国祥
 */
@Data
public class User implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 图片
     */
    private String portrait;

    /**
     * 解封时间
     */
    private Date unlock;

    private static final long serialVersionUID = 1L;
}