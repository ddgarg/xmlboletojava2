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
class ExemploBancoBrasil {
        
	public static void main(String args[]) {
        
        JBoletoBean jBoletoBean = new JBoletoBean();
		
	jBoletoBean.setDataDocumento("31/05/2006");
        jBoletoBean.setDataProcessamento("31/05/2006");      
            
        jBoletoBean.setCedente("KOBI System");  
        jBoletoBean.setCarteira("17");

        jBoletoBean.setNomeSacado("ARCOR");
        jBoletoBean.setEnderecoSacado("Rua Teste");        
        jBoletoBean.setBairroSacado("Barra");
        jBoletoBean.setCidadeSacado("Rio de Janeiro");
        jBoletoBean.setUfSacado("RJ");
        jBoletoBean.setCepSacado("22753-501");
        jBoletoBean.setCpfSacado("0000000000000");
        
        jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO BANCO DO BRASIL");
        jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO BANCO DO BRASIL");        
        
        Vector descricoes = new Vector();
        jBoletoBean.setDescricoes(descricoes);
        
        jBoletoBean.setDataVencimento("10/06/2006");
        jBoletoBean.setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        jBoletoBean.setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        jBoletoBean.setInstrucao3("");
        jBoletoBean.setInstrucao4("");

        jBoletoBean.setAgencia("003415");
        jBoletoBean.setContaCorrente("00543004"); //completar com zeros quando necessario
               
        jBoletoBean.setNumConvenio("110135");
        jBoletoBean.setNossoNumero("0005963971",17);
        jBoletoBean.setValorBoleto("1.00");
        
        Generator generator = new PDFGenerator(jBoletoBean, JBoleto.BANCO_DO_BRASIL);
        JBoleto jBoleto = new JBoleto(generator, jBoletoBean, JBoleto.BANCO_DO_BRASIL);
        
        jBoleto.addBoleto();
        
        jBoleto.closeBoleto("bb.pdf");	        
            
	}
}
