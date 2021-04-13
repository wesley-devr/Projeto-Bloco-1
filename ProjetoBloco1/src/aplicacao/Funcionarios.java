package aplicacao;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public abstract class Funcionarios {
	private String nome;
	private String cargo;
	private String admissao;
	private double salario;
	private int pontuacao = 0;
	public String bonificacao;

	public Funcionarios(String cargo, double salario) {
		this.cargo = cargo;
		this.salario = salario;
	}

	public int avaliar() {
		String[] habilidades = { "\n1 - RESPONSABILIDADE PESSOAL", "\n2 - MENTALIDADE DE CRESCIMENTO", "\n3 - ORIENTAÇÃO AO FUTURO",
				"\n4 - PERSISTENCIA", "\n5 - COMUNICAÇÃO", "\n6 - TRABALHO EM EQUIPE", "\n7 - ATENÇÃO AOS DETALHES", "\n8 - PROATIVIDADE",
				"\n9 - PROFISSIONALISMO", "\n10 - PRECISÃO TÉCNICA" };
		int op;
		pontuacao = 0;
		int x;
		Scanner leia = new Scanner(System.in);
		
		System.out.println("--------------------------   AVALIAÇÃO - PROGRAMA INCENTIVE  ----------------------------");

		System.out.println("\nColaborador: " + getNome());
		System.out.println("Para a Habilidade listada, digite a opção desejada: ");

		for (x = 0; x < 10; x++) {
			System.out.println( habilidades[x]);
			System.out.println("(1) Iniciante (2) Em desenvolvimento (3) Proficiente (4) Avançado");
			op = leia.nextInt();

			if (op == 1) {
				pontuacao = pontuacao + 1;
			} else if (op == 2) {
				pontuacao = pontuacao + 2;
			} else if (op == 3) {
				pontuacao = pontuacao + 3;
			} else if (op == 4) {
				pontuacao = pontuacao + 4;
			} else {
				System.out.println("Opção inválida");
			}
			System.out.println("                                        ");
		}

		return pontuacao;
	}
	
	public void cadastroFuncionario(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n---------------------------- CADASTRO DE FUNCIONÁRIO -------------------------------");
		System.out.println("                                             ");
		System.out.println("Cargo: "+getCargo());
		System.out.print("Nome: ");
		setNome(scan.nextLine());
		System.out.print("Data de admissão: ");
		setAdmissao(scan.nextLine());
		
	}

	public void ImprimirInfo() {
		System.out.println("                                                                                       ");
		System.out.println("************************    DADOS DE FUNCIONÀRIO     **********************************");
		System.out
				.println("\nNome: " + getNome() + "\nCargo: " + getCargo() + "\nData de admissão: "
						+ getAdmissao() + "\nSalário: " + getSalario() + "\nPontuação total: " + pontuacao);
		System.out.println("                                                                                       ");
		
	}
	public void ImprimirInfoBonificada() {
		System.out.println("                                                                                       ");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*    BONIFICAÇÃO    -*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*\n");
		System.out.println("\nDados do funcionário \nNome: "+getNome()+"\nCargo: "+cargoBonificado()+"\nData de admissão: "+getAdmissao()+
				"\nSalário: "+salarioBonificado()+"\nPontuação total: "+pontuacao+"\nBonificação: "+bonificacao());
		System.out.println("                                                                                       ");
		System.out.println("                                                                                       ");
	}
	
	public String bonificacao() {
	
		if (pontuacao>=30 && pontuacao<=33 ) {
			bonificacao = "Parabens! "+getNome()+" ganhou: \n- REAJUSTE SALARIAL de 2% \n- Kit Home Office \n- Curso de Especialização";
		}		
		else if (pontuacao>=34 && pontuacao<=36 ) {
			bonificacao = "Parabens! "+getNome()+" ganhou:\n- REAJUSTE SALARIAL de 5%\n- Bonificação\n- Curso de Especialização";
			
		}
		else if (pontuacao>=37 && pontuacao<=39 ) {
			bonificacao = "Parabens! "+getNome()+" ganhou:\n- REAJUSTE SALARIAL de 7%\n- Jantar exclusivo\n- Viagem destino nacional";
				
		}
		else if (pontuacao==40 && getTempoTrabalhoMeses()>=6) {
			bonificacao = "Parabens! "+getNome()+" foi **PROMOVIDO** e ganhou:\n- REAJUSTE SALARIAL de 10%\n- Jantar exclusivo\n- **INTERCÂMBIO** corporativo";
		}
		else if (pontuacao==40) {
			bonificacao = "Parabens! "+getNome()+" ganhou:\n- REAJUSTE SALARIAL de 10%\n- Jantar exclusivo\n- **INTERCÂMBIO** corporativo";
		}
		else  {
			bonificacao = "Funcionário "+getNome()+" não atingiu a média de pontuação";		
		}
		return bonificacao;
	}
	public String salarioBonificado() {
		
		if (pontuacao>=30 && pontuacao<=33) {
			
			this.salario *= 1.02;
		}		
		else if (pontuacao>=34 && pontuacao<=36 ) {
			
			this.salario *= 1.05;	
		}
		else if (pontuacao>=37 && pontuacao<=39 ) {
			
			this.salario *= 1.05;
		}
		else if (pontuacao==40 && getTempoTrabalhoMeses()>=6) {
	
			this.salario *= 2;
		}
		else  {
			this.salario = salario;				
		}
		Locale localBrasil = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(localBrasil).format(this.salario);	
	}
	
	public String cargoBonificado() {

		if (pontuacao==40 && getTempoTrabalhoMeses()>=6) {
			
			if (cargo == "Desenvolvedor Java Jr") {
				setCargo("Desenvolvedor Pleno");
			}
			else if (cargo == "Desenvolvedor Pleno") {
				setCargo("Desenvolvedor Senior");
			}
			else if (cargo == "Desenvolvedor Senior") {
				setCargo("Especialista em Analista e Desenvolvimento de Sistemas");
			}
		}
		return cargo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAdmissao() {
		return this.admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}

	public String getSalario() {

		Locale localBrasil = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(localBrasil).format(this.salario);

	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public long getTempoTrabalhoMeses() {
		long mesesTempoTrabalho = 0;
		long diasTempoTrabalho = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

		try {
			Date date1 = myFormat.parse(admissao);
			Date date2 = myFormat.parse(dataAtual);
			long diff = date2.getTime() - date1.getTime();

			diasTempoTrabalho = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			mesesTempoTrabalho = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) / 30;
			// System.out.println("Dias de trabalho: "+diasTempoTrabalho);
			// System.out.println("Meses:"+mesesTempoTrabalho);
      
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return mesesTempoTrabalho;
	}

}
