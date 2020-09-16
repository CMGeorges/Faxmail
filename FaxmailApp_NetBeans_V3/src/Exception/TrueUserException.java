/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author camsl
 */
public class TrueUserException extends Exception {
    int code;

    public TrueUserException(String message) {
        super(message);
    }

    public TrueUserException() {
    }

    public TrueUserException(int code, String message) {
      
        super(message);
        this.code = code;
    }
    
    
}
