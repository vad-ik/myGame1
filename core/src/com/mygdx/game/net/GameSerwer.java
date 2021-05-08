package com.mygdx.game.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.mygdx.game.Player;
import com.mygdx.game.net.utils.GameConnection;

import java.io.IOException;
import java.nio.channels.NonReadableChannelException;

public class GameSerwer extends Server {
    public GameSerwer() throws IOException {
        super();
        Network.registor(this);
        addListener(new Listener(){


            @Override
            public void received(Connection connection, Object object) {
if (!( connection instanceof GameConnection )){

    return;
}if (object instanceof Network.RegisterPlayer){
                    ( (GameConnection) connection ).player= ((Network.RegisterPlayer)object).player;
                    Player[] players= new  Player[getConnections().length];
                    for (int i = 0; i < players.length; i++) {
                        players[i]=((GameConnection)getConnections()[i]).player;
                    }

Network.UpdatePlayer updatePlayer = new Network.UpdatePlayer(players);
                    sendToAllTCP(updatePlayer);
                }
                if (object instanceof Network.MovePlayer){
                  sendToAllTCP(object);
                }

            }


        });
bind(Network.port);
start();
    }


    public static void main(String[] args) throws IOException {
        new GameSerwer();
    }




}
