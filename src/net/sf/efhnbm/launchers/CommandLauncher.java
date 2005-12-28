/**
 *                          Sun Public License Notice
 *
 * The contents of this file are subject to the Sun Public License Version
 * 1.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is available at http://www.sun.com/
 *
 * The Original Code is the "Explore from here" NetBeans Module.
 * The Initial Developer of the Original Code is alessandro negrin.
 * Portions created by alessandro negrin are Copyright (C) 2005.
 * All Rights Reserved.
 *
 * Contributor(s): alessandro negrin.
 *
 */
package net.sf.efhnbm.launchers;

import java.text.MessageFormat;
import net.sf.efhnbm.Launcher;

/**
 * a generic command launcher
 * @author alessandro negrin
 * @version $Id$
 */
public class CommandLauncher implements Launcher {

    private String command;
    
    
    /**
     * default constructor
     */
    public CommandLauncher(String command) {
        this.command=command;
    }
    
    /**
     * launch the windows command to explore a directory
     * @param path the path to explore
     * @throws Exception if something goes wrong in the runtime
     */
    public void explore(String path) throws Exception {
        
        Runtime r= Runtime.getRuntime();
        Process p=null;

        String realCommand=MessageFormat.format(command, new String[]{path});
        
        p=r.exec(realCommand);
        p.waitFor();
    }
}
