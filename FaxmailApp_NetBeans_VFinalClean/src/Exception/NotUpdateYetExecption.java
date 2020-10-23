/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *Execption d'un fonction pas encore up to date.
 * @author 2095086
 */
public class NotUpdateYetExecption extends Exception {
     int code;

    public NotUpdateYetExecption(String message) {
        super(message);
    }

    public NotUpdateYetExecption() {
    }

    public NotUpdateYetExecption(int code, String message) {
      
        super(message);
        this.code = code;
    }
    
}
