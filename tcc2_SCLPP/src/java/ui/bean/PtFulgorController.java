package ui.bean;

import entities.PtFulgor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ptFulgorController")
@ViewScoped
public class PtFulgorController extends AbstractController<PtFulgor> {

    @Inject
    private TipoCompatibilidadeController tipoCompatibilidadeCollectionController;

    public PtFulgorController() {
        // Inform the Abstract parent controller of the concrete PtFulgor?cap_first Entity
        super(PtFulgor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of TipoCompatibilidade
     * entities that are retrieved from PtFulgor?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for TipoCompatibilidade page
     */
    public String navigateTipoCompatibilidadeCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoCompatibilidade_items", this.getSelected().getTipoCompatibilidadeCollection());
        }
        return "/entity/tipoCompatibilidade/index";
    }

}
