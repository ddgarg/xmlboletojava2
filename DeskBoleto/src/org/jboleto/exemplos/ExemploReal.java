/*
 * Esta biblioteca e um software livre, que pode ser redistribuido e/ou 
 * modificado sob os termos da Licença Publica Geral Reduzida GNU, 
 * conforme publicada pela Free Software Foundation, versao 2.1 da licenca.
 *
 * Esta biblioteca e distribuida na experanca de ser util aos seus usuarios, 
 * porem NAO TEM NENHUMA GARANTIA, EXPLICITAS OU IMPLICITAS, COMERCIAIS OU 
 * DE ATENDIMENTO A UMA DETERMINADA FINALIDADE. 
 * Veja a Licenca Publica Geral Reduzida GNU para maiores detalhes. 
 * A licenca se encontra no arquivo lgpl-br.txt 
 */

package org.jboleto.exemplos;

import java.util.Vector;
import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;
import org.jboleto.control.Generator;
import org.jboleto.control.PDFGenerator;


/**
 * @author Fabio Souza
 */
class ExemploReal {
        
	public static void main(String args[]) {
		JBoletoBean jBoletoBean = new JBoletoBean();
		
		jBoletoBean.setDataDocumento("31/05/2007");
        jBoletoBean.setDataProcessamento("31/05/2007");      
            
        jBoletoBean.setCedente("KOBI SYSTEM LTDA ME");  

        jBoletoBean.setNomeSacado("Teste");
        jBoletoBean.setEnderecoSacado("Rua teste");        
        jBoletoBean.setBairroSacado("XXXX");
        jBoletoBean.setCidadeSacado("Rio de Janeiro");
        jBoletoBean.setUfSacado("RJ");
        jBoletoBean.setCepSacado("22753-501");
        jBoletoBean.setCpfSacado("87524988753");
        jBoletoBean.setCarteira("57");
        jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO BANCO REAL ABN AMRO");
        jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO BANCO REAL ABN AMRO");
        
        Vector descricoes = new Vector();
        descricoes.add("Hospedagem I - teste descricao1 - R$ 39,90");
        descricoes.add("Manutencao - teste ricao2 - R$ 32,90");
        descricoes.add("Sistema - teste ssssde descricao3 - R$ 45,90");
        descricoes.add("Extra - teste de descricao4 - R$ 78,90");
        jBoletoBean.setDescricoes(descricoes);
        
        jBoletoBean.setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        jBoletoBean.setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        jBoletoBean.setInstrucao3("Inclusao de mais uma linha");
        jBoletoBean.setInstrucao4("");

        //ag. 0957
        //cc. 5003709 6
        jBoletoBean.setAgencia("0957");
        jBoletoBean.setContaCorrente("5003709");
        jBoletoBean.setDvContaCorrente("6");
        
        jBoletoBean.setNossoNumero("3020",13);
        jBoletoBean.setNoDocumento("3020");
        jBoletoBean.setValorBoleto("35.00");                
        jBoletoBean.setDataVencimento("02/10/2007");
        
        Generator generator = new PDFGenerator(jBoletoBean, JBoleto.BANCO_REAL);
        JBoleto jBoleto = new JBoleto(generator, jBoletoBean, JBoleto.BANCO_REAL);        
        jBoleto.addBoleto();
        
        jBoleto.closeBoleto("real.pdf");	        
            
	}
}
