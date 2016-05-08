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
class ExitCommand implements Command {

    public ExitCommand() {
    }

    @Override
    public void execute(Shell shell, String[] params) throws NotEnoughParametersException {
        if(params.length < 1) {
            throw new NotEnoughParametersException("Usage:\nexit");
        } 
        
        shell.setWorking(false);
    }
    
}
