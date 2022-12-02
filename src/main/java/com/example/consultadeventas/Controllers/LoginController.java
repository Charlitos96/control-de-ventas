package com.example.consultadeventas.Controllers;

import com.example.consultadeventas.Models.Usuario;
import com.example.consultadeventas.Models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String login(String user, String password) {
        String sql = "SELECT * FROM Usuarios " +
                "  WHERE user='"+user+"' AND password='"+password+"'";
        List<Usuario> usuarios = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));

        usuarios.forEach(System.out :: println);
        if(usuarios.isEmpty()){
            // Manejar el error
            //System.out.println("Usuario no valido.");
            return "error";
        }
        return "home";
    }

    @GetMapping("/consultar")
    public String consultar(String folio){
        String sql = "SELECT Ventas.folioVenta, Ventas.idProducto, Productos.nombre, Ventas.cantidad, Productos.precioUnitario" +
                "  FROM Ventas INNER JOIN Productos " +
                "  ON Ventas.idProducto = Productos.idProducto" +
                "  WHERE Ventas.folioVenta = "+folio;
        List<Venta> ventas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Venta.class));
        ConsultaController.Consulta(ventas);

        //ventas.forEach(System.out :: println);
        return "home";
    }
}
