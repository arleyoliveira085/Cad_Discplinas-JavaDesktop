import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
Classe responsável por metodos de operações no banco de dados
//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//******************************************************

*/

public class DisciplinaDAO {

	Connection con = Conexao.getConnection();

        //Metodo simples para testar os dados no banco,não retorna nada
	public void ListarDisciplina() {
		
		String sql = "Select * from tb_disciplina";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
								
				System.out.print("id_discplina : "+rs.getString("id_discplina") + "");
				System.out.print(" Nome:"+rs.getString("nome") + "\n");
				
					}
			 
			stm.close();
			 

		} catch (Exception e) {
			System.out.println("erro ao Listar : " + e.getMessage());
		}
		
	}
	
	//metodo o qual carrega os dados no banco, retornando um arraylist de objeto disciplina
	public ArrayList<Disciplina> CarregarDisciplinas() {
		
		String sql = "Select * from tb_disciplina";
		
		try {
			
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			
			ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
			
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				
				disciplina.setId_discplina(rs.getInt("id_discplina"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setCarga_horaria(rs.getString("carga_horaria"));
				disciplina.setCurso(rs.getString("curso"));
				disciplina.setVagas(rs.getInt("vagas"));
				disciplina.setPeriodo(rs.getString("periodo"));
				
				lista.add(disciplina);
				
								
				/*System.out.print("id_discplina : "+rs.getString("id_discplina") + "");
				System.out.print(" Nome:"+rs.getString("nome") + "\n");*/
				
					}
			 
			stm.close();
			 
			return lista;
		} catch (Exception e) {
			System.out.println("erro ao Listar : " + e.getMessage());
		}
		return null;
		
	}
	
	
	
	

	public void CadastraDisciplina(Disciplina disciplina) {

	String sql = "Insert into tb_disciplina(nome,carga_horaria,curso,vagas,periodo)"
				+ " values (?,?,?,?,?)";

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, disciplina.getNome());
			stm.setString(2, disciplina.getCarga_horaria());
			stm.setString(3, disciplina.getCurso());
			stm.setInt(4, disciplina.getVagas());
			stm.setString(5, disciplina.getPeriodo());

			stm.execute();
			stm.close();
			System.out.println("Disciplina cadastrada com sucesso");

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar Disciplina " + e.getMessage());

		}

	}
/*
        Esse método não foi usado mas server para atualizar o objeto com referencia no id selecionado.
        */
public void AlterarDisciplinaID(Disciplina disciplina,int id){
	String sql = "Update  tb_disciplina SET nome = ? where id_discplina = ?";
	try {
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1,disciplina.getNome()) ;
		//stm.setInt(2, );
		stm.setInt(2,id);
		
		stm.execute();
		stm.close();
		System.out.println("Alterado saporra com sucesso");
		
		
		
	} catch (Exception e) {
		System.out.println("erro ao alterar : "+e.getMessage());
	
	}
	
	
}
/*
Este metodo tem como funcao, receber um id de obejto na tabela e com base nesse argumento excluir os dados referente a objeto na tabela tb_disciplina
*/
public void removerDisciplina(int id_disciplina) {
	String sql = "Delete from tb_disciplina where id_discplina = ?";

	PreparedStatement stmt;
	try {
		stmt = con.prepareStatement(sql);
		stmt.setLong(1, id_disciplina);
		//executando 
		stmt.execute();
		//fechando
		stmt.close();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("erro ao apagar contado : " + e.getMessage());
	}
	
	
}


}
