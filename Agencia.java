
import java.util.HashMap;


public class Agencia {
    HashMap<String,Cliente> clientes = new HashMap<>();
     HashMap<String,Conta> contas = new HashMap<>();
     String numero,nome,endereço,nomegerente;
    public Agencia(String numero,String nome,String endereço,String nomegerente){
    	this.nome=nome;
    	this.numero=numero;
    	this.endereço=endereço;
    }
    public String dadosA(){
    	return "Nome: "+nome+".\nNumero :"+numero+ ".\nEndereço: "+endereço+ ".\nNome do Gerente :"+nomegerente+".\n";
    }
    public void criarClienteF(String chaveCliente,String nomeC,String telC,String emailC,String CPF){
    	
         PessoaF x=new PessoaF();
         x.setAll(nomeC, telC, emailC);;
         x.setCPF(CPF);
         clientes.put(chaveCliente,x); 
    }
         public void criarClienteJ(String chaveCliente,String nomeC,String telC,String emailC,String NF,String CNPJ){    
    	 PessoaJ x=new PessoaJ();
         x.setAll(nomeC, telC, emailC);
         x.setCNPJ(CNPJ);
         x.setNomeF(NF);
         clientes.put(chaveCliente,x); 
    }
 
    public void criarContaC(Cliente c,String chaveConta,String numConta, double limite){
    ContCorrente x=new ContCorrente();
            x.setAll(numConta, true, 0);
            x.setL(limite);
            contas.put(chaveConta,x);
    }
    public void criarContaP(Cliente c,String chaveConta,String numConta){
            ContaPoupança x=new ContaPoupança();
           x.setAll(numConta, true, 0);
         contas.put(chaveConta,x);
       }
    
    
    public Cliente buscarCliente(String chaveCliente){
    	return clientes.get(chaveCliente);
    }
    public Conta buscarConta(String chaveConta){
    	return contas.get(chaveConta);
    }
   
  
}
