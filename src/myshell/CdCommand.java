/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

import java.io.File;

/**
 *
 * @author Branimir
 */
class CdCommand implements Command {

    public CdCommand() {
    }

    @Override
    public void execute(Shell shell, String[] params) throws NotEnoughParametersException {
        if(params.length < 2) {
            throw new NotEnoughParametersException("Usage:\ncd directory-name");
        } 
        
        String cwdPath = shell.getCurrentWorkingDirectory();
        File cwd = new File(cwdPath);
        
        switch(params[1]){
            case "..": 
                if(cwd.getParentFile() != null) {
                    shell.setCurrentWorkingDirectory(cwd.getParent());
                }
                break;
                
            default: 
                String newPath = cwdPath + "\\" + params[1];
                File file = new File(newPath);
                if(file.isDirectory()) {
                    shell.setCurrentWorkingDirectory(file.getAbsolutePath());
                }
                else {
                    System.out.println("Directory \"" + params[1] + "\" not found.");
                }
        } 
    }
    
}
