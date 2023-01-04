package com.ailliushchenia;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class GameProcess {
    private final String cityStartRequestMsg = "Игрок %d, введи название любого города:";
    private final String cityRequestMsg = "Игрок %d, введи название города на букву \"%s\":";
    private final String errorMsg = "Немного ошибся. Город начинается с буквы \"%s\".";
    private final String exitRequest = "Выйти";
    private final String goodBueMsg = "Здорово поиграли! Пока!";
    private boolean isExit = false;
    private String cityLetter = "";
    public void gaming(int gamerCount, boolean isBotInGame){
        while (true){
            Scanner in = new Scanner(System.in);
            for(int i = 1; i <= gamerCount; i++){
                if(!cityLetter.equals("")) {
                    System.out.println(String.format(cityRequestMsg, i, cityLetter));
                }else {
                    System.out.println(String.format(cityStartRequestMsg, i));
                }
                String cityName = in.nextLine().toUpperCase();
                if(cityName.equals(exitRequest.toUpperCase())){
                    isExit = true;
                    break;
                }
                if(!cityLetter.equals("") && !cityName.startsWith(cityLetter)){
                    System.out.println(String.format(errorMsg, cityName.substring(0,1).toUpperCase()));
                    i--;
                    continue;
                }
                cityLetter = cityName.substring(cityName.length() - 1).toUpperCase();
            }
            if(isExit){
                System.out.println(goodBueMsg);
                break;
            }
        }
    }
}
