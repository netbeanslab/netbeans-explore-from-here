package net.sf.efhnbm;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.openide.cookies.EditCookie;
import org.openide.cookies.EditorCookie;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.actions.CookieAction;

public final class SelectFromHere extends CookieAction {

    EFHHelper helper;
    String name;

    public SelectFromHere() {
        helper = new EFHHelper();
        setName();
    }

    protected void performAction(Node[] nodes) {
        helper.performAction(nodes, EFHHelper.SELECT);
    }

    protected int mode() {
        return CookieAction.MODE_EXACTLY_ONE;
    }

    /**
     * set the name of the action
     */
    protected void setName() {
        try {
            name = ResourceBundle.getBundle("net/sf/efhnbm/resources/i18n").getString("select_from_here") + helper.getOsName();
        } catch (MissingResourceException mre) {
            name = "&Select with OS";
        }
    }

    public String getName() {
        return name;
    }

    protected Class<?>[] cookieClasses() {
        return new Class<?>[]{
            EditorCookie.class,
            EditCookie.class,
            DataObject.class
        };
    }

    @Override
    protected void initialize() {
        super.initialize();
        // see org.openide.util.actions.SystemAction.iconResource() javadoc for more details
        putValue("noIconInMenu", Boolean.TRUE);
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    @Override
    protected String iconResource() {
        return "/net/sf/efhnbm/resources/Icon16.gif";
    }

}
