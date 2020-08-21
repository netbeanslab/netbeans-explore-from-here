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
package net.sf.efhnbm;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.efhnbm.launchers.CommandLauncher;
import net.sf.efhnbm.launchers.LinuxLauncher;
import net.sf.efhnbm.launchers.Win32Launcher;
import net.sf.efhnbm.options.spi.EFHSettings;
import net.sf.efhnbm.utils.Utils;
import org.openide.util.SharedClassObject;

/**
 * launchers factory.
 *
 * @author alessandro negrin
 * @version $Id$
 */
public class LaunchersFactory {

    enum LauncherType {
        LINUX,
        WINDOWS
    }

    private static final String WINDOWS_PATTERN_REGEX = "Windows\\ .*"; // NOI18N
    private static final String LINUX_PATTERN_REGEX = "Linux.*"; // NOI18N
    private static final Pattern WINDOWS_PATTERN = Pattern.compile(WINDOWS_PATTERN_REGEX);
    private static final Pattern LINUX_PATTERN = Pattern.compile(LINUX_PATTERN_REGEX);
    private static final Map<Pattern, LauncherType> OS_MAP = new HashMap<>();
    private static final LaunchersFactory INSTANCE = new LaunchersFactory();

    private Launcher launcher = null;

    static {
        OS_MAP.put(LINUX_PATTERN, LauncherType.LINUX);
        OS_MAP.put(WINDOWS_PATTERN, LauncherType.WINDOWS);
    }

    /* Creates a new instance of LaunchersFactory */
    private LaunchersFactory() {
    }

    /**
     * get factory singleton instance.
     *
     * @return a factory
     */
    public static LaunchersFactory getInstance() {
        return INSTANCE;
    }

    /**
     * reset the factory (config has been changed).
     *
     */
    public synchronized void reset() {
        launcher = null;
    }

    /**
     * get the launcher to start exploring.
     *
     * @return the launcher
     */
    public synchronized Launcher getLauncher() {
        if (launcher == null) {
            EFHSettings settings = SharedClassObject.findObject(EFHSettings.class, true);
            String todo = settings.getOption();
            try {
                if (EFHSettings.PROP_OPTION_BUNDLE.equals(todo)) {
                    for (Map.Entry<Pattern, LauncherType> entry : OS_MAP.entrySet()) {
                        Matcher matcher = entry.getKey().matcher(Utils.OS_NAME);
                        if (matcher.matches()) {
                            launcher = create(entry.getValue());
                            break;
                        }
                    }
                } else if (EFHSettings.PROP_OPTION_CLASS.equals(todo)) {
                    String className = settings.getLauncherClass();
                    launcher = (Launcher) Class.forName(className).newInstance();
                } else if (EFHSettings.PROP_OPTION_COMMAND.equals(todo)) {
                    launcher = new CommandLauncher(settings.getCommandExplore(), settings.getCommandSelect());
                }
            } catch (Exception e) {
                //don't care
            }
        }
        return launcher;
    }

    private static Launcher create(LauncherType type) {
        switch (type) {
            case LINUX:
                return new LinuxLauncher();
            case WINDOWS:
                return new Win32Launcher();
            default:
                throw new AssertionError();
        }
    }
}
