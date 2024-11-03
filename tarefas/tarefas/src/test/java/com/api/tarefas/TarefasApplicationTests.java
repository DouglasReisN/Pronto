package com.api.tarefas;

import com.api.tarefas.validaCAO.Validacao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TarefasApplicationTests {

    @Test
    void contextLoads() {
    }

   @Test
void testValidaNome() {
    assertTrue(Validacao.validaNome("João Silva"), "O nome 'João Silva' deveria ser válido");
    assertFalse(Validacao.validaNome("Jo"), "Nomes muito curtos não devem ser válidos");
    assertFalse(Validacao.validaNome("João123"), "Nomes com números não devem ser válidos");
    assertFalse(Validacao.validaNome(""), "Nomes vazios não devem ser válidos");
    assertFalse(Validacao.validaNome("A"), "Nomes com uma letra só não devem ser válidos");
}


    @Test
    void testValidaData() {
        // Testes para validar datas
        assertFalse(Validacao.validaDataTxtField("11/35/2555")); // Data inválida
        assertFalse(Validacao.validaDataTxtField("11/a8/900")); // Data inválida
        assertTrue(Validacao.validaDataTxtField("01/12/2023")); // Data válida
    }

    @Test
    void testValidaTelefone() {
        // Testes para validar telefone
        assertFalse(Validacao.validaTelefone("0000-00000")); // Telefone inválido
        assertTrue(Validacao.validaTelefone("(11) 91234-5678")); // Telefone válido (exemplo)
    }

    @Test
    void testValidaEmail() {
        // Testes para validar e-mail
        assertFalse(Validacao.validaEmail("kkkkk@")); // E-mail inválido
        assertTrue(Validacao.validaEmail("email@dominio.com")); // E-mail válido
    }
}
