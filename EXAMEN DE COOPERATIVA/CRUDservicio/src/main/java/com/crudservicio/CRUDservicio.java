
package com.crudservicio;

import CRUD.ServicioDAO;


public class CRUDservicio {

    public static void main(String[] args) {
        ServicioDAO servicioDAO = new ServicioDAO();

        // Agregar un nuevo servicio
//        servicioDAO.agregarServicio("2024-06-03", "recibido", "Problema de hardware", "Reemplazo de tarjeta madre",
//                                    2, 1, 3);
//
//        // Obtener todos los servicios
//        System.out.println("Lista de servicios:");
//        servicioDAO.obtenerServicios();
//
//        // Actualizar un servicio
//        servicioDAO.actualizarServicio(1, "2024-06-03", "finalizado", "Problema de hardware",
//                                        "Reemplazo de tarjeta madre", 2, 1, 3);
////
        // Eliminar un servicio
        servicioDAO.eliminarServicio(1);
    }
}

