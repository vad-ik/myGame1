package com.mygdx.game.net;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;
import com.mygdx.game.Screen;
import jdk.internal.org.jline.utils.Log;

import java.io.IOException;

public class GameClient extends Client {

    public Player pLayer;
    public Player[] players;

    public GameClient() {
        super();
        start();
        pLayer=new Player();
        players = new Player[0];
        Network.registor(this);
        addListener(new Listener(){
            @Override
            public void connected(Connection connection) {
    Network.RegisterPlayer registerPlayer = new Network.RegisterPlayer(pLayer);
    sendTCP(registerPlayer);
            }

            @Override
            public void disconnected(Connection connection) {
                super.disconnected(connection);
            }

            @Override
            public void received(Connection connection, Object object) {
             if (object instanceof  Network.UpdatePlayer){
                 Player[] newPLayers=( (Network.UpdatePlayer) object ).players ;
             }

                 Player newPlayer =((Network.MovePlayer)object).player;
                 for (int i = 0; i < players.length; i++) {
                     if (players[i].nameText.equals(newPlayer.nameText)){
                         players[i]=newPlayer;
                         break;
                     }
                 }


            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    connect(5000,Network.host,Network.port);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

public void move (){
if (true){

Network.MovePlayer movePlayer =new Network.MovePlayer(pLayer);
sendTCP(movePlayer);
}
}
}
