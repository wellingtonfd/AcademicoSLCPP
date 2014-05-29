package ui.bean;

import entities.Nivelusuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "nivelusuarioController")
@ViewScoped
public class NivelusuarioController extends AbstractController<Nivelusuario> {

    @Inject
    private UsuarioController usuarioCollectionController;

    public NivelusuarioController() {
        // Inform the Abstract parent controller of the concrete Nivelusuario?cap_first Entity
        super(Nivelusuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Nivelusuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", this.getSelected().getUsuarioCollection());
        }
        return "/entity/usuario/index";
    }

}
