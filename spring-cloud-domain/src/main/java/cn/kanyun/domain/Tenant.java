package cn.kanyun.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 租户信息表
 * @author KANYUN
 */
@Data
@ToString
@TableName(value = "TENANT")
public class Tenant implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "TENANT_NAME")
    private String tenantName;

    /**
     * 简拼 简称 【英文或拼音】
     */
    @TableField(value = "SIMPLICITY")
    private String simplicity;


    @TableField(value = "DOMAIN")
    private String domain;

    @TableField(value = "DB_URL")
    private String dbUrl;

    @TableField(value = "DB_USER")
    private String dbUser;

    @TableField(value = "DB_PASS")
    private String dbPass;

    @TableField(value = "REGISTER_DATE",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime registerDate;
}