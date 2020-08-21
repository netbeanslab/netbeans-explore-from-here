/*
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

import net.sf.efhnbm.Launcher;

/**
 * a win32 launcher
 *
 * @author alessandro negrin
 * @version $Id$
 */
public class Win32Launcher implements Launcher {

    /**
     * default constructor.
     */
    public Win32Launcher() {
    }

    /**
     * launch the windows command to explore a directory.
     *
     * @param path the path to explore
     * @throws Exception if something goes wrong in the runtime
     */
    @Override
    public void explore(String path) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(("rundll32 url.dll,FileProtocolHandler " + path).split(" ")); // NOI18N
        pb.start();
    }

    /**
     * launch the windows command to select a file.
     *
     * @param path the path to explore
     * @throws Exception if something goes wrong in the runtime
     */
    @Override
    public void select(String path) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(("explorer /e,/select," + path).split(" ")); // NOI18N
        pb.start();
    }
}
