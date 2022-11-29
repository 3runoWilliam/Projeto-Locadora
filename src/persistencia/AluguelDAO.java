package persistencia;

import dominio.Aluguel;

import java.util.*;
import java.sql.*;

public class AluguelDAO {
	
	private Conexao c;
	private String mostrar = "SELECT * FROM Cliente";
	private String alterar = "UPDATE Cliente SET name = ?, idade = ?, telefone = ?, endereco = ? WHERE id = ?";
	private String inserir = "INSERT INTO Cliente(name, idade, telefone, endereco) VALUES (?, ?, ?, ?)";
	private String deletar = "DELETE FROM Cliente WHERE id = ?";
	
}
