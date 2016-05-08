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
class TreeCommand implements Command {

    public TreeCommand() {
    }

    @Override
    public void execute(Shell shell, String[] params) throws NotEnoughParametersException {
        if(params.length < 1) {
            throw new NotEnoughParametersException("Usage:\ntree");
        } 
        
        String cwdPath = shell.getCurrentWorkingDirectory();
        this.listDirectories(cwdPath, "");
    }
    
    private void listDirectories(String path, String namePrefix){
        File dir = new File(path);
        if(!dir.isDirectory()) return;
        
        File[] files = dir.listFiles();
        System.out.println(namePrefix + dir.getName());
        if(files != null && files.length > 0) {
            for (File file : files) {
                if (file == null) continue;
                this.listDirectories(file.getPath(), namePrefix + "-");
            }
        }
    }
    
}
