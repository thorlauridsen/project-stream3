package listeners;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import controllers.CatalogController;
import models.BaseListener;
import views.CatalogView;
import views.MediaDetailsView;

import java.awt.event.ActionEvent;

public class BackListener extends BaseListener {

    public BackListener(MediaDetailsView mdv) {
        super(mdv);
    }

    public void actionPerformed(ActionEvent e) {
        view.setVisible(false);
        Catalog model = new Catalog();
        CatalogView view = new CatalogView();
        CatalogController mdc = new CatalogController(model, view);
        mdc.updateView();
    }
}