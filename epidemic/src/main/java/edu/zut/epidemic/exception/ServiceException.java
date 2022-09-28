package edu.zut.epidemic.exception;

import lombok.Getter;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/9/28
 * Time: 18:50
 **/
@Getter
public class ServiceException extends RuntimeException {

    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
