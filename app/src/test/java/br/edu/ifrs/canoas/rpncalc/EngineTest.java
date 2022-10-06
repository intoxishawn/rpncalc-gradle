package br.edu.ifrs.canoas.rpncalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class EngineTest {
    Engine engine;
    Stack<Double> pilha;

    @BeforeEach
    void preparar() {
        pilha = new Stack<>();
        engine = new Engine(pilha);
    }

    @Test
    @DisplayName("Pedir ajuda.")
    void pedirAjuda() {
        engine.operar("ajuda");
        assertEquals(0, pilha.size(), "Não deveria modificar a pilha.");
    }


    @Test
    @DisplayName("Parar a engine.")
    void pararEngine() {
        assertTrue(engine.estaRodando(), "Deveria estar rodando.");
        engine.operar("sair");
        assertEquals(0, pilha.size(), "Não deveria modificar a pilha.");
        assertFalse(engine.estaRodando(), "Não deveria estar mais rodando.");
    }

    @Test
    @DisplayName("Inserir um número na pilha.")
    void inserirUmNumero() {
        engine.operando(10.0);
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(10.0, pilha.pop(), "O operando inserido deveria estar no topo da pilha.");
    }

    @Test
    @DisplayName("Inserir dois números na pilha.")
    void inserirDoisNumeros() {
        engine.operando(10.0);
        engine.operando(20.0);
        assertEquals(2, pilha.size(), "Deveria haver exatamente dois operandos na pilha.");
        assertEquals(20.0, pilha.pop(), "O último operando inserido deveria estar no topo da pilha.");
        assertEquals(10.0, pilha.pop(), "O primeiro operando inserido deveria estar na base da pilha.");
    }

    @Test
    @DisplayName("Limpar a pilha.")
    void limparPilha() {
        engine.operando(10.0);
        engine.operando(20.0);
        engine.operar("limpar");
        assertEquals(0, pilha.size(), "A pilha deveria estar vazia.");
    }

    @Test
    @DisplayName("Somar dois números.")
    void somarDoisNumeros() {
        engine.operando(10.0);
        engine.operando(20.0);
        engine.operar("+");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(30.0, pilha.pop(), "A soma dos operandos deveria estar no topo da pilha.");
    }

    @Test
    @DisplayName("Somar um número.")
    void somarUmNumero() {
        engine.operando(10.0);
        engine.operar("+");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(10.0, pilha.pop(), "O mesmo operando deveria estar no topo da pilha.");
    }

    @Test
    @DisplayName("Diminuir um número.")
    void diminuirUmNumero() {
        engine.operando(10.0);
        engine.operar("-");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(10.0, pilha.pop(), "O mesmo operando deveria estar no topo da pilha.");
    }

    @Test
    @DisplayName("Diminuir dois números.")
    void diminuirDoisNumeros() {
        engine.operando(10.0);
        engine.operando(5.0);
        engine.operar("-");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(5.0, pilha.pop(), "A subtracao dos operandos deveriam estar no topo da pilha.");
    }

    @Test
    @DisplayName("Multiplicar dum número.")
    void multiplicarUmNumero() {
        engine.operando(10.0);
        engine.operar("*");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(10.0, pilha.pop(), "O mesmo operando deveria estar no topo da pilha.");
    }

    @Test
    @DisplayName("Multiplicar dois números.")
    void multiplicarDoisNumeros() {
        engine.operando(10.0);
        engine.operando(5.0);
        engine.operar("*");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(50.0, pilha.pop(), "A multiplicao dos operandos deveriam estar no topo da pilha.");
    }

    @Test
    @DisplayName("Dividir um número.")
    void dividirUmNumero() {
        engine.operando(10.0);
        engine.operar("/");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(10.0, pilha.pop(), "O mesmo operando deveria estar no topo da pilha.");
    }

    @Test
    @DisplayName("Dividir dois números.")
    void dividirDoisNumeros() {
        engine.operando(10.0);
        engine.operando(5.0);
        engine.operar("/");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(2.0, pilha.pop(), "A divisao dos operandos deveriam estar no topo da pilha.");
    }

    @Test
    @DisplayName("Raiz quadrada de um número.")
    void raizQuadradaDeUmNumero() {
        engine.operando(16.0);
        engine.operar("raiz");
        assertEquals(1, pilha.size(), "Deveria haver exatamente um operando na pilha.");
        assertEquals(4.0, pilha.pop(), "A raiz quadrada do operando deveria estar no topo da pilha.");
    }
}
