package bee;

import javax.swing.JOptionPane;

public class Atividade {

	public static void main(String[] args) {
		
		int n1, n2, quociente;
		double potencia;
		String msg = "";		
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro n�mero inteiro"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo n�mero inteiro"));
		
		quociente = (int) n1 / (int) n2;
		potencia = Math.pow(n1, n2);
		
		msg = msg + "Quociente da divis�o de " + n1 + " por "+ n2 + " = "+ quociente +"\n";
		msg = msg + "Pot�ncia de " + n1 + " por "+ n2 + " = "+ potencia +"\n";
		JOptionPane.showMessageDialog(null, msg);
		
	}

}
