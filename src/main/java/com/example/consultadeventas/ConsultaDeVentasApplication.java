package com.example.consultadeventas;

import com.example.consultadeventas.Models.Usuario;
import com.example.consultadeventas.Models.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class ConsultaDeVentasApplication /*implements CommandLineRunner*/ {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConsultaDeVentasApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		/*
		String sql = "SELECT * FROM usuarios";
		List<Usuario> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Usuario.class));

		users.forEach(System.out :: println);
		//

		String sql = "SELECT Ventas.folioVenta, Ventas.idProducto, Productos.nombre, Ventas.cantidad,  Productos.precioUnitario" +
				"  FROM Ventas INNER JOIN Productos " +
				"  ON Ventas.idProducto = Productos.idProducto" +
				"  WHERE Ventas.folioVenta = 20221120";
		List<Venta> ventas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Venta.class));

		ventas.forEach(System.out :: println);

	}
	*/
}
