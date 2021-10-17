package uri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LeitorArquivoCSV_02 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<String> lista = new ArrayList<>();
		
		Integer id = 1;
		String nome = "";
		String comarga;
		Integer municipioId;
		Integer unidadeId = 1;		
		StringBuilder sb = new StringBuilder();
		
		String pathIn = "C:\\Users\\luisp\\Downloads\\vara-da-infancia.csv";
		String caminhoMunicipio = "C:\\\\Users\\\\luisp\\\\Downloads\\\\municipio_resumido.txt";
		
		File sourceFile = new File(pathIn);		
		String sourceFolderStr = sourceFile.getParent();
		new File(sourceFolderStr + "\\arquivo").mkdir();
		String pathOut = sourceFolderStr + "\\arquivo\\vara-da-infancia.sql";
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			while (line != null) {
				String[] sf = line.split(";");
				
				comarga = sf[0];
				nome = sf[1];
				
								
				String sql = "INSERT INTO MCAF_VARA_INFANCIA (VINF_DK, VINF_NOME, VINF_COMARCA, VINF_MNCP_DK, VINF_DT_INICIO, VINF_UNMP_DK) VALUES (";
				sb.append(sql);				
				sb.append(id+", ");				
				sb.append("\'"+nome.trim()+"\', ");				
				sb.append("\'"+comarga+"\', ");
				municipioId = BuscarIdMunicipio(caminhoMunicipio, comarga);
				sb.append(municipioId+", ");				
				sb.append("TO_CHAR(sysdate, 'DD MM YYYY'), ");				
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

