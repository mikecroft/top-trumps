package io.mikecroft;

import javax.enterprise.context.SessionScoped;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.mikecroft.model.Game;
import io.mikecroft.model.Hero;

@SessionScoped
@Path("/")
public class GameController {

    private Game game;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/new")
    public String newGame(@QueryParam("confirm") boolean confirm){
        
        if (game == null || confirm == true) {
            this.game = new Game();
        }

        return JsonbBuilder.create().toJson(this.game);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/duel")
    public String duel(@QueryParam("attribute") String attribute){
        
        if (attribute == null || (game.getPlayerDeck().size() == 0 || game.getOpponentDeck().size() == 0)) {
            return "{}";
        }

        String winner = null;

        Hero hero1 = game.getPlayerDeck().get(0);
        Hero hero2 = game.getOpponentDeck().get(0);

        switch (attribute.toUpperCase()){
            case "STRENGTH":
                
            case "MAGIC":
                winner = hero1.magic >= hero2.magic ? "PLAYER" : "OPPONENT";
                break;
            case "TELEKINESIS":
                winner = hero1.telekinesis >= hero2.telekinesis ? "PLAYER" : "OPPONENT";
                break;
            case "SPEED":
                winner = hero1.speed >= hero2.speed ? "PLAYER" : "OPPONENT";
                break;
            case "IQ":
                winner = hero1.iq >= hero2.iq ? "PLAYER" : "OPPONENT";
                break;
            default:
                return "{}";
        }

        if ( winner == "PLAYER"){
            game.getPlayerWins().add(hero1);
            game.getPlayerWins().add(hero2);
        } else {
            game.getOpponentWins().add(hero1);
            game.getOpponentWins().add(hero2);
        }

        game.getPlayerDeck().remove(0);
        game.getOpponentDeck().remove(0);

        return JsonbBuilder.create().toJson(winner);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/player/deck")
    public String getPlayerDeck(){
        String playerCards = game == null ? "{}" : JsonbBuilder.create().toJson(game.getPlayerDeck());
        return playerCards;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/player/wins")
    public String getPlayerWins(){
        String playerWins = game == null ? "{}" : JsonbBuilder.create().toJson(game.getPlayerWins());
        return playerWins;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/opponent/deck")
    public String getOpponentDeck(){
        String opponentCards = game == null ? "{}" : JsonbBuilder.create().toJson(game.getOpponentDeck());
        return opponentCards;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/opponent/wins")
    public String getOpponentWins(){
        String opponentWins = game == null ? "{}" : JsonbBuilder.create().toJson(game.getOpponentWins());
        return opponentWins;
    }

}