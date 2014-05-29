package ui.bean;

import entities.Toxidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "toxidadeController")
@ViewScoped
public class ToxidadeController extends AbstractController<Toxidade> {

    @Inject
    private TipoCompatibilidadeController tipoCompatibilidadeCollectionController;

    public ToxidadeController() {
        // Inform the Abstract parent controller of the concrete Toxidade?cap_first Entity
        super(Toxidade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of TipoCompatibilidade
     * entities that are retrieved from Toxidade?cap_first and returns the
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
