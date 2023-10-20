/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author rebek
 */
public final class productoDAO extends DAO {
    public Collection<Producto> listarNombreProductos() throws Exception {
        try {
            String sql = "select nombre from producto";
            consultarBase(sql);
            Producto prod = null;
            Collection <Producto> productos = new ArrayList();
            while(resultado.next()){
                prod = new Producto();
                prod.setNombre(resultado.getString("nombre"));
                
                productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("No se encontraron los productos");
        }
    }
    
    
    public Collection<Producto> listarNombrePrecioProductos() throws Exception {
        try {
            String sql = "select nombre, precio from producto";
            consultarBase(sql);
            Producto prod = null;
            Collection <Producto> productos = new ArrayList();
            while(resultado.next()){
                prod = new Producto();
                prod.setNombre(resultado.getString("nombre"));
                prod.setPrecio(resultado.getDouble("precio"));
                productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("No hay productos");
        }
    }
    
    public Collection<Producto> listarProductosEntreValores(int min, int max) throws Exception {
        try {
            String sql = "select * from producto where precio > " + min + " and precio < " + max;
            consultarBase(sql);
            Producto prod = null;
            Collection <Producto> productos = new ArrayList();
            while(resultado.next()){
                prod = new Producto();
                prod.setNombre(resultado.getString("nombre"));
                prod.setPrecio(resultado.getDouble("precio"));
                prod.setCodigo(resultado.getInt("codigo"));
                prod.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
                productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("No hay productos");
        }
    }
    
    public Collection <Producto> listarPortatiles() throws Exception {
        try {
            String sql = "select * from producto where nombre like '%Portatil%'";
            consultarBase(sql);
            Producto prod = null;
            Collection <Producto> productos = new ArrayList();
            while(resultado.next()){
                prod = new Producto();
                prod.setNombre(resultado.getString("nombre"));
                prod.setPrecio(resultado.getDouble("precio"));
                prod.setCodigo(resultado.getInt("codigo"));
                prod.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
                productos.add(prod);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("No hay productos");
        }
    }
    
    public Producto productoMasBarato() throws Exception {
        try {
            String sql = "select nombre, precio from producto order by precio limit 1";
            consultarBase(sql);
            Producto prod = null;
            while(resultado.next()){
                prod = new Producto();
                prod.setNombre(resultado.getString("nombre"));
                prod.setPrecio(resultado.getDouble("precio"));
            }
            desconectarBase();
            return prod;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("No hay productos");
        }
        
        
    }
    public void ingresarProducto(Producto prod) throws Exception {
            try {
                if(prod == null){
                    throw new Exception("Debe ingresar un producto");
                }      
                String sql = "insert into producto (nombre, precio, codigo_fabricante) values (" + prod.getNombre() +", " + (int)(prod.getPrecio()) + ", " + prod.getCodigoFabricante() +")";
                System.out.println(sql);
                insertarModificarEliminar(sql);
            } catch (Exception e) {
                throw e;
            } finally {
                desconectarBase();
            }
        }
}
