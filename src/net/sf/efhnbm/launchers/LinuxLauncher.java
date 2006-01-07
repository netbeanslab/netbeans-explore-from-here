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

import java.io.File;
import net.sf.efhnbm.Launcher;

/**
 * a generic linux launcher. nautilus or konqueror required
 * @author alessandro negrin
 * @version $Id$
 */
public class LinuxLauncher implements Launcher {
    
    private static final String nautilusPath="/usr/bin/nautilus";
    private static final String konquerorPath="/usr/bin/konqueror";
    
    private String commandPrefix;
    
    /**
     * default constructor
     */
    public LinuxLauncher() {
        
        File nautilus=new File(nautilusPath);
        File konqueror=new File(konquerorPath);
        
        if (nautilus.exists()){
            commandPrefix=nautilusPath+' ';
        } else if (konqueror.exists()){
            commandPrefix=konquerorPath+' ';
        }
        
    }
    
    /**
     * launch the linux command to explore a directory
     * @param path the path to explore
     * @throws Exception if something goes wrong in the runtime
     */
    public void explore(String path) throws Exception {
        
        if (commandPrefix==null) throw new RuntimeException("can't find a good command; no "+nautilusPath+" and no "+konquerorPath);
        
        if (!path.startsWith(File.separator)) path=File.separator+path;
        
        Runtime r= Runtime.getRuntime();
        Process p=null;

        p=r.exec(commandPrefix+path);
        p.waitFor();
    }
}
