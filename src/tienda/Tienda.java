/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.Scanner;
import servicios.FabricanteServicio;
import servicios.ProductoServicio;

/**
 *
 * @author rebek
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        ProductoServicio ps = new ProductoServicio();
        FabricanteServicio fs = new FabricanteServicio();
        int option;
        
        do {
            
            System.out.println("Ingresa una opcion");
            System.out.println("1. Listar el nombre de todos los productos");
            System.out.println("2. Listar el nombre y precio de todos los productos");
            System.out.println("3. Listar productos entre 120 y 202");
            System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto");
            System.out.println("5. Mostrar producto mas barato");
            System.out.println("6. Ingresar un producto a la base de datos");
            System.out.println("7. Ingresar un fabricante a la base de datos");
            System.out.println("8. Modificar un fabricante, ingresando nuevo nombre y codigo a modificar");
            System.out.println("0. Salir");
            option = read.nextInt();
            switch(option){
                case 1:
                    try {
                        ps.listarNombreProductos();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 2:
                    try {
                        ps.listarNombreYPrecioProductos();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 3:
                    try {
                        ps.listarProductosEntrePrecios();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 4:
                    try {
                        ps.listarProdPortatiles();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 5:
                    try {
                        ps.mostrarProdMasBarato();
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 6:
                    try {
                        ps.nuevoProducto("Asus x515", 600, 3);
                    } catch(Exception e) {
                        throw e;
                    }
                    break;
                case 7:
                    try {
                        fs.nuevoFabricante("Samsung");
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 8:
                    try {
                        fs.modificarFabricante("HP", 3);
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion inválida");
                    break;
            }
            
        } while(option != 0);
        System.out.println("Fin");
    }
    
}
