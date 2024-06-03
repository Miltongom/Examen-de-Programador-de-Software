
package com.crudtecnico;

import CRUD.TecnicoDAO;

public class CRUDtecnico {

    public static void main(String[] args) {
      TecnicoDAO tecnicoDAO = new TecnicoDAO();
//
//        // Agregar un nuevo técnico
//        tecnicoDAO.agregarTecnico("Juan", "Pérez", "Redes");

//        // Obtener todos los técnicos
//        System.out.println("Lista de técnicos:");
//        tecnicoDAO.obtenerTecnicos();

//        // Actualizar un técnico
//        tecnicoDAO.actualizarTecnico(1, "Juan", "Gómez", "Programación");

        // Eliminar un técnico
        tecnicoDAO.eliminarTecnico(1);
    
    }
}
