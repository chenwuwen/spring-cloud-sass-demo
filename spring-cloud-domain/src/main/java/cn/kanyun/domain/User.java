package cn.kanyun.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Kanyun
 */
@Data
@TableName(value = "TENANT_USER")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "USER_NAME")
    private String userName;
    @TableField(value = "PASSWORD")
    private String password;
    @TableField(value = "REGISTER_DATE", fill = FieldFill.INSERT)
    private Long registerDate;
}
