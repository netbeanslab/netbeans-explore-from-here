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

import java.io.File;
import net.sf.efhnbm.utils.Utils;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.Lookup.Template;
import org.openide.util.NbBundle;

/**
 *
 * @author alessandro
 */
public class EFHHelper {

    public enum ActionKind {
        EXPLORE,
        SELECT,
    }

    /**
     * Creates a new instance of EFHHelper.
     */
    public EFHHelper() {
    }

    private Launcher getLauncher() {
        return LaunchersFactory.getInstance().getLauncher();
    }

    /**
     * perform actions: explore or select.
     */
    @NbBundle.Messages({
        "# {0} - os name",
        "EFHHelper.error.message=Can\'t find a good explorer/prompt for {0}",
    })
    @SuppressWarnings("unchecked")
    void performAction(Node[] node, ActionKind kind) {
        Node currentNode = node[0];
        FileObject fileObject = null;
        Project projects[] = currentNode.getLookup().lookup(new Template<>(Project.class)).allInstances().toArray(new Project[0]);
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
                if (kind == ActionKind.EXPLORE) {
                    launcher.explore(file.getAbsolutePath());
                } else if (kind == ActionKind.SELECT) {
                    launcher.select(file.getAbsolutePath());
                }
            } else {
                Utils.showErrorMessage(Bundle.EFHHelper_error_message(Utils.OS_NAME));
            }
        } catch (Exception e) {
            Utils.showErrorMessage(Bundle.EFHHelper_error_message(Utils.OS_NAME));
        }
    }
}
