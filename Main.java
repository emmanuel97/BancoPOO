package Banco;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	

	public static void main(String[] args) throws ExValNeg{
	Banco admin=new Banco("Santanderd",1);
	Scanner ler = new Scanner(System.in);
	String nomeA,nomeGerente,endereço,nomeC,telA,telC,emailC,CPF,CNPJ,NF;
	int numA,numConta;
	int x=0;
	double limite,dinheiro;
	boolean ligado=true,continuar;
	admin.calcPoupança();
	while (ligado){
	continuar=true;
	while(continuar){
	System.out.println("Menu de Administrador:\n\n"+admin.hoje()+"\n1-Criar Agencia.\n2-Criar cliente-Pessoa fisica.\n3-Criar cliente-pessoa juridica.\n4-Criar conta corrente.\n5-Criar conta poupança.\n6-Buscar Agencia.\n7-Buscar Cliente.\n8-Listar Agencias de um Banco.\n9-Listar Clientes da Agencia de um Banco.\n10-Mudar limite Conta corrente.\n11-Depositar dinheiro.\n12-Extrair dinheiro.\n13-ver Saldo.\n14-transferir dineiro.\n15-apagar cliente.\n16-apagar conta.\n17-apagar agencia.\n0-Sair do Programa.\n");
	try{
	x=ler.nextInt();
	continuar=false;
	}catch (InputMismatchException e) {
	System.err.println("Por gentileza,Inserir somente números inteiros!");
	ler.nextLine();
	}}	
	switch(x){
	//////////////////////////////////////////////////////////////Criar Agencia////////////////////////////////////////////////////////////////////////
	case 1:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		ler.nextLine();
		System.out.println("Digite o nome da Agencia:\n");
		nomeA=ler.nextLine();
		System.out.println("Digite o telefone da Agencia:\n");
		telA=ler.nextLine();
		System.out.println("Digite o endereço da Agencia:\n");
		endereço=ler.nextLine();
		System.out.println("Digite o nome do gerente da Agencia:\n");
		nomeGerente=ler.nextLine();
		
		admin.criarAgencia(numA, nomeA, telA,endereço, nomeGerente);
		System.out.println("A Agencia foi criada.\n");
		continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
	break;
//////////////////////////////////////////////////////////////Criar Cliente Pessoa Fisica//////////////////////////////////////////////////////////////
	case 2:
		continuar=true;
		
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o nome do Cliente:\n");
		ler.nextLine();
		nomeC=ler.nextLine();
		System.out.println("Digite o E-mail:\n");
		emailC=ler.nextLine();
		System.out.println("Digite o Telefone:\n");
		telC=ler.nextLine();
		System.out.println("Digite o CPF:\n");
		CPF=ler.nextLine();
		admin.buscarA(numA).criarClienteF(nomeC, telC, emailC, CPF);
		System.out.println("O Cliente pessoa fisica foi criado");
		continuar=false;	
	}catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
	}}}catch (NullPointerException e) {
		System.err.println("A Agencia não existe.\n");
		ler.nextLine();
	}
		break;
		case 3:
		//////////////////////////////////////////////////////////Criar Cliente Pessoa Juridica///////////////////////////////////////////////////////////////
			continuar=true;
			
			try{
				while(continuar){
					try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		ler.nextLine();
		System.out.println("Digite o nome do Cliente:\n");
		nomeC=ler.nextLine();
		System.out.println("Digite o E-mail:\n");
		emailC=ler.nextLine();
		System.out.println("Digite o Telefone:\n");
		telC=ler.nextLine();
		System.out.println("Digite o Nome de Fantasia:\n");
		NF=ler.nextLine();
		System.out.println("Digite o CNPJ:\n");
		CNPJ=ler.nextLine();
		admin.buscarA(numA).criarClienteJ(nomeC, telC, emailC,NF,CNPJ);	
		System.out.println("O Cliente pessoa juridica foi criado");
			continuar=false;
			}catch (InputMismatchException e) {
				System.err.println("Por gentileza,Inserir somente números inteiros!");
				ler.nextLine();
			}}}catch (NullPointerException e) {
				System.err.println("A Agencia não existe.\n");
				ler.nextLine();
			}
		break;
	//////////////////////////////////////////////////////////Criar Conta Corrente/////////////////////////////////////////////////////////////////////	
	case 4:
continuar=true;
		
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		ler.nextLine();
		System.out.println("Digite o CPF ou CNPJ do Cliente:\n");
		nomeC=ler.nextLine();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite o limite da Conta:\n");
		limite=ler.nextDouble();
		if(limite<100)throw new ExValNeg();
		if(admin.buscarA(numA).buscarContaP( numConta)==null && admin.buscarA(numA).buscarContaC( numConta)==null){
		if(admin.buscarA(numA).buscarClienteJ( nomeC)!=null){
			admin.buscarA(numA).criarContaC(admin.buscarA(numA).buscarClienteJ( nomeC), numConta, limite);
			System.out.println("A Conta Corrente foi criada.\n");
		}else if(admin.buscarA(numA).buscarClienteF( nomeC)!=null){
			admin.buscarA(numA).criarContaC(admin.buscarA(numA).buscarClienteF( nomeC), numConta, limite);
			System.out.println("A Conta Corrente foi criada.\n");
		}else System.out.println("O Cliente não existe");
		continuar=false;
		}else System.out.println("ja exite uma conta com esse numero"); 
			}catch(ExValNeg e){
				System.err.println(e.getMessage());
			}
				catch (InputMismatchException e) {
		
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
			}}}catch (NullPointerException e) {
				System.err.println("A Agencia não existe.\n");
				ler.nextLine();
			}
	break;
	//////////////////////////////////////////////////////////////Criar Conta Poupança////////////////////////////////////////////////////////////////
	case 5:
continuar=true;
		
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		ler.nextLine();
		System.out.println("Digite o CPF ou CNPJ do Cliente:\n");
		nomeC=ler.nextLine();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		if(admin.buscarA(numA).buscarContaP( numConta)==null && admin.buscarA(numA).buscarContaC( numConta)==null){
			if(admin.buscarA(numA).buscarClienteJ( nomeC)!=null){
				admin.buscarA(numA).criarContaP(admin.buscarA(numA).buscarClienteJ( nomeC), numConta);
				System.out.println("A Conta Poupança foi criada.\n");
			}else if(admin.buscarA(numA).buscarClienteF( nomeC)!=null){
				admin.buscarA(numA).criarContaP(admin.buscarA(numA).buscarClienteJ( nomeC), numConta);
				System.out.println("A Conta Poupança foi criada.\n");
			}else System.out.println("O Cliente não existe");
			continuar=false;
		}else System.out.println("ja exite uma conta com esse numero"); 
		}catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
		}}}catch (NullPointerException e) {
			System.err.println("A Agencia não existe.\n");
			ler.nextLine();
		}
		break;

	//////////////////////////////////////////////////////////////Buscar Agencia//////////////////////////////////////////////////////////////////////
	case 6:
continuar=true;
		
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println(admin.buscarA( numA).dadosA());
		continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}}catch (NullPointerException e) {
			System.err.println("A Agencia procurada não existe.\n");
			ler.nextLine();
		}
		break;
	//////////////////////////////////////////////////////////////Buscar Cliente//////////////////////////////////////////////////////////////////////
	case 7:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		ler.nextLine();
		System.out.println("Digite o CPF ou CNPJ do Cliente:\n");
		nomeC=ler.nextLine();
		if(admin.buscarA(numA).buscarClienteJ( nomeC)!=null){
		System.out.println(admin.buscarA(numA).buscarClienteJ( nomeC).dadosC());}
		else if(admin.buscarA(numA).buscarClienteF( nomeC)!=null){
			System.out.println(admin.buscarA(numA).buscarClienteF( nomeC).dadosC());}
		continuar=false;

		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}}
		catch (NullPointerException e) {
			System.err.println("A Agencia procurada não existe.\n");
			ler.nextLine();
		}
		break;
		
		///////////////////////////////////////////////////Listar Agencias de um Banco////////////////////////////////////////////////////////////////
	case 8:
		admin.listaAgencias();
		break;
		//////////////////////////////////////////////////////Listar os Clientes de uma agencia///////////////////////////////////////////////////////
	case 9:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		admin.buscarA( numA).listaClientes();
		continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}}catch (NullPointerException e) {
			System.err.println("A Agencia não existe.\n");
			ler.nextLine();
		}	
		break;
	///////////////////////////////////////////////////////Mudar Limite da Conta Corrente/////////////////////////////////////////////////////////////	
	case 10:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		if(admin.buscarA(numA).buscarContaC(numConta)!=null){
			System.out.println("digite o novo limite da Conta");
			limite=ler.nextDouble();
			if(limite<100)throw new ExValNeg();
			admin.buscarA(numA).buscarContaC(numConta).setL(limite);
		System.out.println("O limite foi mudado\n");}
			else 
		System.out.println("Não existe uma conta Corrente com esse numero");
		continuar=false;
				}catch(ExValNeg e){
					System.err.println(e.getMessage());
				}
				catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}}catch (NullPointerException e) {
			System.err.println("A Agencia não existe.\n");
			ler.nextLine();
		}	
		break;
	/////////////////////////////////////////////////////////////////Depositar dinheiro na conta/////////////////////////////////////////////////////
	case 11:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite a quantidade que deseja depositar.\n");
		dinheiro=ler.nextDouble();
		if(dinheiro<=10)throw new ExValNeg();
		if(admin.buscarA(numA).buscarContaC( numConta)!=null){
			admin.buscarA(numA).buscarContaC( numConta).deposito(dinheiro);
			System.out.println("O deposito foi feito.\n");
			admin.buscarA(numA).buscarContaC( numConta).verSaldo();}
		else if(admin.buscarA(numA).buscarContaP( numConta)!=null){
			admin.buscarA(numA).buscarContaP( numConta).deposito(dinheiro);
			System.out.println("O deposito foi feito.\n");
			admin.buscarA(numA).buscarContaP( numConta).verSaldo();}
		else System.out.println("Não existe uma conta com esse numero");
		continuar=false;
				}catch(ExValNeg e){
					System.err.println(e.getMessage());
				}
				catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}}catch (NullPointerException e) {
			System.err.println("A Agencia não existe.\n");
			ler.nextLine();
		}	
		break;
	////////////////////////////////////////////////////////Extrair dinheiro da conta////////////////////////////////////////////////////////////////	
	case 12:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite a quantidade que deseja retirar.\n");
		dinheiro=ler.nextDouble();
		if(dinheiro<=10)throw new ExValNeg();
		if(admin.buscarA(numA).buscarContaC( numConta)!=null){
			admin.buscarA(numA).buscarContaC( numConta).extração(dinheiro);
			System.out.println("O retiro foi feito.\n");
			admin.buscarA(numA).buscarContaC( numConta).verSaldo();}
		else if(admin.buscarA(numA).buscarContaP( numConta)!=null){
			admin.buscarA(numA).buscarContaP( numConta).extração(dinheiro);
			System.out.println("O retiro foi feito.\n");
			admin.buscarA(numA).buscarContaP( numConta).verSaldo();}
		else System.out.println("Não existe uma conta com esse numero.\n");
		continuar=false;
		}catch(ExValNeg e){
			System.err.println(e.getMessage());
		}
		catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
	}}}catch (NullPointerException e) {
		System.err.println("A Agencia procurada não existe.\n");
		ler.nextLine();
	}	
		break;
	///////////////////////////////////////////////////Ver Saldo////////////////////////////////////////////////////////////////////////////////////	
	case 13:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		if(admin.buscarA(numA).buscarContaC( numConta)!=null){
			admin.buscarA(numA).buscarContaC( numConta).verSaldo();}
		else if(admin.buscarA(numA).buscarContaP( numConta)!=null){
			admin.buscarA(numA).buscarContaP( numConta).verSaldo();}
		else System.out.println("Não existe uma conta com esse numero");
		}continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}}catch (NullPointerException e) {
			System.err.println("A Agencia procurada não existe.\n");
			ler.nextLine();
		}	
		break;
		//////////////////////////////////////////fazer transferencia////////////////////////////////////////////////////////////////////////////////////
	case 14:
		continuar=true;
		try{
			while(continuar){
				try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite a quantidade que deseja retirar.\n");
		dinheiro=ler.nextDouble();
		System.out.println("Digite o numero da Agencia da conta áque deseja transferir:\n");
		int numA2=ler.nextInt();
		System.out.println("Digite o numero da Conta á que deseja transferir:\n");
		int numConta2=ler.nextInt();
		if(dinheiro<=10)throw new ExValNeg();
		if(admin.buscarA(numA).buscarContaC( numConta)!=null && admin.buscarA(numA2).buscarContaC( numConta2)!=null){
			admin.buscarA(numA).buscarContaC( numConta).extração(dinheiro);
			admin.buscarA(numA2).buscarContaC( numConta2).deposito(dinheiro);
			System.out.println("a transferencia foi feita.\n");
			admin.buscarA(numA).buscarContaC( numConta).verSaldo();}
		else if(admin.buscarA(numA).buscarContaP( numConta)!=null && admin.buscarA(numA2).buscarContaP( numConta2)!=null){
			admin.buscarA(numA).buscarContaP( numConta).extração(dinheiro);
			admin.buscarA(numA2).buscarContaP( numConta2).deposito(dinheiro);
			System.out.println("a transferencia foi feita.\n");
			admin.buscarA(numA).buscarContaP( numConta).verSaldo();}
		else System.out.println("Não existe uma conta com esse numero.\n");
		continuar=false;
		}catch(ExValNeg e){
			System.err.println(e.getMessage());
		}
		catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
	}}}catch (NullPointerException e) {
		System.err.println("A Agencia procurada não existe.\n");
		ler.nextLine();
	}	
		
		break;
		//////////////////////////////////////////apagar cliente////////////////////////////////////////////////////////////////////////////////////
	case 15:
	break;
		//////////////////////////////////////////apagar conta////////////////////////////////////////////////////////////////////////////////////
	case 16:
		break;
		//////////////////////////////////////////apagar agencia////////////////////////////////////////////////////////////////////////////////////
	case 17:
		break;
		//////////////////////////////////////////sair do Programa////////////////////////////////////////////////////////////////////////////////////
	case 0:
		ligado=false;
	break;
	case -1:
		admin.proxDia();
		admin.calcPoupança();
	break;
	case -2:
		admin.antDia();
		admin.calcPoupança();
	break;
	case -3:
		admin.proxMes();
		admin.calcPoupança();
	break;
	case -4:
		admin.antMes();
		admin.calcPoupança();
	break;
	}
	
	}
	}
}
