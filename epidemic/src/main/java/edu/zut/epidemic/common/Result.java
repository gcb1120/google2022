package edu.zut.epidemic.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private String code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static Result success() {
        return new Result(Constants.CODE_200, "", null,null);
    }

    public static <T> Result success(T data) {
        return new Result(Constants.CODE_200, "", data,null);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, null,null);
    }

    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null,null);
    }



//    public static <T> Result<T> success(T object) {
//        Result<T> r = new Result<T>();
//        r.data = object;
//        r.code = 1;
//        return r;
//    }
//
//    public static <T> Result<T> error(String msg) {
//        Result r = new Result();
//        r.msg = msg;
//        r.code = 0;
//        return r;
//    }
//
    public Result<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}

