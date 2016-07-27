
import java.util.HashMap;
import java.util.Set;

public class Banco {
     HashMap<String,Agencia> agencias = new HashMap<>();
     String nome,num;
     
    public Banco(String nome,String num){
   this.num=num;
   this.nome=nome;
    }
  
    public void criarAgencia(String numA,String nomeA,String telA,String nomeGerente){
     Agencia x=new Agencia(numA,nomeA,telA,nomeGerente);
     agencias.put(numA,x); 
     }
    public String dadosB(){
    	return "Nome:"+nome+".\nNumero de registro:"+num+".\n";
    }
    public String dadosA(String chaveAgencia){
    	if(agencias.get(chaveAgencia)!=null){
    		return agencias.get(chaveAgencia).dadosA();
    	}
    	return "A Agencia procurada não existe";
    	
    }
    
    public void criarClienteF(Agencia x,String chaveCliente,String nomeC,String telC,String emailC,String CPF){
    x.criarClienteF( chaveCliente, nomeC, telC, emailC,CPF);
    }
    
    public void criarClienteJ(Agencia x,String chaveCliente,String nomeC,String telC,String emailC,String NF,String CNPJ){
        x.criarClienteJ( chaveCliente, nomeC, telC, emailC,NF,CNPJ);
        }
    public void criarContaC(Agencia x,Cliente c,String chaveConta,String numConta, double limite){
    x.criarContaC( c, chaveConta, numConta, limite);
    }
    public void criarContaP(Agencia x,Cliente c,String chaveConta,String numConta){
        x.criarContaP( c, chaveConta, numConta);
        }
  
    
    public Agencia buscarA(String chaveAgencia){
    	return agencias.get(chaveAgencia);
}
    public PessoaJ buscarClienteJ(Agencia x,String chaveCliente){
    	return x.buscarClienteJ(chaveCliente);
    }
    public PessoaF buscarClienteF(Agencia x,String chaveCliente){
    	return x.buscarClienteF(chaveCliente);
    }
    public ContaPoupança buscarContaP(Agencia x,String chaveConta){
    	return x.buscarContaP(chaveConta);
    }
    public ContCorrente buscarContaC(Agencia x,String chaveConta){
    	return x.buscarContaC(chaveConta);
    }
    public void listaClientes(Agencia y){
    	y.listaClientes();
    }
    
    public void listaAgencias(){
    	System.out.println("As Agencias deste Banco são:\n");
        Set<String> chavesA = agencias.keySet();
        for(String chave: chavesA){
            System.out.println(agencias.get(chave).dadosA()+"\n");}
    }
}
