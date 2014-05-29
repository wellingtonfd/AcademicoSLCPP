package ui.bean;

import entities.Produto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "produtoController")
@ViewScoped
public class ProdutoController extends AbstractController<Produto> {

    @Inject
    private NumOnuController rumOnuidNumOnuController;
    @Inject
    private FornecedorController fornecedoridFornecedorController;
    @Inject
    private ComposprodutoController composprodutotipoprodutoController;
    @Inject
    private ClasseController classeidClasseController;

    public ProdutoController() {
        // Inform the Abstract parent controller of the concrete Produto?cap_first Entity
        super(Produto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        rumOnuidNumOnuController.setSelected(null);
        fornecedoridFornecedorController.setSelected(null);
        composprodutotipoprodutoController.setSelected(null);
        classeidClasseController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the NumOnu controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRumOnuidNumOnu(ActionEvent event) {
        if (this.getSelected() != null && rumOnuidNumOnuController.getSelected() == null) {
            rumOnuidNumOnuController.setSelected(this.getSelected().getRumOnuidNumOnu());
        }
    }

    /**
     * Sets the "selected" attribute of the Fornecedor controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFornecedoridFornecedor(ActionEvent event) {
        if (this.getSelected() != null && fornecedoridFornecedorController.getSelected() == null) {
            fornecedoridFornecedorController.setSelected(this.getSelected().getFornecedoridFornecedor());
        }
    }

    /**
     * Sets the "selected" attribute of the Composproduto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareComposprodutotipoproduto(ActionEvent event) {
        if (this.getSelected() != null && composprodutotipoprodutoController.getSelected() == null) {
            composprodutotipoprodutoController.setSelected(this.getSelected().getComposprodutotipoproduto());
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
