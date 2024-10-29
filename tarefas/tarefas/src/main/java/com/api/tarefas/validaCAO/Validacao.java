package com.api.tarefas.validaCAO;

import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Validacao {

    public static boolean validaDataTxtField(String txt) {

        if (txt.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
            String[] v = txt.split("/");
            if (v[0].isBlank() || v[1].isBlank() || v[2].isBlank()) {
                return false;

            } else {
                int dia = Integer.parseInt(v[0]);
                int mes = Integer.parseInt(v[1]);
                int ano = Integer.parseInt(v[2]);

                boolean vDia = dia > 0 && dia <= 31;
                boolean vMes = mes > 0 && dia <= 12;
                boolean vAno = ano > 1900 && ano <= LocalDate.now().getYear();
                boolean valida = true;
                if (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia > 30) {
                        valida = false;
                    }
                }
                if (mes == 2 && dia > 29) {
                    valida = false;
                }
                return vDia && vMes && vAno && valida;
            }
        } else {
            return false;
        }
    }

    public static boolean validaEmail(String email) {
        return email.matches(("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"));
    }

    public static boolean validaNome(String nome) {
        return nome.matches("\\d{9}");

    }

    public static boolean validaTelefone(String a) {
        return a.matches("\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}");
    }

    public static void msgValidacao(boolean b, JTextField txt, String campo) {
        if (!txt.getText().isBlank() && !txt.getText().isEmpty()) {
            if (!b) {
                Validacao.criaBoxMsg("Atenção!:" + campo + "digitado incorretamente", "Erro em" + campo, 2);
                txt.setBackground(Color.red);
                txt.setText("");
            } else {
                txt.setBackground(Color.white);
            }
        }
    }

    public static int criaBoxEscolha(String[] botoes, String msg, String titulo) {
        String[] options = botoes;
        int editar = JOptionPane.showOptionDialog(null, msg, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return editar;
    }

    public static void criaBoxMsg(String msg, String title, int tipo) {
        JOptionPane.showMessageDialog(null, msg, title, tipo);
    }
}
