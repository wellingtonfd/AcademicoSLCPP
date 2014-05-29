package ui.bean;

import entities.Armazem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "armazemController")
@ViewScoped
public class ArmazemController extends AbstractController<Armazem> {

    @Inject
    private EndArmazemController endArmazemCollectionController;
    @Inject
    private StatusArmazemController statusArmazemCollectionController;

    public ArmazemController() {
        // Inform the Abstract parent controller of the concrete Armazem?cap_first Entity
        super(Armazem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of EndArmazem entities that
     * are retrieved from Armazem?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for EndArmazem page
     */
    public String navigateEndArmazemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("EndArmazem_items", this.getSelected().getEndArmazemCollection());
        }
        return "/entity/endArmazem/index";
    }

    /**
     * Sets the "items" attribute with a collection of StatusArmazem entities
     * that are retrieved from Armazem?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for StatusArmazem page
     */
    public String navigateStatusArmazemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("StatusArmazem_items", this.getSelected().getStatusArmazemCollection());
        }
        return "/entity/statusArmazem/index";
    }

}
