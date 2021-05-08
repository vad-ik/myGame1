package com.mygdx.game.net;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.mygdx.game.Player;

public class Network {
    public static final String host ="localhost";
    public static final  int port = 5000;

public static void registor(EndPoint endPoint){
    Kryo kryo = endPoint.getKryo();
    kryo.register(Player.class);
    kryo.register(Player[].class);



}
static public class RegisterPlayer{
    public  Player player;

    public RegisterPlayer() {
    }

    public RegisterPlayer(Player player) {
        this.player = player;
    }
}
    static public class UpdatePlayer{
       public Player[] players;

        public UpdatePlayer() {
        }

        public UpdatePlayer(Player[] player) {
            this.players = player;
        }
    }
    static public class MovePlayer{
       public Player player;

        public MovePlayer() {
        }

        public MovePlayer(Player player) {
            this.player = player;
        }
    }



}
