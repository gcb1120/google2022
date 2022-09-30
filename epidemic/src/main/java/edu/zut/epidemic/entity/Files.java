package edu.zut.epidemic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/9/29
 * Time: 21:15
 **/
@Data
@TableName("sys_file")
public class Files {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String type;

    // 单位K
    private Long size;
    private String url;
    private String md5;
    // 是否被删除
    private Boolean isDelete;
    // 禁用？
    private Boolean enable;

}
