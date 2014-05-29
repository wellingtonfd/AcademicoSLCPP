package ui.bean;

import entities.StatusArmazem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "statusArmazemController")
@ViewScoped
public class StatusArmazemController extends AbstractController<StatusArmazem> {

    @Inject
    private TipoCompatibilidadeController tipoCompatibilidadeidTipoCompatibilidadeController;
    @Inject
    private MovimentacaoController movimentacaoidMovimentacaoController;
    @Inject
    private ArmazemController armazemidArmazemController;

    public StatusArmazemController() {
        // Inform the Abstract parent controller of the concrete StatusArmazem?cap_first Entity
        super(StatusArmazem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoCompatibilidadeidTipoCompatibilidadeController.setSelected(null);
        movimentacaoidMovimentacaoController.setSelected(null);
        armazemidArmazemController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoCompatibilidade controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoCompatibilidadeidTipoCompatibilidade(ActionEvent event) {
        if (this.getSelected() != null && tipoCompatibilidadeidTipoCompatibilidadeController.getSelected() == null) {
            tipoCompatibilidadeidTipoCompatibilidadeController.setSelected(this.getSelected().getTipoCompatibilidadeidTipoCompatibilidade());
        }
    }

    /**
     * Sets the "selected" attribute of the Movimentacao controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMovimentacaoidMovimentacao(ActionEvent event) {
        if (this.getSelected() != null && movimentacaoidMovimentacaoController.getSelected() == null) {
            movimentacaoidMovimentacaoController.setSelected(this.getSelected().getMovimentacaoidMovimentacao());
        }
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
