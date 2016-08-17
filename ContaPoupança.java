package Agencias;
import java.util.Calendar;

import Clientes.PessoaF;
import Clientes.PessoaJ;

public class ContaPoupança extends Conta{
Calendar aniversario;
int numMes,numDia,numAno;
double saldoInicioMes=saldo;

public ContaPoupança(PessoaJ j) {
	super(j);
	aniversario=Calendar.getInstance();
	aniversario.add(Calendar.MONTH, 1);
}

public ContaPoupança(PessoaF f) {
super(f);
aniversario=Calendar.getInstance();
aniversario.add(Calendar.MONTH, 1);
}

public void getD(){
System.out.println(aniversario.get(Calendar.YEAR)+aniversario.get(Calendar.MONTH)+aniversario.get(Calendar.DAY_OF_MONTH));
}
public void atualizarDatas(Calendar data){
	if( data.get(Calendar.DAY_OF_MONTH)==aniversario.get(Calendar.DAY_OF_MONTH)){
		if( data.get(Calendar.MONTH)==aniversario.get(Calendar.MONTH)){
			if( data.get(Calendar.YEAR)==aniversario.get(Calendar.YEAR)){
			aniversario.add(Calendar.MONTH, 1);
			saldo+=(saldoInicioMes*0.005);
			saldoInicioMes=saldo;
			}
		}
	}
}	
}
