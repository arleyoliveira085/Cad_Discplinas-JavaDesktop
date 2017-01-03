
import java.sql.Connection;
import java.sql.DriverManager;
/*
//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//******************************************************
AUTOR: Arley Laurindo de Oliveira
classe responsável para criar conexao  com o banco de dados, com o metodo onde passa a url de acesso ao banco
levando em consideraco que utilizei o postgresql,configurando porta,banco de dados ,usuarioe senha.
*/
public class Conexao {

	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_disciplinas",
					"postgres","root");
			
			
			
			
			System.out.println("Conectado ao banco com sucesso : db_disciplina");
			
		} catch (Exception e) {
			System.out.println("Erro ao conectar ao banco "+e.getMessage());			
		}
		
		
		return con;
	}
}
