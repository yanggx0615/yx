package cn.yx.mapper;

import cn.yx.bean.Click;
import org.apache.ibatis.annotations.Param;

public interface ClickMapper {
    /**
     * 新增点赞
     * @param click 点赞对象
     * @return 受影响行数
     */
    int add(@Param("click") Click click);

    /**
     * 删除点赞数据
     * @param Click_Id
     * @return
     */
    int drop(@Param("Click_Id") String Click_Id);
}
