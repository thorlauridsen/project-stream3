public class CatalogController {

    public CatalogController() {
        Catalog c = new Catalog();
        CatalogView cv = new CatalogView(c);
        cv.updateGUI();
    }
}
