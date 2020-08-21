package net.sf.efhnbm;

import net.sf.efhnbm.utils.Utils;
import org.openide.cookies.EditCookie;
import org.openide.cookies.EditorCookie;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;

public final class SelectFromHere extends CookieAction {

    private static final String ICON_PATH = "/net/sf/efhnbm/resources/Icon16.gif"; // NOI18N
    private static final long serialVersionUID = 1791856667036029663L;

    private final EFHHelper helper;

    public SelectFromHere() {
        helper = new EFHHelper();
    }

    @Override
    protected void performAction(Node[] nodes) {
        helper.performAction(nodes, EFHHelper.ActionKind.SELECT);
    }

    @Override
    protected int mode() {
        return CookieAction.MODE_EXACTLY_ONE;
    }

    @Override
    @NbBundle.Messages({
        "# {0} - os name",
        "SelectFromHere.name=&Select in {0}",
    })
    public String getName() {
        return Bundle.SelectFromHere_name(Utils.OS_NAME);
    }

    @Override
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

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    @Override
    protected String iconResource() {
        return ICON_PATH;
    }

}
