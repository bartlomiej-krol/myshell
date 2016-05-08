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
class PromptCommand implements Command {

    public PromptCommand() {
    }

    @Override
    public void execute(Shell shell, String[] params) throws NotEnoughParametersException {
        if(params.length < 2) {
            throw new NotEnoughParametersException("Usage:\nprompt $cwd\nprompt reset\nprompt new-prompt");
        } 
        
        switch(params[1]){
            case "$cwd": 
                shell.setCwdPromptEnabled(true);
                shell.setCurrentPrompt(shell.getCurrentWorkingDirectory());
                break;
            case "reset": 
                shell.setCwdPromptEnabled(false);
                shell.setCurrentPromptDefault();
                break;
            default: 
                shell.setCwdPromptEnabled(false);
                shell.setCurrentPrompt(params[1]);
        } 
    }
    
}
