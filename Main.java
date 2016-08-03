import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	

	public static void main(String[] args) {
	Banco admin=new Banco("Santanderd","1");
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
	System.out.println("Menu de Administrador:\n\n"+admin.hoje()+"\n1-.\n2-Criar Agencia.\n3-Criar cliente-Pessoa fisica.\n4-Criar cliente-pessoa juridica.\n5-Criar conta corrente.\n6-Criar conta poupança.\n7-Buscar Banco.\n8-Buscar Agencia.\n9-Buscar Cliente.\n10-Listar Bancos.\n11-Listar Agencias de um Banco.\n12-Listar Clientes da Agencia de um Banco.\n13-Mudar limite Conta corrente.\n14-Depositar dinheiro.\n15-Extrair dinheiro.\n16-ver Saldo.\n20-Sair do Programa.\n");
	try{
	x=ler.nextInt();
	continuar=false;
	}catch (InputMismatchException e) {
	System.err.println("Por gentileza,Inserir somente números inteiros!");
	ler.nextLine();
	}}	
	switch(x){
	
	//////////////////////////////////////////////////////////////Criar Agencia////////////////////////////////////////////////////////////////////////
	case 2:
		continuar=true;
		while(continuar){
		System.out.println("Digite o numero da Agencia:\n");
		try{
		numA=ler.nextInt();
		System.out.println("Digite o nome da Agencia:\n");
		nomeA=ler.next();
		System.out.println("Digite o telefone da Agencia:\n");
		telA=ler.next();
		System.out.println("Digite o endereço da Agencia:\n");
		endereço=ler.next();
		System.out.println("Digite o nome do gerente da Agencia:\n");
		nomeGerente=ler.next();
		
		admin.criarAgencia(numA, nomeA, telA,endereço, nomeGerente);
		continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
	break;
//////////////////////////////////////////////////////////////Criar Cliente Pessoa Fisica//////////////////////////////////////////////////////////////
	case 3:
		continuar=true;
		while(continuar){;
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o nome do Cliente:\n");
		nomeC=ler.next();
		System.out.println("Digite o E-mail:\n");
		emailC=ler.next();
		System.out.println("Digite o Telefone:\n");
		telC=ler.next();
		System.out.println("Digite o CPF:\n");
		CPF=ler.next();
		if(admin.buscarA(numA)!=null){
		admin.buscarA(numA).criarClienteF(nomeC, telC, emailC, CPF);
		}continuar=false;	
	}catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
	}}	
		break;
		case 4:
		//////////////////////////////////////////////////////////Criar Cliente Pessoa Juridica///////////////////////////////////////////////////////////////
			continuar=true;
			while(continuar){
			try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o nome do Cliente:\n");
		nomeC=ler.next();
		System.out.println("Digite o E-mail:\n");
		emailC=ler.next();
		System.out.println("Digite o Telefone:\n");
		telC=ler.next();
		System.out.println("Digite o Nome de Fantasia:\n");
		NF=ler.next();
		System.out.println("Digite o CNPJ:\n");
		CNPJ=ler.next();
		
		if(admin.buscarA(numA)!=null){
			admin.buscarA(numA).criarClienteJ(nomeC, telC, emailC,NF,CNPJ);	
		}	continuar=false;
			}catch (InputMismatchException e) {
				System.err.println("Por gentileza,Inserir somente números inteiros!");
				ler.nextLine();
			}}	
		break;
	//////////////////////////////////////////////////////////Criar Conta Corrente/////////////////////////////////////////////////////////////////////	
	case 5:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o nome do Cliente:\n");
		nomeC=ler.next();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite o limite da Conta:\n");
		limite=ler.nextDouble();
		if(admin.buscarA( numA)!=null){
		if(admin.buscarA(numA).buscarClienteJ( nomeC)!=null){
			admin.buscarA(numA).criarContaC(admin.buscarA(numA).buscarClienteJ( nomeC), numConta, limite);
		}else if(admin.buscarA(numA).buscarClienteF( nomeC)!=null){
			admin.buscarA(numA).criarContaC(admin.buscarA(numA).buscarClienteJ( nomeC), numConta, limite);
		}}continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
	break;
	//////////////////////////////////////////////////////////////Criar Conta Poupança////////////////////////////////////////////////////////////////
	case 6:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		System.out.println("Digite o nome do Cliente:\n");
		nomeC=ler.next();
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		if(admin.buscarA( numA)!=null){
			if(admin.buscarA(numA).buscarClienteJ( nomeC)!=null){
				admin.buscarA(numA).criarContaP(admin.buscarA(numA).buscarClienteJ( nomeC), numConta);
			}else if(admin.buscarA(numA).buscarClienteF( nomeC)!=null){
				admin.buscarA(numA).criarContaP(admin.buscarA(numA).buscarClienteJ( nomeC), numConta);
			}}continuar=false;
	}catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
	}}	
		break;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	case 7:
	break;
	//////////////////////////////////////////////////////////////Buscar Agencias//////////////////////////////////////////////////////////////////////
	case 8:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		System.out.println(admin.buscarA( numA).dadosA());
		}continuar=false;
	
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
		break;
	//////////////////////////////////////////////////////////////Buscar Cliente//////////////////////////////////////////////////////////////////////
	case 9:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		System.out.println("Digite o nome do Cliente:\n");
		nomeC=ler.next();
		if(admin.buscarA(numA).buscarClienteJ( nomeC)!=null){
		System.out.println(admin.buscarA(numA).buscarClienteJ( nomeC).dadosC());}
		else if(admin.buscarA(numA).buscarClienteF( nomeC)!=null){
			System.out.println(admin.buscarA(numA).buscarClienteF( nomeC).dadosC());}
		}continuar=false;

		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
		break;
		///////////////////////////////////////////////////////////Listar Bancos//////////////////////////////////////////////////////////////////////
	case 10:
		
		break;
		///////////////////////////////////////////////////Listar Agencias de um Banco////////////////////////////////////////////////////////////////
	case 11:
		admin.listaAgencias();
		break;
		//////////////////////////////////////////////////////Listar os Clientes de uma agencia///////////////////////////////////////////////////////
	case 12:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		admin.buscarA( numA).listaClientes();}
		continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}	
		break;
	///////////////////////////////////////////////////////Mudar Limite da Conta Corrente/////////////////////////////////////////////////////////////	
	case 13:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		if(admin.buscarA(numA).buscarContaC(numConta)!=null){
			System.out.println("digite o novo limite da Conta");
			limite=ler.nextDouble();
			admin.buscarA(numA).buscarContaC(numConta).setL(limite);}
			else 
		System.out.println("Não existe uma conta Corrente com esse numero");
		}continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
		break;
	/////////////////////////////////////////////////////////////////Depositar dinheiro na conta/////////////////////////////////////////////////////
	case 14:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite a quantidade que deseja depositar.\n");
		dinheiro=ler.nextDouble();
		if(admin.buscarA(numA).buscarContaC( numConta)!=null){
			admin.buscarA(numA).buscarContaC( numConta).deposito(dinheiro);}
		else if(admin.buscarA(numA).buscarContaP( numConta)!=null){
			admin.buscarA(numA).buscarContaP( numConta).deposito(dinheiro);}
		}continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}	
		break;
	////////////////////////////////////////////////////////Extrair dinheiro da conta////////////////////////////////////////////////////////////////	
	case 15:
		continuar=true;
		while(continuar){
		try{
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.nextInt();
		if(admin.buscarA( numA)!=null){
		System.out.println("Digite o numero da Conta:\n");
		numConta=ler.nextInt();
		System.out.println("Digite a quantidade que deseja retirar.\n");
		dinheiro=ler.nextDouble();
		if(admin.buscarA(numA).buscarContaC( numConta)!=null){
			admin.buscarA(numA).buscarContaC( numConta).extração(dinheiro);}
		else if(admin.buscarA(numA).buscarContaP( numConta)!=null){
			admin.buscarA(numA).buscarContaP( numConta).extração(dinheiro);}
		}continuar=false;
	}catch (InputMismatchException e) {
		System.err.println("Por gentileza,Inserir somente números inteiros!");
		ler.nextLine();
		}}
		break;
	///////////////////////////////////////////////////Ver Saldo////////////////////////////////////////////////////////////////////////////////////	
	case 16:
		continuar=true;
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
		}continuar=false;
		}catch (InputMismatchException e) {
			System.err.println("Por gentileza,Inserir somente números inteiros!");
			ler.nextLine();
		}}
		break;
		//////////////////////////////////////////sair doPrograma////////////////////////////////////////////////////////////////////////////////////
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
