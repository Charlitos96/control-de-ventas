package com.example.consultadeventas.Controllers;

import com.example.consultadeventas.Models.Venta;

import java.util.List;

public class ConsultaController {
    public static void Consulta(List<Venta> ventas){

        ventas.forEach(System.out :: println);
    }
}
