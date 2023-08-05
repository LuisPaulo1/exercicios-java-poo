package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LeitorArquivoCSV_03 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<String> lista = new ArrayList<>();
		
		Integer id = 1;
		Integer municipioId;
		String comarga;
		String nome;
		String sigla;
		String dataInicio;		
		Integer unidadeId = 1;		
		
		StringBuilder sb = new StringBuilder();
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\PJIJ-para-Fabrica-SW.csv";
		String caminhoMunicipio = "C:\\\\Users\\\\luisp\\\\Downloads\\\\municipio_resumido.txt";
		
		File sourceFile = new File(pathIn);		
		String sourceFolderStr = sourceFile.getParent();
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\PJIJ-para-Fabrica-SW.sql";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			while (line != null) {
				String[] sf = line.split(",");
				comarga = sf[1];				
				nome = sf[2];
				sigla = sf[3];
				dataInicio = sf[4];								
				
				String sql = "INSERT INTO MCAF_PROMOTORIAS (PMTR_DK, PMTR_NOME, PMTR_SIGLA, PMTR_MUNICIPIO_DK, PMTR_DT_INICIO, PMTR_UNMP_DK) VALUES (";
				sb.append(sql);			
				sb.append(id+", ");				
				sb.append("\'"+nome.trim()+"\', ");
				sb.append("\'"+sigla.trim()+"\', ");				
				municipioId = BuscarIdMunicipio(caminhoMunicipio, comarga);				
				sb.append(municipioId+", ");
				sb.append("TO_DATE(");
				sb.append("\'"+dataInicio+"\', 'DD/MM/YYYY'), ");				
				sb.append(unidadeId);				
				sb.append(");");
				sb.append("\n");
				line = br.readLine();
				id++;
			}
			
			lista.add(sb.toString());
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
				for (String p : lista) {
					bw.write(p);
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}		
	}
	
	public static int BuscarIdMunicipio(String caminhoMunicipio, String comarga) {
				
		int municipioId = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminhoMunicipio))) {
			String line = br.readLine();
			
			while (line != null) {
				
				String[] sf = line.split(",");	
				
				String nomeMunicipio = sf[2]; 
				
				if(nomeMunicipio.trim().equals(comarga.trim())) {
					municipioId = Integer.parseInt(sf[0]);
					break;
				}
				
				line = br.readLine();				
			}
			return municipioId;
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return 0;
		}
	}
	

}

