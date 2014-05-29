package ui.bean;

import entities.TipoMovimentacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoMovimentacaoController")
@ViewScoped
public class TipoMovimentacaoController extends AbstractController<TipoMovimentacao> {

    @Inject
    private UsuarioController usuarioidUsuarioController;
    @Inject
    private TipoCompatibilidadeController tipoCompatibilidadeCollectionController;

    public TipoMovimentacaoController() {
        // Inform the Abstract parent controller of the concrete TipoMovimentacao?cap_first Entity
        super(TipoMovimentacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        usuarioidUsuarioController.setSelected(null);
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
     * Sets the "items" attribute with a collection of TipoCompatibilidade
     * entities that are retrieved from TipoMovimentacao?cap_first and returns
     * the navigation outcome.
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
