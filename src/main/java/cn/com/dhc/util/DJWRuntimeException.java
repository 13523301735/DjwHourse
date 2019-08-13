package cn.com.dhc.util;

public class DJWRuntimeException extends RuntimeException {

    private CodeMsg cm;

    public DJWRuntimeException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

}
