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

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.util.ResourceBundle;
import org.openide.util.Utilities;

/**
 * module classic settings bean info
 * @author alessandro negrin
 * @version $Id$
 */
@Deprecated
public class EFHSettingsBeanInfo extends SimpleBeanInfo {

    private BeanDescriptor beanDescriptor;

    /** Creates a new instance of EFHSettingsBeanInfo */
    public EFHSettingsBeanInfo() {
        beanDescriptor=new BeanDescriptor(EFHSettings.class);
        beanDescriptor.setDisplayName(EFHSettings.displayName());
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {

            PropertyDescriptor option=
                    new PropertyDescriptor(EFHSettings.PROP_OPTION, EFHSettings.class);
            String name=ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString(EFHSettings.PROP_OPTION);
            option.setDisplayName(name);
            option.setShortDescription(name);
            option.setPropertyEditorClass(OptionPropertyEditor.class);

            PropertyDescriptor launcherClass=
                    new PropertyDescriptor(EFHSettings.PROP_LAUNCHER_CLASS, EFHSettings.class.getMethod("getLauncherClass"), EFHSettings.class.getMethod("setLauncherClass", String.class));
            name=ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString(EFHSettings.PROP_LAUNCHER_CLASS);
            launcherClass.setDisplayName(name);
            launcherClass.setShortDescription(name);

            PropertyDescriptor commandExplore=
                    new PropertyDescriptor(EFHSettings.PROP_COMMAND_EXPLORE, EFHSettings.class.getMethod("getCommandExplore"), EFHSettings.class.getMethod("setCommandExplore", String.class));
            name=ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString(EFHSettings.PROP_COMMAND_EXPLORE);
            commandExplore.setDisplayName(name);
            commandExplore.setShortDescription(name);

            PropertyDescriptor commandSelect=
                    new PropertyDescriptor(EFHSettings.PROP_COMMAND_SELECT, EFHSettings.class.getMethod("getCommandSelect"), EFHSettings.class.getMethod("setCommandSelect", String.class));
            name=ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString(EFHSettings.PROP_COMMAND_SELECT);
            commandSelect.setDisplayName(name);
            commandSelect.setShortDescription(name);

            return new PropertyDescriptor[]{option, launcherClass, commandExplore, commandSelect};
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Image getIcon(int type) {
        if (type==BeanInfo.ICON_COLOR_16x16||type==BeanInfo.ICON_MONO_16x16) {
            return Utilities.loadImage("/net/sf/efhnbm/resources/Icon16.gif");
        } else {
            return null;
        }
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDescriptor;
    }
}
