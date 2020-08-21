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
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.SharedClassObject;

/**
 * spi option panel controller
 *
 * @author alessandro negrin
 * @version $Id$
 */
public class EFHPanelController extends OptionsPanelController {

    private final EFHOptionPanel panel;
    private final EFHSettings settings;
    private boolean changed = false;

    /**
     * Creates a new instance of EFHPanelController
     */
    public EFHPanelController() {
        super();
        panel = new EFHOptionPanel();
        settings = SharedClassObject.findObject(EFHSettings.class, true);
    }

    /**
     * load settings
     *
     */
    @Override
    public void update() {
        if (EFHSettings.PROP_OPTION_BUNDLE.equals(settings.getOption())) {
            panel.getBundleOption().setSelected(true);
            panel.getClassTextField().setEnabled(false);

            panel.getCommandTextFieldExplore().setEnabled(false);
            panel.getBrowseCommandButtonExplore().setEnabled(false);
            panel.getCommandTextFieldSelect().setEnabled(false);
            panel.getBrowseCommandButtonSelect().setEnabled(false);

        } else if (EFHSettings.PROP_OPTION_CLASS.equals(settings.getOption())) {
            panel.getClassOption().setSelected(true);
            panel.getClassTextField().setEnabled(true);

            panel.getCommandTextFieldExplore().setEnabled(false);
            panel.getBrowseCommandButtonExplore().setEnabled(false);
            panel.getCommandTextFieldSelect().setEnabled(false);
            panel.getBrowseCommandButtonSelect().setEnabled(false);

        } else if (EFHSettings.PROP_OPTION_COMMAND.equals(settings.getOption())) {
            panel.getCommandOption().setSelected(true);
            panel.getClassTextField().setEnabled(false);

            panel.getCommandTextFieldExplore().setEnabled(true);
            panel.getBrowseCommandButtonExplore().setEnabled(true);
            panel.getCommandTextFieldSelect().setEnabled(true);
            panel.getBrowseCommandButtonSelect().setEnabled(true);

        }

        panel.getClassTextField().setText(settings.getLauncherClass());
        panel.getCommandTextFieldExplore().setText(settings.getCommandExplore());
        panel.getCommandTextFieldSelect().setText(settings.getCommandSelect());

        changed = false;
    }

    /**
     * save settings
     *
     */
    @Override
    public void applyChanges() {
        if (panel.getBundleOption().isSelected()) {
            settings.setOption(EFHSettings.PROP_OPTION_BUNDLE);
        } else if (panel.getClassOption().isSelected()) {
            settings.setOption(EFHSettings.PROP_OPTION_CLASS);
        } else if (panel.getCommandOption().isSelected()) {
            settings.setOption(EFHSettings.PROP_OPTION_COMMAND);
        }

        settings.setLauncherClass(panel.getClassTextField().getText());
        settings.setCommandExplore(panel.getCommandTextFieldExplore().getText());
        settings.setCommandSelect(panel.getCommandTextFieldSelect().getText());

        settings.firePropertiesHaveBeenChanged();

        changed = true;

    }

    /**
     * does nothing
     *
     */
    @Override
    public void cancel() {
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isChanged() {
        return changed;
    }

    @Override
    public JComponent getComponent(Lookup masterLookup) {
        return panel;
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener l) {
    }

}
