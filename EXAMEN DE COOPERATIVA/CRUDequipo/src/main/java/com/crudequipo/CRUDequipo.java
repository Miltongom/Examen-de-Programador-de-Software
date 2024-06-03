
package com.crudequipo;

import CRUD.EquipoDAO;

public class CRUDequipo {

    public static void main(String[] args) {
        
        EquipoDAO equipoDAO = new EquipoDAO();
        
//        // Crear equipo
//        equipoDAO.addEquipo("Laptop", "Dell XPS 13", 1);
        
//        // Leer equipo
//        equipoDAO.getEquipo(3);
//        
//        // Actualizar equipo
//        equipoDAO.updateEquipo(3, "Laptop", "Dell XPS 15", 1);
//        
        // Borrar equipo
        equipoDAO.deleteEquipo(3);
    }
}
