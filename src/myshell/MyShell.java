/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bartłomiej Król
 */
public class MyShell implements Shell {
    static final String APP_NAME = "MyShell";
    static final String DEFAULT_PROMPT = "$";
    private Boolean cwdPromptEnabled;
    private Boolean working;
    private String currentPrompt;
    private Map<String,Command> commands;
    private String currentWorkingDirectory;
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Shell myshell = new MyShell();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] params;
        
        while(myshell.isWorking()){
            myshell.printCommandLine();
            line = br.readLine().trim();
            
            if(line.length() > 0) {
                params = line.split(" ");
                
                if(params.length > 0){
                    if(myshell.getCommands().containsKey(params[0])){
                        try {
                            myshell.getCommands().get(params[0]).execute(myshell, params);
                        } catch (NotEnoughParametersException ex) {
                            System.out.println("\n" + ex.getMessage());
                        }
                    }
                    else {
                        System.out.println("\n[" + params[0] + "]: unknown command.");
                    }
                }      
            }
        }
    }
    
    public MyShell(){
        init();
        loadCommands();
    }
    
    private void init() {
        setCurrentPromptDefault();
        this.working = true;
        this.cwdPromptEnabled = false;
        this.currentWorkingDirectory = System.getProperty("user.dir");
    }
    
    private void loadCommands(){
        this.commands = new HashMap<>();
        this.commands.put("cd", new CdCommand());
        this.commands.put("dir", new DirCommand());
        this.commands.put("exit", new ExitCommand());
        this.commands.put("prompt", new PromptCommand());
        this.commands.put("tree", new TreeCommand());
    }
    
    /*
        Shell methods implementation
    */    
    @Override
    public void printCommandLine() {
        System.out.print("\n[" + MyShell.APP_NAME + "] " + this.currentPrompt + ">");
    }
    
    @Override
    public Map<String,Command> getCommands(){
        return this.commands;
    }

    @Override
    public void setCurrentPromptDefault() {
        this.currentPrompt = MyShell.DEFAULT_PROMPT;
    }

    @Override
    public void setCurrentPrompt(String prompt) {
       this.currentPrompt = prompt;
    }

    @Override
    public String getCurrentPrompt() {
        return this.currentPrompt;
    }

    @Override
    public boolean isWorking() {
        return this.working;
    }

    @Override
    public void setWorking(Boolean b) {
        this.working = b;
    }

    @Override
    public String getCurrentWorkingDirectory() {
        return this.currentWorkingDirectory;
    }

    @Override
    public void setCurrentWorkingDirectory(String cwd) {
        this.currentWorkingDirectory = cwd;
        if(this.cwdPromptEnabled){
            this.setCurrentPrompt(this.currentWorkingDirectory);
        }
    }

    @Override
    public boolean isCwdPromptEnabled() {
        return this.cwdPromptEnabled;
    }

    @Override
    public void setCwdPromptEnabled(Boolean b) {
        this.cwdPromptEnabled = b;
    }
    
    
}
