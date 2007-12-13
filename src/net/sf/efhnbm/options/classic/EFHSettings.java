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
package net.sf.efhnbm.options.classic;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import net.sf.efhnbm.ExploreFromHere;
import net.sf.efhnbm.LaunchersFactory;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.NbPreferences;
import org.openide.util.SharedClassObject;

/**
 * module classic settings
 * @author alessandro negrin
 * @version $Id$
 */
public class EFHSettings extends SharedClassObject {

    static final long serialVersionUID=1234567890L;
    public static final String PROP_OPTION="option";
    public static final String PROP_OPTION_BUNDLE="bundle";
    public static final String PROP_OPTION_CLASS="class";
    public static final String PROP_OPTION_COMMAND="command";
    public static final String PROP_LAUNCHER_CLASS="launcher_class";
    public static final String PROP_COMMAND_EXPLORE="command";//keeping "command" for backward comp.
    public static final String PROP_COMMAND_SELECT="command_select";

    /** Creates a new instance of EFHSettings */
    public EFHSettings() {
    }

    /**
     *returns the display name
     *
     *@return the name to display
     *
     */
    public static String displayName() {
        try {
            return ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("explore_from_here_settings");
        } catch (MissingResourceException mre) {
            return "Explore from here settings";
        }
    }

    private void putPreference(String key, String value) throws BackingStoreException {
        Preferences prefs=NbPreferences.forModule(ExploreFromHere.class);
        if (prefs==null || key==null || value==null) {
            //do nothing
        } else {
            prefs.put(key, value);
            prefs.flush();//we have only 4 prefs, there's no reason to worry about performances :)
        }
    }

    private String getPreference(String key, String defaultValue) {
        Preferences prefs=NbPreferences.forModule(ExploreFromHere.class);
        if (prefs==null) {
            return defaultValue;
        } else {
            return prefs.get(key, defaultValue);
        }
    }

    /**
     * init props
     *
     */
    @Override
    protected void initialize() {
        super.initialize();

        putProperty(PROP_COMMAND_EXPLORE, getPreference(PROP_COMMAND_EXPLORE, "rundll32 url.dll,FileProtocolHandler {0}"), true);
        putProperty(PROP_LAUNCHER_CLASS, getPreference(PROP_LAUNCHER_CLASS, "net.sf.efhnbm.launchers.Win32Launcher"), true);
        putProperty(PROP_OPTION, getPreference(PROP_OPTION, PROP_OPTION_BUNDLE), true);

        putProperty(PROP_COMMAND_SELECT, getPreference(PROP_COMMAND_SELECT, "explorer /e,/select,{0}"), true);
    }

    /*
     * save the state
     * 
     */
    private void save() {
        try {
            putPreference(PROP_COMMAND_EXPLORE, getCommandExplore());
            putPreference(PROP_LAUNCHER_CLASS, getLauncherClass());
            putPreference(PROP_OPTION, getOption());
            putPreference(PROP_COMMAND_SELECT, getCommandSelect());
        } catch (BackingStoreException bse) {
            NotifyDescriptor desc=new NotifyDescriptor.Message("can't save", NotifyDescriptor.ERROR_MESSAGE);
            DialogDisplayer.getDefault().notify(desc);
        }
    }

    /**
     * serialize options
     *
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
    }

    /**
     * deserialize options
     *
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
    }

    /**
     * get help context for action
     * @return the help context (default)
     */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    public String getOption() {
        return (String) getProperty(PROP_OPTION);
    }

    public void setOption(String option) {
        putProperty(PROP_OPTION, option, true);
    }

    public String getLauncherClass() {
        return (String) getProperty(PROP_LAUNCHER_CLASS);
    }

    public void setLauncherClass(String launcherClass) {
        putProperty(PROP_LAUNCHER_CLASS, launcherClass, true);
    }

    public String getCommandExplore() {
        return (String) getProperty(PROP_COMMAND_EXPLORE);
    }

    public void setCommandExplore(String command) {
        putProperty(PROP_COMMAND_EXPLORE, command, true);
    }

    public String getCommandSelect() {
        return (String) getProperty(PROP_COMMAND_SELECT);
    }

    public void setCommandSelect(String command) {
        putProperty(PROP_COMMAND_SELECT, command, true);
    }

    /**
     * is a property has changed launchers factory must be reset
     *
     */
    @Override
    protected void firePropertyChange(String name, Object oldValue, Object newValue) {
        super.firePropertyChange(name, oldValue, newValue);
        save();
        LaunchersFactory.getInstance().reset();
    }

    /**
     * fake propertychange to fire save
     *
     */
    public void firePropertiesHaveBeenChanged() {
        firePropertyChange(PROP_OPTION, null, getOption());
    }
}
