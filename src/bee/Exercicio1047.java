package bee;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio1047 {
	
	public static void main(String[] args) {
		
		Locale.getDefault();
		Scanner sc = new Scanner(System.in);
		int horaInicial = sc.nextInt();
		int minutoInicial = sc.nextInt();		
		int horaFinal = sc.nextInt();
		int minutoFinal = sc.nextInt();		
		
		LocalTime tempoInicial = LocalTime.of(horaInicial, minutoInicial);		
		LocalTime tempoFinal = LocalTime.of(horaFinal, minutoFinal);				
		
		ZonedDateTime dataInicial = ZonedDateTime.of(LocalDate.now(), tempoInicial,  ZoneId.systemDefault());
		ZonedDateTime dataFinal = ZonedDateTime.of(LocalDate.now(), tempoFinal,  ZoneId.systemDefault());
		
		if(dataInicial.isEqual(dataFinal)) {
			System.out.println("O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)");
		} else {
			long minutosTotal = Duration.between(dataInicial, dataFinal).toMinutes();			
			int horasDeJogo = Duration.ofMinutes(minutosTotal).toHoursPart();
			int minutosDeJogo = Duration.ofMinutes(minutosTotal).toMinutesPart();			
			System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", horasDeJogo < 0 ? horasDeJogo * -1 : horasDeJogo, minutosDeJogo < 0 ? minutosDeJogo * -1 : minutosDeJogo);			
		}
		sc.close();
	}

}
