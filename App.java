import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolhaComputador, escolhaUsuario, pontosJogador = 0, pontosComputador = 0;
        boolean continuarJogando = true;

        System.out.println("Bem-vindo ao jogo Pedra, Papel e Tesoura!");

        while (continuarJogando) {
            // Escolha aleatória do computador: 0 para pedra, 1 para papel, 2 para tesoura
            escolhaComputador = (int) (Math.random() * 3);

            System.out.print("\nEscolha pedra (0), papel (1) ou tesoura (2): ");
            escolhaUsuario = input.nextInt();

            if (escolhaUsuario < 0 || escolhaUsuario > 2) {
                System.out.println("Escolha inválida! Tente novamente.");
                continue;
            }

            // Verificando o resultado do jogo
            if (escolhaComputador == escolhaUsuario) {
                System.out.println("Empate!");
            } else if (escolhaComputador == 0 && escolhaUsuario == 2 || escolhaComputador == 1 && escolhaUsuario == 0 || escolhaComputador == 2 && escolhaUsuario == 1) {
                System.out.println("Você perdeu!");
                pontosComputador++;
            } else {
                System.out.println("Você ganhou!");
                pontosJogador++;
            }

            System.out.println("Placar: Jogador " + pontosJogador + " x " + pontosComputador + " Computador");
            clearScreen();

            // Verificando se algum jogador alcançou a pontuação máxima
            if (pontosJogador == 5 || pontosComputador == 5) {
                continuarJogando = false;

                if (pontosJogador > pontosComputador) {
                    System.out.println("Você venceu o jogo!");
                } else {
                    System.out.println("Você perdeu o jogo!");
                }
            }
        }

        input.close();
    }

    public static void clearScreen() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

