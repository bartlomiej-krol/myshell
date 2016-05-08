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
class DirCommand implements Command {

    public DirCommand() {
    }

    @Override
    public void execute(Shell shell, String[] params) throws NotEnoughParametersException {
        if(params.length < 1) {
            throw new NotEnoughParametersException("Usage:\ndir");
        } 
        
        String cwdPath = shell.getCurrentWorkingDirectory();
        File cwd = new File(cwdPath);
        File[] files = cwd.listFiles();
        
        System.out.println("Content of " + cwdPath);
        if(files != null && files.length > 0) {
            for (File file : files) {
                if (file == null) continue;
                if (file.isFile()) {
                    System.out.println("FILE\t" + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("DIR\t" + file.getName());
                }
            }
        }
    }
    
}
