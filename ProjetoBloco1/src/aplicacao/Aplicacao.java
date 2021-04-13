package aplicacao;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

	public static void main(String[] args) {
		
		DevJunior dev1 = new DevJunior();
		DevPleno dev2 = new DevPleno();
		
		dev1.cadastroFuncionario();
		dev2.cadastroFuncionario();
		List<Funcionarios> lista = new ArrayList<Funcionarios>();
		lista.add(dev1);
		lista.add(dev2);
		
		dev1.ImprimirInfo();
		dev1.avaliar();
	
		dev2.ImprimirInfo();
		dev2.avaliar();	

		for (Funcionarios dev : lista) {
			
			dev.ImprimirInfoBonificada();
		}
	}
}
