/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.facede;

import entities.Fornecedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class FornecedorFacade extends AbstractFacade<Fornecedor> {
    @PersistenceContext(unitName = "tcc2_SCLPPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FornecedorFacade() {
        super(Fornecedor.class);
    }
    
}
