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
package net.sf.efhnbm.options.spi;

import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import net.sf.efhnbm.options.classic.EFHSettings;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.SharedClassObject;

/**
 * spi option panel controller
 * @author alessandro negrin
 * @version $Id$
 */
public class EFHPanelController extends OptionsPanelController {
    
    private EFHOptionPanel panel;
    private EFHSettings settings;
    private boolean changed=false;
    
    /** Creates a new instance of EFHPanelController */
    public EFHPanelController() {
        super();
        panel=new EFHOptionPanel();
        settings=(EFHSettings)SharedClassObject.findObject(EFHSettings.class, true);
    }

    /**
     * load settings
     *
     */
    public void update() {
        if (EFHSettings.PROP_OPTION_BUNDLE.equals(settings.getOption())){
            panel.getBundleOption().setSelected(true);
            panel.getClassTextField().setEnabled(false);
            panel.getCommandTextField().setEnabled(false);
        } else if (EFHSettings.PROP_OPTION_CLASS.equals(settings.getOption())){
            panel.getClassOption().setSelected(true);
            panel.getClassTextField().setEnabled(true);
            panel.getCommandTextField().setEnabled(false);
        } else if (EFHSettings.PROP_OPTION_COMMAND.equals(settings.getOption())){
            panel.getCommandOption().setSelected(true);
            panel.getClassTextField().setEnabled(false);
            panel.getCommandTextField().setEnabled(true);
        }
        
        panel.getClassTextField().setText(settings.getLauncherClass());
        panel.getCommandTextField().setText(settings.getCommand());
        
        changed=false;
    }

    /**
     * save settings
     *
     */
    public void applyChanges() {
        if (panel.getBundleOption().isSelected()){
            settings.setOption(EFHSettings.PROP_OPTION_BUNDLE);
        } else if (panel.getClassOption().isSelected()){
            settings.setOption(EFHSettings.PROP_OPTION_CLASS);
        } else if (panel.getCommandOption().isSelected()){
            settings.setOption(EFHSettings.PROP_OPTION_COMMAND);
        }
        
        settings.setLauncherClass(panel.getClassTextField().getText());
        settings.setCommand(panel.getCommandTextField().getText());
        
        settings.firePropertiesHaveBeenChanged();
        
        changed=true;
        
    }

    /**
     * does nothing
     *
     */
    public void cancel() {
    }

    public boolean isValid() {
        return true;
    }

    public boolean isChanged() {
        return changed;
    }

    public JComponent getComponent(Lookup masterLookup) {
        return panel;
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
    }
    
}
