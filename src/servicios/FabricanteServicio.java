/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Fabricante;
import persistencia.fabricanteDAO;

/**
 *
 * @author rebek
 */
public class FabricanteServicio {
    private fabricanteDAO dao;
    
    public FabricanteServicio() {
        this.dao = new fabricanteDAO();
    }
    
    public void nuevoFabricante (String nombre) throws Exception {
        try {
            if(nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            Fabricante fab = new Fabricante();
            fab.setNombre(nombre);
            dao.ingresarFabricante(fab);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarFabricante (String nombre, int codigo) throws Exception {
        try {
            if(nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if(codigo < 0) {
                throw new Exception("Debe indicar el nombre");
            }
            dao.modificarFabricante(nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
