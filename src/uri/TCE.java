package uri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidato {

	private String nome;
	private String sexo;
	private Integer pontuacao;

	public Candidato(String nome, String sexo, Integer pontuacao) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

}

class TCE {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Candidato> listaCandidatos = new ArrayList<>();
		
		for (int i = 0; i < 500; i++) {
			
			System.out.print("Nome do candidato: ");
			String nome = sc.nextLine();			
			System.out.print("Sexo do candidato: ");
			String sexo = sc.nextLine();
			System.out.print("Pontuação do candidato: ");
			Integer pontuacao = sc.nextInt();
			listaCandidatos.add(new Candidato(nome, sexo, pontuacao));			
		}
		
		for(Candidato c : listaCandidatos) {
			if(c.getPontuacao() > 100) {
				System.out.println("Nome: "+c.getNome()+" - "+c.getPontuacao());
			}			
		}
		
		for(Candidato c : listaCandidatos) {
			double soma = 0;
			int totalMulheres = 0;
			if(c.getSexo().equals("Feminino")) {
				soma += c.getPontuacao();
				totalMulheres++;
			}
			double media = soma/totalMulheres;
			System.out.println("Média de pontuação das mulheres: "+media);
		}				
		sc.close();
	}

}
