
import java.util.HashMap;
import java.util.Set;


public class Agencia {
    HashMap<String,PessoaF> clientesF = new HashMap<>();
    HashMap<String,PessoaJ> clientesJ = new HashMap<>();
     HashMap<String,ContCorrente> contasC = new HashMap<>();
     HashMap<String,ContaPoupança> contasP = new HashMap<>();
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
         clientesF.put(chaveCliente,x); 
    }
         public void criarClienteJ(String chaveCliente,String nomeC,String telC,String emailC,String NF,String CNPJ){    
    	 PessoaJ x=new PessoaJ();
         x.setAll(nomeC, telC, emailC);
         x.setCNPJ(CNPJ);
         x.setNomeF(NF);
         clientesJ.put(chaveCliente,x); 
    }
 
    public void criarContaC(Cliente c,String chaveConta,String numConta, double limite){
    ContCorrente x=new ContCorrente();
            x.setAll(numConta, true, 0);
            x.setL(limite);
            contasC.put(chaveConta,x);
    }
    public void criarContaP(Cliente c,String chaveConta,String numConta){
            ContaPoupança x=new ContaPoupança();
           x.setAll(numConta, true, 0);
         contasP.put(chaveConta,x);
       }
    
    
    public PessoaF buscarClienteF(String chaveClienteF){
    	return clientesF.get(chaveClienteF);
    }
    public PessoaJ buscarClienteJ(String chaveCliente){
    	return clientesJ.get(chaveCliente);
    }
    public ContCorrente buscarContaC(String chaveConta){
    	return contasC.get(chaveConta);
    }
    public ContaPoupança buscarContaP(String chaveConta){
    	return contasP.get(chaveConta);
    }
    public void listaClientes(){
    	System.out.println("Os clientes Pessoa Juridica são:\n");
    	Set<String> chavesJ = clientesJ.keySet();
        for(String chave: chavesJ){
            System.out.println(clientesJ.get(chave).dadosC()+"\n");}
        System.out.println("Os clientes Pessoa Fisica são:\n");
        Set<String> chavesF = clientesF.keySet();
        for(String chave: chavesF){
            System.out.println(clientesF.get(chave).dadosC()+"\n");}
    }
  
}
