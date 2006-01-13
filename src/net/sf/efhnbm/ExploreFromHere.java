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

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.actions.NodeAction;


/**
 * module action
 * @author alessandro negrin
 * @version $Id$
 */
public class ExploreFromHere extends NodeAction {
    
    String osName=System.getProperty("os.name");
    String name=null;
    
    /**
     * Creates a new instance of ExploreFromHere
     */
    public ExploreFromHere() {
        setName();
        
    }

    private Launcher getLauncher() {
        return LaunchersFactory.getInstance().getLauncher();
    }
    
    /**
     * set the name of the action
     */
    protected void setName(){
        try{
            name=ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("explore_from_here")+osName;
        } catch (MissingResourceException mre){
            name="&Explore with OS";
        }
    }
    
    /**
     * get help context for action
     * @return the help context (default)
     */
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
    
    /**
     * get the name of the action
     * @return action's name
     */
    public java.lang.String getName() {
        return name;
    }
    
    /**
     * should enable this action?
     * @param node the current node
     * @return if action is enabled
     */
    protected boolean enable(org.openide.nodes.Node[] node) {
        
        if (node!=null && node.length==1){
            Node currentNode=node[0];
            DataObject dataObject=(DataObject)currentNode.getCookie(DataObject.class);
            if (dataObject!=null){
                FileObject fileObj=dataObject.getPrimaryFile();
                return fileObj.isValid() && !fileObj.isVirtual();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * explore the node
     * @param node the current node
     */
    protected void performAction(org.openide.nodes.Node[] node) {
        Node currentNode=node[0];
        DataObject dataObject=(DataObject)currentNode.getCookie(DataObject.class);
        try{
            Launcher launcher=getLauncher();
            if (launcher!=null){
                dataObject.getPrimaryFile().getPath();
                performOnPath(launcher, dataObject.getPrimaryFile().getPath());
            } else {
                NotifyDescriptor desc=new NotifyDescriptor.Message(java.util.ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("error_msg")+osName, NotifyDescriptor.ERROR_MESSAGE);
                DialogDisplayer.getDefault().notify(desc);
            }
        } catch (Exception e){
                NotifyDescriptor desc=new NotifyDescriptor.Message(java.util.ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("error_msg")+osName, NotifyDescriptor.ERROR_MESSAGE);
                DialogDisplayer.getDefault().notify(desc);
        }
    }
    
    /**
     * use the right launcher to explore the path
     * @param launcher the launcher to use
     * @param path the path to explore
     * @throws java.lang.Exception if something goes wrong in the runtime
     */
    protected void performOnPath(Launcher launcher, String path) throws Exception{
        launcher.explore(path);
    }
    
}
