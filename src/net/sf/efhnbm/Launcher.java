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
package net.sf.efhnbm;

/**
 * launcher interface. implement this to make a new launcher an register it in
 * the launchers.properties
 *
 * @author alessandro negrin
 * @version $Id$
 */
public interface Launcher {

    /**
     * launch a runtime command for exploring a path
     *
     * @param path the path to work on
     * @throws Exception if something goes wrong in the runtime
     */
    public void explore(String path) throws Exception;

    /**
     * launch a runtime command for selecting a file
     *
     * @param path the path to work on
     * @throws Exception if something goes wrong in the runtime
     */
    public void select(String path) throws Exception;

}
