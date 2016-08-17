package Agencias;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import Clientes.*;

public class Agencia {
    HashMap<String,PessoaF> clientesF = new HashMap<String,PessoaF>();
    HashMap<String,PessoaJ> clientesJ = new HashMap<String,PessoaJ>();
     HashMap<String,ContCorrente> contasC = new HashMap<String,ContCorrente>();
     HashMap<String,ContaPoupança> contasP = new HashMap<String,ContaPoupança>();
     int numero;
     String nome,endereço,nomegerente,telefone;
    public Agencia(int numero,String nome,String telefone,String endereço,String nomegerente){
    	this.nome=nome;
    	this.numero=numero;
    	this.endereço=endereço;
    	this.telefone=telefone;
    	this.nomegerente=nomegerente;
    }
    public String dadosA(){
    	return "Numero :"+numero+".\nNome: "+nome+".\nTelefone:"+telefone+ ".\nEndereço: "+endereço+ ".\nNome do Gerente :"+nomegerente+".\n";
    }
    public void criarClienteF(String nomeC,String telC,String emailC,String CPF){
    	
         PessoaF x=new PessoaF();
         x.setAll(nomeC, telC, emailC);;
         x.setCPF(CPF);
         clientesF.put(CPF,x); 
    }
         public void criarClienteJ(String nomeC,String telC,String emailC,String NF,String CNPJ){    
    	 PessoaJ x=new PessoaJ();
         x.setAll(nomeC, telC, emailC);
         x.setCNPJ(CNPJ);
         x.setNomeF(NF);
         clientesJ.put(CNPJ,x); 
    }
 
    public void criarContaC(PessoaF f,int numConta, double limite){
    ContCorrente x=new ContCorrente(f);
            x.setAll(numConta, true, 0);
            x.setL(limite);
            contasC.put(String.valueOf(numConta),x);
    }
    public void criarContaC(PessoaJ j,int numConta, double limite){
        ContCorrente x=new ContCorrente(j);
                x.setAll(numConta, true, 0);
                x.setL(limite);
                contasC.put(String.valueOf(numConta),x);
        }
    public void criarContaP(PessoaF f,int numConta){
            ContaPoupança x=new ContaPoupança(f);
           x.setAll(numConta, true, 0);
         contasP.put(String.valueOf(numConta),x);
       }
    public void criarContaP(PessoaJ j,int numConta){
        ContaPoupança x=new ContaPoupança(j);
       x.setAll(numConta, true, 0);
     contasP.put(String.valueOf(numConta),x);
   }
    
    
    public PessoaF buscarClienteF(String chaveClienteF){
    	return clientesF.get(chaveClienteF);
    }
    public PessoaJ buscarClienteJ(String chaveCliente){
    	return clientesJ.get(chaveCliente);
    }
    public ContCorrente buscarContaC(int numConta){
    	return contasC.get(String.valueOf(numConta));
    }
    public ContaPoupança buscarContaP(int numConta){
    	return contasP.get(String.valueOf(numConta));
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
    public void calcPoupança(Calendar data){
    	Set<String> chavesP = contasP.keySet();
        for(String chave: chavesP){
        	contasP.get(chave).atualizarDatas(data);
        	contasP.get(chave).getD();
        }
    }
        public void deleteClienteF(String chave){
        	
        	Set<String> chavesP = contasP.keySet();
        	
            for(String chavep: chavesP){
            	if(contasC.get(chavep).obterPF().equals(clientesF.get(chave))){
            	contasP.remove(chavep);}}
            Set<String> chavesC = contasC.keySet();
            for(String chavec: chavesC){
            	if(contasC.get(chavec).obterPF().equals(clientesF.get(chave))){
            	contasC.remove(chavec);}}
            clientesF.remove(chave);
        }
  public void deleteClienteP(String chave){
        	
        	Set<String> chavesP = contasP.keySet();
        	
            for(String chavep: chavesP){
            	if(contasC.get(chavep).obterPJ().equals(clientesJ.get(chave))){
            	contasP.remove(chavep);}}
            Set<String> chavesC = contasC.keySet();
            for(String chavec: chavesC){
            	if(contasC.get(chavec).obterPJ().equals(clientesJ.get(chave))){
            	contasC.remove(chavec);}}
            clientesJ.remove(chave);
        }
        public void deleteClienteJ(String chave){
        	clientesJ.remove(chave);
        }
        public void deleteContaC(int numConta){
        	contasC.remove(String.valueOf(numConta));
        }
        public void deleteContaP(int numConta){
        	contasP.remove(String.valueOf(numConta));
        }
    
}
