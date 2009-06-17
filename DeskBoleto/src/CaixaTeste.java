
import java.util.Vector;
import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;
import org.jboleto.control.Generator;
import org.jboleto.control.PDFGenerator;

/**
 * Unidade de teste para testar a classe do Banco Caixa Econômica
 *
 * @author Fabio Souza
 */
public class CaixaTeste {

    public CaixaTeste() {
    }

    public void testGeraBoleto() {

        boolean ok = false;

        try {

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
            jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NA CAIXA ECONOMICA");
            jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NA CAIXA ECONOMICA");
            
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

            jBoletoBean.setAgencia("0155");
            jBoletoBean.setContaCorrente("13877");
            jBoletoBean.setDvContaCorrente("4");

            jBoletoBean.setCarteira("80"); //pode ser 80 ou 81 ou 82 (Confirmar com gerente)
            jBoletoBean.setCodigoOperacao("870");
            jBoletoBean.setCodigoFornecidoAgencia("00000324");
            jBoletoBean.setDvCodigoFornecidoAgencia("02");

            jBoletoBean.setNossoNumero("19525086",8);
            jBoletoBean.setNoDocumento("987656123");

            jBoletoBean.setValorBoleto("2952.95");
            jBoletoBean.setDataVencimento("02/10/2007");

            Generator generator = new PDFGenerator(jBoletoBean, JBoleto.CAIXA_ECONOMICA);
            JBoleto jBoleto = new JBoleto(generator, jBoletoBean, JBoleto.CAIXA_ECONOMICA);
            jBoleto.addBoleto();

            jBoleto.closeBoleto("caixa.pdf");

            ok = true;
        }
        catch (Exception ex) {

            ex.printStackTrace();
        }

    }
    public static void main(String args[]) {

       CaixaTeste ct = new CaixaTeste();
       ct.testGeraBoleto();

    }
}