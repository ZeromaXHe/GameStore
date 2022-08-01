package com.zerox.spring.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        // TODO: 待完成
        return ResponseEntity.badRequest().body("参数校验失败");
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
        // TODO: 待完成
        return ResponseEntity.internalServerError().body("内部错误");
    }
}
