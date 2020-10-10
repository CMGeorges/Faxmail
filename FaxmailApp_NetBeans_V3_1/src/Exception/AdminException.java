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
public class AdminException extends Exception {
     int code;

    public AdminException(String message) {
        super(message);
    }

    public AdminException() {
    }

    public AdminException(int code, String message) {
      
        super(message);
        this.code = code;
    }
    
    
}
