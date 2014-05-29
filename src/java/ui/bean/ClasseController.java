package ui.bean;

import entities.Classe;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "classeController")
@ViewScoped
public class ClasseController extends AbstractController<Classe> {

    @Inject
    private ProdutoController produtoCollectionController;
    @Inject
    private EmbalagemController embalagemCollectionController;
    @Inject
    private TipoCompatibilidadeController tipoCompatibilidadeCollectionController;

    public ClasseController() {
        // Inform the Abstract parent controller of the concrete Classe?cap_first Entity
        super(Classe.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Classe?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Produto page
     */
    public String navigateProdutoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Produto_items", this.getSelected().getProdutoCollection());
        }
        return "/entity/produto/index";
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from Classe?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Embalagem page
     */
    public String navigateEmbalagemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Embalagem_items", this.getSelected().getEmbalagemCollection());
        }
        return "/entity/embalagem/index";
    }

    /**
     * Sets the "items" attribute with a collection of TipoCompatibilidade
     * entities that are retrieved from Classe?cap_first and returns the
     * navigation outcome.
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
