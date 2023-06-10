package cn.shoxiongdu.springbootwebstarter.handler;

import cn.shoxiongdu.springbootwebstarter.response.base.Resp;
import cn.shoxiongdu.springbootwebstarter.response.base.RespENUM;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Resp<String> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        String errorMessage = bindingResult.getFieldError().getDefaultMessage();
        return Resp.error(RespENUM.CLIENT_ERROR_PARAM.getCode(), errorMessage);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Resp<String> handleThrowable(Throwable t) {
        return Resp.error(t);
    }
}
