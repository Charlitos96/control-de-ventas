package com.example.consultadeventas.Controllers;

import com.example.consultadeventas.Models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String sayHello(@RequestParam(value = "user", defaultValue = "Usuario") String name) {
        String sql = "SELECT Ventas.folioVenta, Ventas.idProducto, Productos.nombre, Ventas.cantidad,  Productos.precioUnitario" +
                "  FROM Ventas INNER JOIN Productos " +
                "  ON Ventas.idProducto = Productos.idProducto" +
                "  WHERE Ventas.folioVenta = 20221120";
        List<Venta> ventas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Venta.class));

        ventas.forEach(System.out :: println);
        return String.format("Validando: %s, espere por favor...", name);
    }

    @GetMapping("/home")
    public String goHome(){
        return "home";
    }
}
