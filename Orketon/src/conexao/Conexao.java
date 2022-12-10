/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

/**
 *
 * @author Ariane Sousa
 */
public class Conexao {
    
	public static Connection faz_conexao() throws SQLException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/orketon","root","39339533");
		} catch (ClassNotFoundException e) {	
			throw new SQLException(e.getException());
		}
	}
}
