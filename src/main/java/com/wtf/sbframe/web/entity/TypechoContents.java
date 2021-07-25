package com.wtf.sbframe.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* 
*
* @author WTF
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TypechoContents对象", description="")
public class TypechoContents implements Serializable {

private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private String title;

    private String slug;

    private Integer created;

    private Integer modified;

    private String text;

    private Integer order;

        @TableField("authorId")
    private Integer authorid;

    private String template;

    private String type;

    private String status;

    private String password;

        @TableField("commentsNum")
    private Integer commentsnum;

        @TableField("allowComment")
    private String allowcomment;

        @TableField("allowPing")
    private String allowping;

        @TableField("allowFeed")
    private String allowfeed;

    private Integer parent;

    private Integer views;

    private Integer agree;


}