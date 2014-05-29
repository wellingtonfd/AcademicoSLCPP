package ui.bean;

import entities.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private NivelusuarioController nivelusuarioidNivelusuarioController;
    @Inject
    private FuncionarioController funcionarioCollectionController;
    @Inject
    private TipoMovimentacaoController tipoMovimentacaoCollectionController;
    @Inject
    private TipoPedidoController tipoPedidoCollectionController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario?cap_first Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        nivelusuarioidNivelusuarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Nivelusuario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNivelusuarioidNivelusuario(ActionEvent event) {
        if (this.getSelected() != null && nivelusuarioidNivelusuarioController.getSelected() == null) {
            nivelusuarioidNivelusuarioController.setSelected(this.getSelected().getNivelusuarioidNivelusuario());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Funcionario entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcionario page
     */
    public String navigateFuncionarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcionario_items", this.getSelected().getFuncionarioCollection());
        }
        return "/entity/funcionario/index";
    }

    /**
     * Sets the "items" attribute with a collection of TipoMovimentacao entities
     * that are retrieved from Usuario?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoMovimentacao page
     */
    public String navigateTipoMovimentacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoMovimentacao_items", this.getSelected().getTipoMovimentacaoCollection());
        }
        return "/entity/tipoMovimentacao/index";
    }

    /**
     * Sets the "items" attribute with a collection of TipoPedido entities that
     * are retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for TipoPedido page
     */
    public String navigateTipoPedidoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoPedido_items", this.getSelected().getTipoPedidoCollection());
        }
        return "/entity/tipoPedido/index";
    }

}
