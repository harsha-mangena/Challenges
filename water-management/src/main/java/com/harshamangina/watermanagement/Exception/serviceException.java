package com.harshamangina.watermanagement.Exception;

public class serviceException extends Exception {
    
    /**
     * Exception without customized exception message.
     */
    public serviceException(){
        super();
    }

    /**
     * Exception with customized exception message.
     */
    public serviceException(String message){
        super(message);
    }
}
