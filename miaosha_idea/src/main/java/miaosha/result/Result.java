package miaosha.result;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    /**
     * 成功时候的调用
     *
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    private Result(T data) {
//result构造函数设成私有的，因为并不期望用户可以通过构造函数生成result对象，而是用封装好的方法
        this.code=0;
        this.msg="success";
        this.data=data;
    }

    /**
     * 失败时候的调用
     *
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
    private Result(CodeMsg cm) {
        if(cm==null){
            return;
        }
        this.code=cm.getCode();
        this.msg=cm.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
