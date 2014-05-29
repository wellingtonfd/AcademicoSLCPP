package ui.bean;

import entities.TipoPedido;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoPedidoController")
@ViewScoped
public class TipoPedidoController extends AbstractController<TipoPedido> {

    @Inject
    private UsuarioController usuarioidUsuarioController;
    @Inject
    private DetalheNotaController detalheNotaidDetalheNotaController;

    public TipoPedidoController() {
        // Inform the Abstract parent controller of the concrete TipoPedido?cap_first Entity
        super(TipoPedido.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        usuarioidUsuarioController.setSelected(null);
        detalheNotaidDetalheNotaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuarioidUsuario(ActionEvent event) {
        if (this.getSelected() != null && usuarioidUsuarioController.getSelected() == null) {
            usuarioidUsuarioController.setSelected(this.getSelected().getUsuarioidUsuario());
        }
    }

    /**
     * Sets the "selected" attribute of the DetalheNota controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDetalheNotaidDetalheNota(ActionEvent event) {
        if (this.getSelected() != null && detalheNotaidDetalheNotaController.getSelected() == null) {
            detalheNotaidDetalheNotaController.setSelected(this.getSelected().getDetalheNotaidDetalheNota());
        }
    }
}
