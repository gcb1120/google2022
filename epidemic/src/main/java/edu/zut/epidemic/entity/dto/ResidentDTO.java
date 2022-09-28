package edu.zut.epidemic.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/9/28
 * Time: 18:41
 **/
@Data
public class ResidentDTO {

    private String name;
    private String password;
    private String phone;

    private LocalDateTime updateTime;
}
