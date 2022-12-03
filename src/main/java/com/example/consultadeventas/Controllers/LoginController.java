package com.example.consultadeventas.Controllers;

import com.example.consultadeventas.Models.Usuario;
import com.example.consultadeventas.Models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String login(Model model, String user, String password) {
        String sql = "SELECT * FROM Usuarios " +
                "  WHERE user='"+user+"' AND password='"+password+"'";
        List<Usuario> usuarios = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));
        usuarios.forEach(System.out :: println);

        if(usuarios.isEmpty()){
            return "error";
        }

        // Add an empty table
        List<Venta> ventas = new LinkedList<Venta>();
        for(int i=0; i<5; i++) ventas.add(new Venta());
        model.addAttribute("ventas",ventas);

        return "home";
    }

    @GetMapping("/consultar")
    public String consultar(Model model, String folio){
        String sql = "SELECT Ventas.folioVenta, Ventas.idProducto, Productos.nombre, Ventas.cantidad, Productos.precioUnitario" +
                "  FROM Ventas INNER JOIN Productos " +
                "  ON Ventas.idProducto = Productos.idProducto" +
                "  WHERE Ventas.folioVenta = "+folio;
        List<Venta> ventas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Venta.class));
        ventas.forEach(System.out :: println);

        int totalProductos = 0;
        float totalVentas = 0;
        for(Venta venta: ventas){
            totalProductos += venta.getCantidad();
            totalVentas += venta.getTotal();
        }

        model.addAttribute("folio",folio);
        model.addAttribute("ventas",ventas);
        model.addAttribute("totalProductos",totalProductos);
        model.addAttribute("totalVentas",totalVentas);
        return "home";
    }
}
