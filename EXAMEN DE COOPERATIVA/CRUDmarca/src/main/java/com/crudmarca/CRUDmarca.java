package com.crudmarca;

import CRUD.MarcaDAO;

public class CRUDmarca {

    public static void main(String[] args) {

        MarcaDAO marcaDAO = new MarcaDAO();

//        // Agregar una nueva marca
//        marcaDAO.agregarMarca("Samsung");

//        // Obtener todas las marcas
//        System.out.println("Lista de marcas:");
//        marcaDAO.obtenerMarcas();

//        // Actualizar una marca
//        marcaDAO.actualizarMarca(1, "Sony");
//
        // Eliminar una marca
        marcaDAO.eliminarMarca(1);
    }
}
