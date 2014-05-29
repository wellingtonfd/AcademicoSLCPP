package ui.bean;

import entities.TipoCompatibilidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoCompatibilidadeController")
@ViewScoped
public class TipoCompatibilidadeController extends AbstractController<TipoCompatibilidade> {

    @Inject
    private StatusArmazemController statusArmazemCollectionController;
    @Inject
    private ToxidadeController toxidadeidToxidadeController;
    @Inject
    private TipoMovimentacaoController tipoMovimentacaoidTipoMovimentacaoController;
    @Inject
    private PtFulgorController ptFulgoridPtFulgorController;
    @Inject
    private PtEbulicaoController ptEbulicaoidPtEbulicaoController;
    @Inject
    private NumOnuController numOnuidNumOnuController;
    @Inject
    private ClasseController classeidClasseController;

    public TipoCompatibilidadeController() {
        // Inform the Abstract parent controller of the concrete TipoCompatibilidade?cap_first Entity
        super(TipoCompatibilidade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        toxidadeidToxidadeController.setSelected(null);
        tipoMovimentacaoidTipoMovimentacaoController.setSelected(null);
        ptFulgoridPtFulgorController.setSelected(null);
        ptEbulicaoidPtEbulicaoController.setSelected(null);
        numOnuidNumOnuController.setSelected(null);
        classeidClasseController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of StatusArmazem entities
     * that are retrieved from TipoCompatibilidade?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for StatusArmazem page
     */
    public String navigateStatusArmazemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("StatusArmazem_items", this.getSelected().getStatusArmazemCollection());
        }
        return "/entity/statusArmazem/index";
    }

    /**
     * Sets the "selected" attribute of the Toxidade controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareToxidadeidToxidade(ActionEvent event) {
        if (this.getSelected() != null && toxidadeidToxidadeController.getSelected() == null) {
            toxidadeidToxidadeController.setSelected(this.getSelected().getToxidadeidToxidade());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoMovimentacao controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoMovimentacaoidTipoMovimentacao(ActionEvent event) {
        if (this.getSelected() != null && tipoMovimentacaoidTipoMovimentacaoController.getSelected() == null) {
            tipoMovimentacaoidTipoMovimentacaoController.setSelected(this.getSelected().getTipoMovimentacaoidTipoMovimentacao());
        }
    }

    /**
     * Sets the "selected" attribute of the PtFulgor controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePtFulgoridPtFulgor(ActionEvent event) {
        if (this.getSelected() != null && ptFulgoridPtFulgorController.getSelected() == null) {
            ptFulgoridPtFulgorController.setSelected(this.getSelected().getPtFulgoridPtFulgor());
        }
    }

    /**
     * Sets the "selected" attribute of the PtEbulicao controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePtEbulicaoidPtEbulicao(ActionEvent event) {
        if (this.getSelected() != null && ptEbulicaoidPtEbulicaoController.getSelected() == null) {
            ptEbulicaoidPtEbulicaoController.setSelected(this.getSelected().getPtEbulicaoidPtEbulicao());
        }
    }

    /**
     * Sets the "selected" attribute of the NumOnu controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareNumOnuidNumOnu(ActionEvent event) {
        if (this.getSelected() != null && numOnuidNumOnuController.getSelected() == null) {
            numOnuidNumOnuController.setSelected(this.getSelected().getNumOnuidNumOnu());
        }
    }

    /**
     * Sets the "selected" attribute of the Classe controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareClasseidClasse(ActionEvent event) {
        if (this.getSelected() != null && classeidClasseController.getSelected() == null) {
            classeidClasseController.setSelected(this.getSelected().getClasseidClasse());
        }
    }
}
