/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bartłomiej Król
 */
public class MyShell implements Shell {
    static final String APP_NAME = "MyShell";
    static final String DEFAULT_PROMPT = "$";
    private Boolean cwdPromptEnabled = false;
    private String currentPrompt;
    private Map<String,Command> commands;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Shell myshell = new MyShell();
        System.out.println("Hello World");
        myshell.getCommands().get("prompt").execute(myshell, args);
        System.out.println(myshell.getCurrentPrompt());
    }
    
    public MyShell(){
        init();
        loadCommands();
    }
    
    private void init() {
        setCurrentPrompt(DEFAULT_PROMPT);
    }
    
    private void loadCommands(){
        this.commands = new HashMap<>();
        this.commands.put("prompt", new PromptCommand());
    }
    
    @Override
    public Map<String,Command> getCommands(){
        return this.commands;
    }

    @Override
    public void setCurrentPrompt(String prompt) {
       this.currentPrompt = prompt;
    }

    @Override
    public String getCurrentPrompt() {
        return this.currentPrompt;
    }
    
    
}
