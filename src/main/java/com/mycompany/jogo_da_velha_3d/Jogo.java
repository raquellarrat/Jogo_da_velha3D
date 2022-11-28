/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo_da_velha_3d;

/**
 *
 * @author raque
 */

/// Raquel Larrat Lopes  202035009
import java.util.Scanner;
import java.util.Random;

public class Jogo {

    char[][] camada1 = new char[3][3];
    char[][] camada2 = new char[3][3];
    char[][] camada3 = new char[3][3];

    public void preencheCamadas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                camada1[i][j] = '-';
                camada2[i][j] = '-';
                camada3[i][j] = '-';
            }
        }
    }

    //// tela que pergunta o modo de jogo JxJ ou JxB
    public void modoDeJogo() {
        System.out.println("Digite o modo de jogo(JxJ - para dois jogadores, ou JxB - para jogar\n" + "contra o bot):");
        String modoDeJogo = "";

        preencheCamadas();
        //imprimeTabuleiro();

        Scanner s = new Scanner(System.in);
        modoDeJogo = s.nextLine();

        if (modoDeJogo.equals("JxJ")) {
            jogoJxJ();
        } else {
            jogoContraBot();
        }
    }

    public boolean fimDeJogo(char j) {  /// verifica se um dos simbolos ganhou
        //1 jogador 1 ganhou
        //2 jogar 2 ganhou

        ////verifica se o jogador ganhou por linha de uma camada
        for (int i = 0; i < 3; i++) {
            if ((camada1[i][0] == j && camada1[i][1] == j && camada1[i][2] == j)
                    || (camada2[i][0] == j && camada2[i][1] == j && camada2[i][2] == j)
                    || (camada3[i][0] == j && camada3[i][1] == j && camada3[i][2] == j)) {
                return true;
            }
        }

        ////verifica se o jogador ganhou por coluna de uma camada
        for (int i = 0; i < 3; i++) {
            if ((camada1[0][i] == j && camada1[1][i] == j && camada1[2][i] == j)
                    || (camada2[0][i] == j && camada2[1][i] == j && camada2[2][i] == j)
                    || (camada3[0][i] == j && camada3[1][i] == j && camada3[2][i] == j)) {
                return true;
            }
        }
        ////verifica se o jogador ganhou por diagonal de uma camada
        if ((camada1[0][0] == j && camada1[1][1] == j && camada1[2][2] == j)
                || (camada2[0][0] == j && camada2[1][1] == j && camada2[2][2] == j)
                || (camada3[0][0] == j && camada3[1][1] == j && camada3[2][2] == j)) {
            return true;
        }
        /// verifica se o jogador ganhou por coluna das 3 camadas

        for (int i = 0; i < 3; i++) {
            if ((camada1[i][0] == j && camada2[i][1] == j && camada3[i][2] == j)
                    || (camada1[0][i] == j && camada2[2][i] == j && camada3[1][i] == j)
                    || (camada1[1][i] == j && camada2[0][i] == j && camada3[2][i] == j)
                    || (camada1[1][i] == j && camada2[2][i] == j && camada3[0][i] == j)
                    || (camada1[2][i] == j && camada2[0][i] == j && camada3[1][i] == j)
                    || (camada1[2][i] == j && camada2[1][i] == j && camada3[0][i] == j)) {
                return true;
            }
        }

        ////verifica se o jogador ganhou por linha das 3 camadas
        for (int i = 0; i < 3; i++) {
            if ((camada1[i][0] == j && camada2[i][1] == j && camada3[i][2] == j)
                    || (camada1[i][0] == j && camada2[i][2] == j && camada3[i][1] == j)
                    || (camada1[i][1] == j && camada2[i][0] == j && camada3[i][2] == j)
                    || (camada1[i][1] == j && camada2[i][2] == j && camada3[i][0] == j)
                    || (camada1[i][2] == j && camada2[i][0] == j && camada3[i][1] == j)
                    || (camada1[i][2] == j && camada2[i][1] == j && camada3[i][0] == j)) {
                return true;
            }
        }

        /// verifica se o jogador ganhou por diagonal das 3 camadas
        if ((camada1[0][0] == j && camada2[1][1] == j && camada3[2][2] == j)
                || (camada1[0][0] == j && camada2[2][2] == j && camada3[1][1] == j)
                || (camada1[1][1] == j && camada2[0][0] == j && camada3[2][2] == j)
                || (camada1[1][1] == j && camada2[2][2] == j && camada3[0][0] == j)
                || (camada1[2][2] == j && camada2[0][0] == j && camada3[1][1] == j)
                || (camada1[2][2] == j && camada2[1][1] == j && camada3[0][0] == j)) {
            return true;
        }
        
        /// verifica a outra diagonal por camadas
        if ((camada1[0][2] == j && camada2[1][1] == j && camada3[2][0] == j)
                || (camada1[1][1] == j && camada2[0][2] == j && camada3[2][0] == j)
                || (camada1[1][1] == j && camada2[2][0] == j && camada3[0][2] == j)
                || (camada1[2][0] == j && camada2[1][1] == j && camada3[0][2] == j)
                || (camada1[2][0] == j && camada2[0][2] == j && camada3[1][1] == j)
                || (camada1[0][2] == j && camada2[2][0] == j && camada3[1][1] == j)) {
            return true;
        }
        

        return false;
    }

    public void jogoContraBot() {
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String jogador;
        char j;
        char botSimbolo;
        String recomecar = "";

        ////set nome e simbolo do jogador
        System.out.println("Digite o nome do jogador: ");
        jogador = s.nextLine();
        System.out.println("Digite o símbolo que deseja utilizar durante o jogo: ");
        j = s.next().charAt(0);

        if (j == 'X') {
            botSimbolo = 'O';
        } else {
            botSimbolo = 'X';
        }

        do {
            marcaNoTabuleiro(jogador, j);
            if (fimDeJogo(j)) {
                System.out.println("Parabens " + jogador);
                System.out.println("Deseja jogar novamente? sim/nao");
                recomecar = s2.nextLine();
                if (recomecar.equals("sim")) {
                    modoDeJogo();

                } else {
                    System.exit(0);
                }
            }

            /// jogada aleatória do bot
            System.out.println("Jogada do Bot: ");
            jogadaDoBot(botSimbolo);

            ////
            if (fimDeJogo(botSimbolo)) {
                System.out.println("Infelizmente o Bot ganhou de você!");
                System.out.println("Deseja jogar novamente? sim/nao");
                recomecar = s2.nextLine();
                if (recomecar.equals("sim")) {
                    modoDeJogo();

                } else {
                    System.exit(0);
                }

            }

        } while (((!fimDeJogo(j)) && (!fimDeJogo(botSimbolo))) || !deuEmpate());

    }

    public void jogadaDoBot(char botSimbolo) {
        Random numAleatorio = new Random();
        int maximo = 3;
        int linha;
        int coluna;
        int camada;

        do {
            linha = numAleatorio.nextInt(maximo);
            coluna = numAleatorio.nextInt(maximo);
            camada = numAleatorio.nextInt(maximo);
        } while (!(camada == 0 && camada1[linha][coluna] == '-')
                && !(camada == 1 && camada2[linha][coluna] == '-')
                && !(camada == 2 && camada3[linha][coluna] == '-'));

        if (camada == 0 && camada1[linha][coluna] == '-') {
            camada1[linha][coluna] = botSimbolo;
            imprimeTabuleiro();
        } else if (camada == 1 && camada2[linha][coluna] == '-') {
            camada2[linha][coluna] = botSimbolo;
            imprimeTabuleiro();
        } else if (camada == 2 && camada3[linha][coluna] == '-') {
            camada3[linha][coluna] = botSimbolo;
            imprimeTabuleiro();
        }
    }

    

    public void jogoJxJ() {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String jogador1;
        char j1;

        String jogador2;
        char j2;

        ////set nome e simbolo do jogador 1
        System.out.println("Digite o nome do jogador 1: ");
        jogador1 = s.nextLine();
        System.out.println("Digite o símbolo que deseja utilizar durante o jogo: ");
        j1 = s.next().charAt(0);

        /// set nome e simbolo do jogador 2     
        System.out.println("Digite o nome do jogador 2: ");
        jogador2 = s1.nextLine();
        System.out.println("Digite o símbolo que deseja utilizar durante o jogo: ");
        j2 = s.next().charAt(0);

        String recomecar = "";

        do {
            marcaNoTabuleiro(jogador1, j1);
            if (fimDeJogo(j1)) {
                System.out.println("Parabens " + jogador1);
                System.out.println("Deseja jogar novamente? sim/nao");
                recomecar = s2.nextLine();
                if (recomecar.equals("sim")) {
                    modoDeJogo();

                } else {
                    System.exit(0);
                }
            }
            marcaNoTabuleiro(jogador2, j2);
            if (fimDeJogo(j2)) {
                System.out.println("Parabens " + jogador2);
                System.out.println("Deseja jogar novamente? sim/nao");
                recomecar = s2.nextLine();
                if (recomecar.equals("sim")) {
                    modoDeJogo();

                } else {
                    System.exit(0);
                }

            }

        } while (((!fimDeJogo(j1)) && (!fimDeJogo(j2))) || !deuEmpate());

    }

    ///verifica se o tabuleiro está cheio, ou seja, deu impate
    public boolean deuEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((camada1[i][j] != '-') || (camada2[i][j] != '-') || (camada3[i][j] != '-')) {
                    return false;
                }
            }
        }
        return true;
    }
    
    ///////////////////////////////////

    //// verifica se a jogada é válida e marca no tabuleiro caso seja
    public void marcaNoTabuleiro(String nomeJogador, char simbolo) {
        System.out.println("====> Turno do " + nomeJogador);
        System.out.println("Digite a posição que deseja jogar no formato (linha, coluna, camada):");
        Scanner s = new Scanner(System.in);

        String jogada = "";
        int linha;
        int coluna;
        int camada;
        jogada = s.nextLine();
        linha = Character.getNumericValue(jogada.charAt(1));
        coluna = Character.getNumericValue(jogada.charAt(4));
        camada = Character.getNumericValue(jogada.charAt(7));

        if (((linha >= 0) && (linha <= 2)) && ((coluna >= 0) && (coluna <= 2)) && ((camada >= 0) && (camada <= 2))) {
            if (camada == 0 && camada1[linha][coluna] == '-') {
                camada1[linha][coluna] = simbolo;
                imprimeTabuleiro();
            } else if (camada == 1 && camada2[linha][coluna] == '-') {
                camada2[linha][coluna] = simbolo;
                imprimeTabuleiro();
            } else if (camada == 2 && camada3[linha][coluna] == '-') {
                camada3[linha][coluna] = simbolo;
                imprimeTabuleiro();
            } else {
                System.out.println("Movimento inválido! Tente Novamente!");
                marcaNoTabuleiro(nomeJogador, simbolo);
            }
        } else {
            System.out.println("Movimento inválido! Tente Novamente!");
            marcaNoTabuleiro(nomeJogador, simbolo);
        }

    }
///////////////////////////////
    public void imprimeTabuleiro() {
        for (int i = 0; i < 3; i++) {
            System.out.print(camada1[i][0] + " ");
            System.out.print(camada1[i][1] + " ");
            System.out.print(camada1[i][2] + " ");

            System.out.print("   ");

            System.out.print(camada2[i][0] + " ");
            System.out.print(camada2[i][1] + " ");
            System.out.print(camada2[i][2] + " ");

            System.out.print("   ");

            System.out.print(camada3[i][0] + " ");
            System.out.print(camada3[i][1] + " ");
            System.out.print(camada3[i][2] + " ");

            System.out.println("");
        }
    }

}
/////////////////////