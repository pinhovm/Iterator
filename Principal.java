package Projeto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Principal implements Serializable {
    static Pessoa p = new Pessoa();
    public static void main(String args[]) throws IOException, AWTException {
        menu();
    }

    public static void menu() throws IOException, AWTException {
        int sair = 0;
        /*  1 - Cadastar Nova Familia
            2 - Enviar Notificação
            3 - Editar Cidadao */
        while(sair!=1){
            int menu = Integer.parseInt(JOptionPane.showInputDialog("MENU " +
                    "\n1 - Cadastrar Familia \n2 - Enviar Notificação"));
            switch(menu){
                case 1:
                    cadastrarFamilia();
                    break;
                case 2:
                    String mensagem_a_ser_enviada = JOptionPane.showInputDialog("Mensagem a ser enviada: ");
                    String idade = JOptionPane.showInputDialog("Idade: ");
                    String sexo = JOptionPane.showInputDialog("Sexo: ");

                    ArrayList<Pessoa> pe = p.getListaCidadaos();
                    Iterator MenuIterador = new Menu(pe);
                    while(MenuIterador.hasNext()){
                        Pessoa pes = new Pessoa();
                        if(pes.getSexo() ==  sexo && pes.getIdade() == idade){
                            enviarNotificacao(pes.getCelular(), mensagem_a_ser_enviada);
                        }
                        pes = (Pessoa)MenuIterador.next();
                    }
            }
        }
    }


    //cadastrar familia
    private static void cadastrarFamilia() {
        JOptionPane.showMessageDialog(null, "Endereco");
        Pessoa pessoa = new Pessoa();
        pessoa.endereco.setNumero(JOptionPane.showInputDialog("Numero: "));
        pessoa.endereco.setRua(JOptionPane.showInputDialog("Rua: "));
        pessoa.endereco.setBairro(JOptionPane.showInputDialog("Bairro: "));
        pessoa.endereco.setCidade(JOptionPane.showInputDialog("Cidade: "));
        pessoa.endereco.setEstado(JOptionPane.showInputDialog("Estado: "));
        int sair = 1;
        int caso = 0;

        while (sair != 0) {
            sair = Integer.parseInt(JOptionPane.showInputDialog("Cadastrar Novo Familiar (1 para sair)"));

            pessoa.setNome      (JOptionPane.showInputDialog("Nome: "));
            pessoa.setIdade     (JOptionPane.showInputDialog("Idade: "));
            pessoa.setCpf       (JOptionPane.showInputDialog("CPF: "));
            pessoa.setIdentidade(JOptionPane.showInputDialog("ID: "));
            pessoa.setCartao_sus(JOptionPane.showInputDialog("Cartao SUS: "));
            pessoa.setCelular   (JOptionPane.showInputDialog("Celular: "));
            pessoa.setSexo      (JOptionPane.showInputDialog("Sexo: "));
            p.addCidadao(pessoa);

        }
    }

    private static void enviarNotificacao(String numero, String mensagem) throws IOException, AWTException {
        StringBuffer web_whatsapp_send = new StringBuffer("https://web.whatsapp.com/send?phone=");
        web_whatsapp_send.append(numero);
        web_whatsapp_send.append("&text=");
        web_whatsapp_send.append(mensagem);
        Runtime.getRuntime().exec(new String[] {"explorer", String.valueOf(web_whatsapp_send)});


        Robot robot = new Robot();
        //aperta enter após o link com numero e mensagem ser aberto
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        robot.keyPress((int) KeyEvent.MOUSE_EVENT_MASK);
                        robot.keyRelease((int) KeyEvent.MOUSE_EVENT_MASK);
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);

                    }
                },
                10000
        );
        //fecha a aba do navegador
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_W);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyRelease(KeyEvent.VK_W);

                    }
                }, 12000
        );
    }

}
