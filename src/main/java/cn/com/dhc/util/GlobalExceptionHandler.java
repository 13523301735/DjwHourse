package cn.com.dhc.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value=Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        //对于自定义异常的处理
        e.printStackTrace();
        if(e instanceof DJWRuntimeException) {
            DJWRuntimeException ex = (DJWRuntimeException)e;
            System.out.println("ex = " + ex.getCm().getMsg());
            return Result.error(ex.getCm());
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

}
