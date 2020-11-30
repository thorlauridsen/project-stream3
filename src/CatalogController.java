import models.BaseController;

public class CatalogController extends BaseController {

    public CatalogController() {
        super();
        Catalog c = new Catalog();
        CatalogView cv = new CatalogView(c);
        cv.updateGUI(null);
    }
}
