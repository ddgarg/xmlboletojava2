package org.jboleto.exemplos;


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
import java.util.Vector;
import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;
import org.jboleto.control.Generator;
import org.jboleto.control.PDFGenerator;

class FormBancoBrasil {

    public static void main(String args[]) {

        JBoletoBean jBoletoBean = new JBoletoBean();

        jBoletoBean.setDataDocumento("23/10/2008");
        jBoletoBean.setDataProcessamento("23/10/2008");

        jBoletoBean.setCedente("CONSELHO REGIONAL DE ENGENHARIA DO RIO GRANDE DO NORTE");
        jBoletoBean.setCarteira("21");

        jBoletoBean.setNomeSacado("WANDERSON CÂMARA DOS SANTOS");
        jBoletoBean.setEnderecoSacado("Av. Senador Salgado Filho");
        jBoletoBean.setBairroSacado("Lagoa Nova");
        jBoletoBean.setCidadeSacado("Rio Grande do Norte");
        jBoletoBean.setUfSacado("RN");
        jBoletoBean.setCepSacado("59040-580");
        jBoletoBean.setCpfSacado("0000000000000");

        jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO BANCO DO BRASIL");
        jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO BANCO DO BRASIL");

        Vector descricoes = new Vector();
        jBoletoBean.setDescricoes(descricoes);

        //jBoletoBean.setImagemMarketing("/home/wanderson/boleto.jpg");

        jBoletoBean.setDataVencimento("04/12/2008");
        jBoletoBean.setInstrucao1("ANUIDADE PESSOA FÍSICA DO EXERCICIO - 2008");
        jBoletoBean.setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        jBoletoBean.setInstrucao3("");
        jBoletoBean.setInstrucao4("");

        jBoletoBean.setAgencia("1668");
        jBoletoBean.setContaCorrente("00074123"); //completar com zeros quando necessario
        jBoletoBean.setDvContaCorrente("X");

            jBoletoBean.setNumConvenio("458800");
        jBoletoBean.setNossoNumero("8200310194", 17);
        jBoletoBean.setValorBoleto("116.55"); 

        Generator generator = new PDFGenerator(jBoletoBean, JBoleto.BANCO_DO_BRASIL);
        JBoleto jBoleto = new JBoleto(generator, jBoletoBean, JBoleto.BANCO_DO_BRASIL);

        for (int i = 0; i < 10; i++) {
            jBoleto.addBoleto();
            jBoletoBean.setNomeSacado("WANDERSON C. SANTOS");
        }

        jBoleto.closeBoleto("/home/wanderson/00XBBCREA.pdf");

    }
}
