/*
 *                          Sun Public License Notice
 *
 * The contents of this file are subject to the Sun Public License Version
 * 1.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is available at http://www.sun.com/
 *
 * The Original Code is the "Explore from here" NetBeans Module.
 * The Initial Developer of the Original Code is alessandro negrin.
 * Portions created by alessandro negrin are Copyright (C) 2020.
 * All Rights Reserved.
 *
 */
package net.sf.efhnbm.utils;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

public final class Utils {

    public static final String OS_NAME = System.getProperty("os.name"); // NOI18N

    private Utils() {
    }

    /**
     * Show the error message.
     *
     * @param message the error message
     */
    public static void showErrorMessage(String message) {
        NotifyDescriptor desc = new NotifyDescriptor.Message(message, NotifyDescriptor.ERROR_MESSAGE);
        DialogDisplayer.getDefault().notify(desc);
    }
}
