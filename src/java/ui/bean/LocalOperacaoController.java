package ui.bean;

import entities.LocalOperacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "localOperacaoController")
@ViewScoped
public class LocalOperacaoController extends AbstractController<LocalOperacao> {

    @Inject
    private MovimentacaoController movimentacaoCollectionController;

    public LocalOperacaoController() {
        // Inform the Abstract parent controller of the concrete LocalOperacao?cap_first Entity
        super(LocalOperacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from LocalOperacao?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Movimentacao page
     */
    public String navigateMovimentacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Movimentacao_items", this.getSelected().getMovimentacaoCollection());
        }
        return "/entity/movimentacao/index";
    }

}
