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
 *
 * @author alessandro negrin
 * @version $Id$
 */
public class LinuxLauncher implements Launcher {

    private static final String NAUTILUS_PATH = "/usr/bin/nautilus"; // NOI18N
    private static final String KONQUEROR_PATH = "/usr/bin/konqueror"; // NOI18N

    private String commandPrefix;

    /**
     * default constructor
     */
    public LinuxLauncher() {

        File nautilus = new File(NAUTILUS_PATH);
        File konqueror = new File(KONQUEROR_PATH);

        if (nautilus.exists()) {
            commandPrefix = NAUTILUS_PATH + " --no-desktop ";
        } else if (konqueror.exists()) {
            commandPrefix = KONQUEROR_PATH + ' ';
        }

    }

    /**
     * launch the linux command to explore a directory
     *
     * @param path the path to explore
     * @throws Exception if something goes wrong in the runtime
     */
    @Override
    public void explore(String path) throws Exception {

        if (commandPrefix == null) {
            throw new RuntimeException("can't find a good command; no " + NAUTILUS_PATH + " and no " + KONQUEROR_PATH);
        }

        if (!path.startsWith(File.separator)) {
            path = File.separator + path;
        }

        Runtime r = Runtime.getRuntime();

        Process p = r.exec(commandPrefix + path);
        p.waitFor();
    }

    /**
     * launch the linux command to select a file (by now open the parent dir)
     *
     * @param path the path to explore
     * @throws Exception if something goes wrong in the runtime
     */
    @Override
    public void select(String path) throws Exception {

        if (!path.startsWith(File.separator)) {
            path = File.separator + path;
        }

        File file = new File(path);
        explore(file.getParentFile().getAbsolutePath());
    }
}
