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
interface Command {
    public void execute(Shell shell, String[] args);
}
