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

import java.io.File;
import org.netbeans.api.project.Project;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.Lookup.Template;

/**
 *
 * @author alessandro
 */
public class EFHHelper {

    private String osName = System.getProperty("os.name");
    private String name = null;

    static int EXPLORE = 0;
    static int SELECT = 1;

    /**
     * Creates a new instance of EFHHelper
     */
    public EFHHelper() {
    }

    private Launcher getLauncher() {
        return LaunchersFactory.getInstance().getLauncher();
    }

    public String getOsName() {
        return osName;
    }

    /*
     * perform actions: explore or select
     *
     */
    @SuppressWarnings("unchecked")
    void performAction(org.openide.nodes.Node[] node, int what) {
        Node currentNode = node[0];

        FileObject fileObject = null;

        Project projects[] = (Project[]) currentNode.getLookup().lookup(new Template(Project.class)).allInstances().toArray(new Project[0]);

        if (projects != null && projects.length == 1 && projects[0] != null) {
            fileObject = projects[0].getProjectDirectory();
        }

        if (fileObject == null) {
            DataObject dataObject = currentNode.getCookie(DataObject.class);
            if (dataObject != null) {
                fileObject = dataObject.getPrimaryFile();
            }
        }
        try {
            Launcher launcher = getLauncher();
            if (launcher != null && fileObject != null) {

                //building a file allow to get the absolute path with the correct separator (/ or \)
                File file = FileUtil.toFile(fileObject);

                if (what == EXPLORE) {
                    launcher.explore(file.getAbsolutePath());
                } else if (what == SELECT) {
                    launcher.select(file.getAbsolutePath());
                }

            } else {
                NotifyDescriptor desc = new NotifyDescriptor.Message(java.util.ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("error_msg") + getOsName(), NotifyDescriptor.ERROR_MESSAGE);
                DialogDisplayer.getDefault().notify(desc);
            }
        } catch (Exception e) {
            NotifyDescriptor desc = new NotifyDescriptor.Message(java.util.ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("error_msg") + getOsName(), NotifyDescriptor.ERROR_MESSAGE);
            DialogDisplayer.getDefault().notify(desc);
        }
    }

}
