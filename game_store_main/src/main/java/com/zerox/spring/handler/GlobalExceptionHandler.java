package com.zerox.spring.handler;

import com.zerox.constant.ReturnCode;
import com.zerox.entity.view.RespDataVO;
import com.zerox.frame.controller.MainController;
import com.zerox.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 18:49
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

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
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        logger.debug("fieldErrors: {}", fieldErrors);
        if (!CollectionUtils.isEmpty(fieldErrors)) {
            // fieldErrors 是 unmodifiedList, 无法直接排序。直接排序会报 java.lang.UnsupportedOperationException
            // TODO: 为了测试专门排序一下，这样真的好吗？
            ArrayList<FieldError> sorted = new ArrayList<>(fieldErrors);
            sorted.sort(Comparator.comparing(FieldError::getField));
            for (FieldError fieldError : sorted) {
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
