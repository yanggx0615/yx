package cn.yx.mapper;

import cn.yx.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    /**
     * 添加评论
     * @param comment 评论对象
     * @return 受影响行数
     */
    int add(@Param("comment") Comment comment);

    /**
     * 删除指定编号的评论
     * @param commentId 评论编号
     * @return 受影响的行数
     */
    int drop(@Param("commentId") String commentId);

    /**
     * 查找指定data编号的评论并根据时间排序
     * @param did data编号
     * @return 评论对象的集合
     */
    List<Comment> findByDid(@Param("did") String did);

    /**
     * 查找指定用户的评论并根据时间排序
     * @param username 用户名
     * @return 评论对象的集合
     */
    List<Comment> dindByUser(@Param("username") String username);
}
