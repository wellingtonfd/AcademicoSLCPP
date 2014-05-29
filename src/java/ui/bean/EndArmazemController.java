package ui.bean;

import entities.EndArmazem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "endArmazemController")
@ViewScoped
public class EndArmazemController extends AbstractController<EndArmazem> {

    @Inject
    private ArmazemController armazemidArmazemController;

    public EndArmazemController() {
        // Inform the Abstract parent controller of the concrete EndArmazem?cap_first Entity
        super(EndArmazem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        armazemidArmazemController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Armazem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareArmazemidArmazem(ActionEvent event) {
        if (this.getSelected() != null && armazemidArmazemController.getSelected() == null) {
            armazemidArmazemController.setSelected(this.getSelected().getArmazemidArmazem());
        }
    }
}
