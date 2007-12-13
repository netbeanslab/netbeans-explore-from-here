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

import java.beans.PropertyEditorSupport;
import java.util.ResourceBundle;

/**
 * option property editor
 * @author alessandro negrin
 * @version $Id$
 */
@Deprecated
public class OptionPropertyEditor extends PropertyEditorSupport{
    
    private String[] tags;
    private String[] values;
    
    /** Creates a new instance of OptionPropertyEditor */
    public OptionPropertyEditor() {
        super();
        
        values=new String[]{EFHSettings.PROP_OPTION_BUNDLE, EFHSettings.PROP_OPTION_CLASS, EFHSettings.PROP_OPTION_COMMAND};
        tags=new String[3];
        
        for (int i = 0; i < tags.length; i++) {
            tags[i]=ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString(EFHSettings.PROP_OPTION+"."+values[i]);
        }

    }

    /**
     * get allowed values
     * @return the list of available values
     */
    @Override
    public String[] getTags(){
        return tags;
    }

    /**
     * map choice to real value
     * @param string choosen tag
     * @throws java.lang.IllegalArgumentException if something goes wrong
     */
    @Override
    public void setAsText(String string) throws IllegalArgumentException {
        boolean found=false;
        int i=0;
        while(!found && i<tags.length){
            found=tags[i].equals(string);
            i++;
        }
        
        if (found){
            setValue(values[i-1]);
        }
    }

    /**
     * map real value to choice
     * @return the choice that maps the current value
     */
    @Override
    public String getAsText() {
        String value=(String)getValue();
        boolean found=false;
        int i=0;
        while(!found && i<values.length){
            found=values[i].equals(value);
            i++;
        }
        
        if (found){
            return tags[i-1];
        } else {
            return null;
        }
    }
    
}
