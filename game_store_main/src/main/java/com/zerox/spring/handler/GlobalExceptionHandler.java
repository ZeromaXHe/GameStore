package com.zerox.spring.handler;

import com.zerox.constant.ReturnCode;
import com.zerox.entity.view.RespDataVO;
import com.zerox.utils.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 18:49
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数校验异常处理
     *
     * @param request 请求
     * @param ex      异常对象
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handlerMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        StringBuilder msgBuilder = new StringBuilder();
        // 从 exception 中获取字段名称和对应错误信息，拼接成字符串
        if (!CollectionUtils.isEmpty(ex.getBindingResult().getFieldErrors())) {
            for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
                if (msgBuilder.length() > 0) msgBuilder.append("; ");
                msgBuilder.append(fieldError.getField()).append(" 错误: ").append(fieldError.getDefaultMessage());
            }
        }
        RespDataVO<String> resp = new RespDataVO<>(ReturnCode.VALIDATION_FAIL.getCode(), msgBuilder.toString());
        return ResponseEntity.badRequest().body(JsonUtils.objectToJson(resp));
    }

    /**
     * 未知异常处理
     *
     * @param request 请求
     * @param ex      异常对象
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<String> handlerException(HttpServletRequest request, Exception ex) {
        RespDataVO<String> resp = new RespDataVO<>(ReturnCode.INTERNAL_ERROR);
        return ResponseEntity.internalServerError().body(JsonUtils.objectToJson(resp));
    }
}
