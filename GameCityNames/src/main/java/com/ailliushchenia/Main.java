package com.ailliushchenia;

import java.util.Scanner;

public class Main {
    private final String helloMessage = "Привет! :)\nДавай поиграем в города!";
    private final String gamerCountRequestMessage = "Сколько будет игроков?";
    private final String gamerCountMessage = "Здорово! Будет играть %d игроков!";
    private final String botRequestMessage = "Можно мне с вами? (д/н)";
    private final String thanks = "Спасибо!";
    private final String noAnswer = "Играть не будут, но вам обязательно помогу :)!";
    private final String startMessage = "Начинаем!";
    private int gamerCount = 0;
    private boolean isBotInGame = false;
    public static void main(String[] args) {
        new Main().startGame();
    }
    private void startGame() {
        System.out.println(helloMessage);
        System.out.println();
        System.out.println(gamerCountRequestMessage);
        Scanner in = new Scanner(System.in);

        gamerCount = Integer.parseInt(in.nextLine());

        //TODO поставить проверку на то, что gamerCount является целочисленным значением больше 0
        System.out.println(String.format(gamerCountMessage, gamerCount));
        System.out.println();
        System.out.println(botRequestMessage);
        String botRequestMessageAnswer = in.nextLine();
        System.out.println();
        if(botRequestMessageAnswer.equalsIgnoreCase("Д")){
            isBotInGame = true;
            System.out.println(thanks);
        }else {
            System.out.println(noAnswer);
        }
        System.out.println();
        System.out.println(startMessage);

        new GameProcess().gaming(gamerCount, isBotInGame);
    }
}
