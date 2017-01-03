/*
//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Arley Laurindo de Oliveira
//******************************************************
Autor: Arley Laurindo de Oliveira
classe que vai ser instanciada, que representa as disciplinas para serem manipuladas pelo sistema
*/
public class Disciplina {
	
	
	private int id_discplina;
	
	private String nome;
	
	private String carga_horaria;

	private String curso;

	private int vagas;

	private String periodo;
	
	public int getId_discplina() {
		return id_discplina;
	}

	public void setId_discplina(int id_discplina) {
		this.id_discplina = id_discplina;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
