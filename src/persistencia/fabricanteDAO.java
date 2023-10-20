/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Fabricante;

/**
 *
 * @author rebek
 */
public final class fabricanteDAO extends DAO {
    public void ingresarFabricante(Fabricante fab) throws Exception {
        try {
            if(fab == null){
                throw new Exception("Debe ingresar un fabricante");
            }
            
            String sql = "insert into fabricante (nombre) values ('"  + fab.getNombre() + "')";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void modificarFabricante(String nombre, int codigo) throws Exception {
        try {
            if(nombre == null){
                throw new Exception("Debe ingresar un nombre");
            }
            
            String sql = "update fabricante set nombre = '"  + nombre + "' where codigo = " + codigo;
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
}
