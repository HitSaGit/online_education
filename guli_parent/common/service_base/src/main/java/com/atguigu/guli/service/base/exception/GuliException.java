package com.atguigu.guli.service.base.exception;

import com.atguigu.guli.common.base.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author sa
 * @date 2020/10/22
 */
@Data
// 运行时异常，是非检查异常
public class GuliException extends RuntimeException {

    private Integer code;

    public GuliException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public GuliException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}

