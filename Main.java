import java.util.Scanner;
public class Main {

	

	public static void main(String[] args) {
	APP admin=new APP();
	Scanner ler = new Scanner(System.in);
	String chaveBanco,chaveAgencia,chaveCliente,chaveConta,nomeB,nomeA,nomeGerente,nomeC,telA,telC,emailC,CPF,CNPJ,NF,numA,numB,numConta;
	int x;
	double limite,dinheiro;
	boolean ligado=true;
	
	while (ligado){
	System.out.println("Menu de Administrador:\n1-Criar Banco.\n2-Criar Agencia.\n3-Criar cliente-Pessoa fisica.\n4-Criar cliente-pessoa juridica.\n5-Criar conta corrente.\n6-Criar conta poupança.\n7-Buscar Banco.\n8-Buscar Agencia.\n9-Buscar Cliente.\n10-Listar Bancos.\n11-Listar Agencias de um Banco.\n12-Listar Clientes da Agencia de um Banco.\n13-Mudar limite Conta corrente.\n14-Depositar dinheiro.\n15-Extrair dinheiro.\n16-ver Saldo.\n20-Sair do Programa.\n");
	x=ler.nextInt();
	switch(x){
	/////////////////////////////////////////////////////////////////Criar Banco///////////////////////////////////////////////////////////////////////
	case 1:
	System.out.println("Digite o nome do Banco:\n");
	chaveBanco=ler.next();
	nomeB=chaveBanco;
	System.out.println("Digite o numero de Registro do Banco:\n");
	numB=ler.next();
	admin.criarBanco(chaveBanco, nomeB, numB);
	break;
	//////////////////////////////////////////////////////////////Criar Agencia////////////////////////////////////////////////////////////////////////
	case 2:
		System.out.println("Digite O nome do Banco onde se quer registra a agencia:\n");
		chaveBanco=ler.next();
		System.out.println("Digite o numero da Agencia:\n");
		numA=ler.next();
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		nomeA=chaveAgencia;
		nomeGerente=ler.next();
		telA=ler.next();
		
		if(admin.buscarB(chaveBanco)!=null)
		admin.criarAgencia(admin.buscarB(chaveBanco), chaveAgencia, numA, nomeA, telA, nomeGerente);
	break;
//////////////////////////////////////////////////////////////Criar Cliente Pessoa Fisica//////////////////////////////////////////////////////////////
	case 3:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		System.out.println("Digite o nome do Cliente:\n");
		chaveCliente=ler.next();
		nomeC=chaveCliente;
		System.out.println("Digite o E-mail:\n");
		emailC=ler.next();
		System.out.println("Digite o Telefone:\n");
		telC=ler.next();
		System.out.println("Digite o CPF:\n");
		CPF=ler.next();
		if(admin.buscarB(chaveBanco)!=null){if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
	admin.criarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia), chaveCliente, nomeC, telC, emailC,CPF);	
		}}	
		break;
	case 4:
		//////////////////////////////////////////////////////////Criar Cliente Pessoa Juridica///////////////////////////////////////////////////////////////
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		System.out.println("Digite o nome do Cliente:\n");
		chaveCliente=ler.next();
		nomeC=chaveCliente;
		System.out.println("Digite o E-mail:\n");
		emailC=ler.next();
		System.out.println("Digite o Telefone:\n");
		telC=ler.next();
		System.out.println("Digite o Nome de Fantasia:\n");
		NF=ler.next();
		System.out.println("Digite o CNPJ:\n");
		CNPJ=ler.next();
		
		if(admin.buscarB(chaveBanco)!=null){if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
	admin.criarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia), chaveCliente, nomeC, telC, emailC,NF,CNPJ);	
		}}	
		break;
	//////////////////////////////////////////////////////////Criar Conta Corrente/////////////////////////////////////////////////////////////////////	
	case 5:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		System.out.println("Digite o nome do Cliente:\n");
		chaveCliente=ler.next();
		System.out.println("Digite o numero da Conta:\n");
		chaveConta=ler.next();
		System.out.println("Digite o limite da Conta:\n");
		limite=ler.nextDouble();
		numConta=chaveConta;
		if(admin.buscarB(chaveBanco)!=null){
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		if(admin.buscarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente)!=null){
	admin.criarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), admin.buscarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente), chaveConta, numConta, limite);	
		}else if(admin.buscarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente)!=null){
	admin.criarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), admin.buscarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente), chaveConta, numConta, limite);	
		}}}
	break;
	//////////////////////////////////////////////////////////////Criar Conta Poupança////////////////////////////////////////////////////////////////
	case 6:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		System.out.println("Digite o nome do Cliente:\n");
		chaveCliente=ler.next();
		System.out.println("Digite o numero da Conta:\n");
		chaveConta=ler.next();
		numConta=chaveConta;
		if(admin.buscarB(chaveBanco)!=null){
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		if(admin.buscarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente)!=null){
	admin.criarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), admin.buscarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente), chaveConta, numConta);	
		}else if(admin.buscarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente)!=null){
	admin.criarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), admin.buscarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente), chaveConta, numConta);	
		}}}
	break;
	//////////////////////////////////////////////////////////////Buscar Bancos////////////////////////////////////////////////////////////////////////
	case 7:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null)System.out.println(admin.buscarB(chaveBanco).dadosB());
	break;
	//////////////////////////////////////////////////////////////Buscar Agencias//////////////////////////////////////////////////////////////////////
	case 8:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		chaveAgencia=ler.next();
		System.out.println(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia).dadosA());
		}}break;
	//////////////////////////////////////////////////////////////Buscar Cliente//////////////////////////////////////////////////////////////////////
	case 9:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		System.out.println("Digite o nome do Cliente:\n");
		chaveCliente=ler.next();
		if(admin.buscarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente)!=null){
		System.out.println(admin.buscarClienteF(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente).dadosC());}
		else if(admin.buscarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente)!=null){
			System.out.println(admin.buscarClienteJ(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveCliente).dadosC());}
		}}break;
		///////////////////////////////////////////////////////////Listar Bancos//////////////////////////////////////////////////////////////////////
	case 10:
		admin.listaBancos();
		break;
		///////////////////////////////////////////////////Listar Agencias de um Banco////////////////////////////////////////////////////////////////
	case 11:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){admin.buscarB(chaveBanco).listaAgencias();}
		break;
		//////////////////////////////////////////////////////Listar os Clientes de uma agencia///////////////////////////////////////////////////////
	case 12:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarB(chaveBanco)!=null){if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		admin.listaClientes(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia));}}
		break;
	///////////////////////////////////////////////////////Mudar Limite da Conta Corrente/////////////////////////////////////////////////////////////	
	case 13:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		System.out.println("Digite o numero da Conta:\n");
		chaveConta=ler.next();
		
		if(admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
			System.out.println("digite o novo limite da Conta");
			limite=ler.nextDouble();
		admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).setL(limite);}
			else 
				System.out.println("Não existe uma conta Corrente com esse numero");
		}}break;
	/////////////////////////////////////////////////////////////////Depositar dinheiro na conta/////////////////////////////////////////////////////
	case 14:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		System.out.println("Digite o numero da Conta:\n");
		chaveConta=ler.next();
		System.out.println("Digite a quantidade que deseja depositar.\n");
		dinheiro=ler.nextDouble();
		if(admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
		admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).deposito(dinheiro);}
		else if(admin.buscarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
			admin.buscarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).deposito(dinheiro);}
		}}break;
		
	////////////////////////////////////////////////////////Extrair dinheiro da conta////////////////////////////////////////////////////////////////	
	case 15:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		System.out.println("Digite o numero da Conta:\n");
		chaveConta=ler.next();
		System.out.println("Digite a quantidade que deseja retirar.\n");
		dinheiro=ler.nextDouble();
		if(admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
		admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).extração(dinheiro);}
		else if(admin.buscarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
			admin.buscarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).extração(dinheiro);}
		}}break;
	///////////////////////////////////////////////////Ver Saldo////////////////////////////////////////////////////////////////////////////////////	
	case 16:
		System.out.println("Digite o nome do Banco:\n");
		chaveBanco=ler.next();
		if(admin.buscarB(chaveBanco)!=null){
		System.out.println("Digite o nome da Agencia:\n");
		chaveAgencia=ler.next();
		if(admin.buscarA(admin.buscarB(chaveBanco), chaveAgencia)!=null){
		System.out.println("Digite o numero da Conta:\n");
		chaveConta=ler.next();
		System.out.println("Digite a quantidade que deseja retirar.\n");
		dinheiro=ler.nextDouble();
		if(admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
			System.out.println(admin.buscarContaC(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).verSaldo());}
		else if(admin.buscarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta)!=null){
			System.out.println(admin.buscarContaP(admin.buscarB(chaveBanco), admin.buscarA(admin.buscarB(chaveBanco),chaveAgencia), chaveConta).verSaldo());}
		}}break;
		//////////////////////////////////////////sair doPrograma////////////////////////////////////////////////////////////////////////////////////
	case 20:
		ligado=false;
	break;
	}
	}
	}

}
