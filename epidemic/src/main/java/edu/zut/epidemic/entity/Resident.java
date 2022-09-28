package edu.zut.epidemic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author roydon
 * @since 2022-09-28
 */
@Getter
@Setter
@ToString
@TableName("sys_resident")
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 身份证
     */
    private String idNumber;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮件
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否租客：0：否，1：租客
     */
    private Integer tenant;

    /**
     * 头像
     */
    private String avatarUrl;


}
