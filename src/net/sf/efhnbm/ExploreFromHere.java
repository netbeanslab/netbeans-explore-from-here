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
 * Contributor(s): alessandro negrin, Yong Wind Li
 *
 */
package net.sf.efhnbm;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.actions.NodeAction;
import org.openide.util.Lookup.Template;

/**
 * module action
 *
 * @author alessandro negrin
 * @version $Id$
 */
public class ExploreFromHere extends NodeAction {

    EFHHelper helper;
    String name;

    /**
     * Creates a new instance of ExploreFromHere
     */
    public ExploreFromHere() {
        helper = new EFHHelper();
        setName();
    }

    /**
     * get help context for action
     *
     * @return the help context (default)
     */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    /**
     * get the name of the action
     *
     * @return action's name
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * set the name of the action
     */
    protected void setName() {
        try {
            name = ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("explore_from_here") + helper.getOsName();
        } catch (MissingResourceException mre) {
            name = "&Explore with OS";
        }
    }

    /**
     * should enable this action?
     *
     * @param node the current node
     * @return if action is enabled
     */
    @SuppressWarnings("unchecked")
    protected boolean enable(org.openide.nodes.Node[] node) {

        if (node != null && node.length == 1) {
            Node currentNode = node[0];

            Project projects[] = (Project[]) currentNode.getLookup().lookup(new Template(Project.class)).allInstances().toArray(new Project[0]);

            if (projects != null && projects.length == 1 && projects[0] != null) {
                return true;
            }

            DataObject dataObject = currentNode.getCookie(DataObject.class);
            if (dataObject != null) {
                FileObject fileObj = dataObject.getPrimaryFile();
                return fileObj.isValid() && !fileObj.isVirtual();
            }

        }
        return false;

    }

    /**
     * explore the node
     *
     * @param nodes the current node
     */
    protected void performAction(org.openide.nodes.Node[] nodes) {
        helper.performAction(nodes, EFHHelper.EXPLORE);
    }
}
