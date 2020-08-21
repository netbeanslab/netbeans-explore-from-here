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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * spi option panel
 *
 * @author alessandro negrin
 * @version $Id$
 */
public class EFHOptionPanel extends JPanel {

    private static final long serialVersionUID = 9018890829648160858L;

    /**
     * Creates new form EFHOptionPanel
     */
    public EFHOptionPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionGroup = new ButtonGroup();
        commandChooser = new JFileChooser();
        bundleOption = new JRadioButton();
        classOption = new JRadioButton();
        commandOption = new JRadioButton();
        classTextField = new JTextField();
        commandsPanel = new JPanel();
        commandTextFieldExplore = new JTextField();
        browseCommandButtonSelect = new JButton();
        commandTextFieldSelect = new JTextField();
        browseCommandButtonExplore = new JButton();

        ResourceBundle bundle = ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n"); // NOI18N
        setBorder(BorderFactory.createTitledBorder(bundle.getString("option"))); // NOI18N

        bundleOption.setBackground(null);
        optionGroup.add(bundleOption);
        bundleOption.setText(bundle.getString("option.bundle")); // NOI18N
        bundleOption.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        bundleOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onSelectBundle(evt);
            }
        });

        classOption.setBackground(null);
        optionGroup.add(classOption);
        classOption.setText(bundle.getString("option.class")); // NOI18N
        classOption.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        classOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onSelectClass(evt);
            }
        });

        commandOption.setBackground(null);
        optionGroup.add(commandOption);
        commandOption.setText(bundle.getString("option.command")); // NOI18N
        commandOption.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        commandOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onSelectCommand(evt);
            }
        });

        commandsPanel.setBackground(null);

        browseCommandButtonSelect.setText(bundle.getString("browse_command")); // NOI18N
        browseCommandButtonSelect.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                onBrowseForCommandSelect(evt);
            }
        });

        browseCommandButtonExplore.setText(bundle.getString("browse_command")); // NOI18N
        browseCommandButtonExplore.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                onBrowseForCommandExplore(evt);
            }
        });

        GroupLayout commandsPanelLayout = new GroupLayout(commandsPanel);
        commandsPanel.setLayout(commandsPanelLayout);
        commandsPanelLayout.setHorizontalGroup(commandsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(commandsPanelLayout.createSequentialGroup()
                .addGroup(commandsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(commandTextFieldExplore, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(commandTextFieldSelect, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commandsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(browseCommandButtonExplore, GroupLayout.Alignment.TRAILING)
                    .addComponent(browseCommandButtonSelect, GroupLayout.Alignment.TRAILING)))
        );
        commandsPanelLayout.setVerticalGroup(commandsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(commandsPanelLayout.createSequentialGroup()
                .addGroup(commandsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(browseCommandButtonExplore)
                    .addComponent(commandTextFieldExplore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commandsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(browseCommandButtonSelect)
                    .addComponent(commandTextFieldSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bundleOption)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(classOption)
                            .addComponent(commandOption))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(commandsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bundleOption)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(classOption)
                    .addComponent(classTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(commandOption)
                    .addComponent(commandsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void onBrowseForCommandSelect(MouseEvent evt) {//GEN-FIRST:event_onBrowseForCommandSelect
        int result = commandChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            commandTextFieldSelect.setText(commandChooser.getSelectedFile().getAbsolutePath() + " {0}");
        }
    }//GEN-LAST:event_onBrowseForCommandSelect

    private void onBrowseForCommandExplore(MouseEvent evt) {//GEN-FIRST:event_onBrowseForCommandExplore
        int result = commandChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            commandTextFieldExplore.setText(commandChooser.getSelectedFile().getAbsolutePath() + " {0}");
        }
    }//GEN-LAST:event_onBrowseForCommandExplore

    private void onSelectCommand(ActionEvent evt) {//GEN-FIRST:event_onSelectCommand

        classTextField.setEnabled(false);

        commandTextFieldExplore.setEnabled(true);
        browseCommandButtonExplore.setEnabled(true);
        commandTextFieldSelect.setEnabled(true);
        browseCommandButtonSelect.setEnabled(true);

    }//GEN-LAST:event_onSelectCommand

    private void onSelectClass(ActionEvent evt) {//GEN-FIRST:event_onSelectClass

        classTextField.setEnabled(true);

        commandTextFieldExplore.setEnabled(false);
        browseCommandButtonExplore.setEnabled(false);
        commandTextFieldSelect.setEnabled(false);
        browseCommandButtonSelect.setEnabled(false);

    }//GEN-LAST:event_onSelectClass

    private void onSelectBundle(ActionEvent evt) {//GEN-FIRST:event_onSelectBundle

        classTextField.setEnabled(false);

        commandTextFieldExplore.setEnabled(false);
        browseCommandButtonExplore.setEnabled(false);
        commandTextFieldSelect.setEnabled(false);
        browseCommandButtonSelect.setEnabled(false);

    }//GEN-LAST:event_onSelectBundle

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton browseCommandButtonExplore;
    private JButton browseCommandButtonSelect;
    private JRadioButton bundleOption;
    private JRadioButton classOption;
    private JTextField classTextField;
    private JFileChooser commandChooser;
    private JRadioButton commandOption;
    private JTextField commandTextFieldExplore;
    private JTextField commandTextFieldSelect;
    private JPanel commandsPanel;
    private ButtonGroup optionGroup;
    // End of variables declaration//GEN-END:variables

    JRadioButton getBundleOption() {
        return bundleOption;
    }

    JRadioButton getClassOption() {
        return classOption;
    }

    JRadioButton getCommandOption() {
        return commandOption;
    }

    JTextField getClassTextField() {
        return classTextField;
    }

    JTextField getCommandTextFieldExplore() {
        return commandTextFieldExplore;
    }

    JButton getBrowseCommandButtonExplore() {
        return browseCommandButtonExplore;
    }

    JTextField getCommandTextFieldSelect() {
        return commandTextFieldSelect;
    }

    JButton getBrowseCommandButtonSelect() {
        return browseCommandButtonSelect;
    }

}
