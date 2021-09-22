package io.mikecroft.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Hero> playerDeck = new ArrayList<Hero>();
    private final List<Hero> playerWins = new ArrayList<Hero>();
    private final List<Hero> opponentDeck = new ArrayList<Hero>();
    private final List<Hero> opponentWins = new ArrayList<Hero>();

    public Game(){
        List<Hero>  allCards = Hero.listAll();

        Collections.shuffle(allCards);

        int listSize = (allCards.size() % 2 == 0) ? allCards.size() : allCards.size() - 1;
        playerDeck.addAll(allCards.subList(0, (listSize / 2)));
        opponentDeck.addAll(allCards.subList(listSize / 2, listSize));
    }

    public String hello() {
        return "Hello RESTEasy";
    }

    public List<Hero> getPlayerDeck(){
        return playerDeck;
    }

    public List<Hero> getPlayerWins(){
        return playerWins;
    }

    public List<Hero> getOpponentDeck(){
        return opponentDeck;
    }
    
    public List<Hero> getOpponentWins(){
        return opponentWins;
    }
}