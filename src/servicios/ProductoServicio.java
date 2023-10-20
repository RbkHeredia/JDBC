/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Producto;
import java.util.Collection;
import persistencia.productoDAO;

/**
 *
 * @author rebek
 */
public class ProductoServicio {
    private productoDAO dao;

    public ProductoServicio() {
        this.dao = new productoDAO();
    }

    

    public void listarNombreProductos() throws Exception {
        try {
            Collection <Producto> productos = dao.listarNombreProductos();
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre());
            }
            } catch(Exception e){
            throw e;
        }
    }
    
    public void listarNombreYPrecioProductos() throws Exception {
        try {
            Collection <Producto> productos = dao.listarNombrePrecioProductos();
            for (Producto producto : productos) {
                System.out.println("- " + producto.getNombre() + " (" + producto.getPrecio() + ")");
            }
        } catch(Exception e){
            throw e;
        }
    }

    public void listarProductosEntrePrecios() throws Exception {
        try {
            Collection <Producto> productos = dao.listarProductosEntreValores(120, 202);
            for (Producto producto : productos) {
                System.out.println("- " +producto.getCodigo() + producto.getNombre() + " (" + producto.getPrecio() + ")");
            }
        } catch (Exception e) {
        }
    }
    
    public void listarProdPortatiles() throws Exception {
        try {
            Collection <Producto> productos = dao.listarPortatiles();
            for (Producto producto : productos) {
                System.out.println("- " +  producto.getNombre() + " (" + producto.getPrecio() + ")");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void mostrarProdMasBarato() throws Exception {
        try {
            Producto prod = dao.productoMasBarato();
            System.out.println(prod.getNombre() + " -  $" + prod.getPrecio());
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void nuevoProducto(String nombre, double precio, int codigoFab) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio<0 ) {
                throw new Exception("Debe indicar el precio");
            }

            if (codigoFab < 0) {
                throw new Exception("Debe indicar el codigo de fabricante");
            }
            
            Producto prod = new Producto();
            
            prod.setCodigoFabricante(codigoFab);
            prod.setNombre(nombre);
            prod.setPrecio(precio);
            dao.ingresarProducto(prod);
        } catch (Exception e) {
            throw e;
        }
    }
}
