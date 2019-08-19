package cn.com.dhc.util;

public class DJWRuntimeException extends RuntimeException {

    private CodeMsg cm;

    public DJWRuntimeException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public DJWRuntimeException(int code,String msg) {
        this.cm = new CodeMsg(code,msg);
    }

    public CodeMsg getCm() {
        return cm;
    }

}
