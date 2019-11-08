package cn.kanyun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Kanyun
 */
@Data
@TableName(value = "TENANT_BIZ")
public class Business implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "BIZ_NAME")
    private String bizName;
    @TableField(value = "BIZ_COMMENT")
    private String bizComment;
}
