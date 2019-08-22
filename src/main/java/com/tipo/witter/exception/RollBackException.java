package com.tipo.witter.exception;

/**事务回滚异常
 * @author Tipo
 * @version 1.0
 * @date 7/30/20194:10 PM
 */
public class RollBackException extends RuntimeException{

    private static final long serialVersionUID = -4749954311643887861L;

    public RollBackException(String message){
        super(message);
    }

    public RollBackException(Throwable e){
        super(e);
    }
}
