/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshell;

import java.util.Map;

/**
 *
 * @author Branimir
 */
interface Shell {

    public Map<String,Command> getCommands();
    
    public void printCommandLine();
    
    public void setCurrentPromptDefault();
    public void setCurrentPrompt(String prompt);
    public String getCurrentPrompt();

    public boolean isWorking();
    public void setWorking(Boolean b);
    
    public boolean isCwdPromptEnabled();
    public void setCwdPromptEnabled(Boolean b);
    
    public String getCurrentWorkingDirectory();
    public void setCurrentWorkingDirectory(String cwd);

}
