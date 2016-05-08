/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

/**
 *
 * @author Branimir
 */
class NotEnoughParametersException extends Exception {
    private String msg;
    public NotEnoughParametersException(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String getMessage(){
        return this.msg;
    }
}
