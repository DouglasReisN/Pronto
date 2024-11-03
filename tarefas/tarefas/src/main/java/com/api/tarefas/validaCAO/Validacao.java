package com.api.tarefas.validaCAO;

import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Validacao {

    public static boolean validaDataTxtField(String txt) {
        if (txt.matches("\\d{2}/\\d{2}/\\d{4}")) {
            String[] v = txt.split("/");
            if (v[0].isBlank() || v[1].isBlank() || v[2].isBlank()) {
                return false;
            } else {
                int dia = Integer.parseInt(v[0]);
                int mes = Integer.parseInt(v[1]);
                int ano = Integer.parseInt(v[2]);

                boolean vDia = dia > 0 && dia <= 31;
                boolean vMes = mes > 0 && mes <= 12; // Corrigido: deve verificar 'mes', não 'dia'
                boolean vAno = ano > 1900 && ano <= LocalDate.now().getYear();
                boolean valida = true;

                // Validações para dias em meses específicos
                if (mes == 2) { // Fevereiro
                    if (dia > 29) {
                        valida = false; // Fevereiro não pode ter mais de 29 dias
                    }
                    if (dia == 29 && !isLeapYear(ano)) {
                        valida = false; // Verifica se é um ano bissexto
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) { // Meses com 30 dias
                    if (dia > 30) {
                        valida = false;
                    }
                }

                return vDia && vMes && vAno && valida;
            }
        } else {
            return false;
        }
    }

    public static boolean validaEmail(String email) {
        return email.toLowerCase().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
    }

    public static boolean validaNome(String nome) {
        // Verifica se o nome não é nulo, tem pelo menos 3 caracteres, e contém apenas letras e espaços
        return nome != null && nome.length() >= 3 && nome.matches("[A-Za-zÀ-ÿ ]+");
    }

    public static boolean validaTelefone(String a) {
        return a.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}");
    }

    public static void msgValidacao(boolean b, JTextField txt, String campo) {
        if (!txt.getText().isBlank() && !txt.getText().isEmpty()) {
            if (!b) {
                Validacao.criaBoxMsg("Atenção! " + campo + " digitado incorretamente", "Erro em " + campo, 2);
                txt.setBackground(Color.red);
                txt.setText("");
            } else {
                txt.setBackground(Color.white);
            }
        }
    }

    public static int criaBoxEscolha(String[] botoes, String msg, String titulo) {
        return JOptionPane.showOptionDialog(null, msg, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
    }

    public static void criaBoxMsg(String msg, String title, int tipo) {
        JOptionPane.showMessageDialog(null, msg, title, tipo);
    }

    // Método auxiliar para verificar se um ano é bissexto
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
