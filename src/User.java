/**
 * Helper class to keep track of Name, connection status, time of creation, and duration of connection
 *
 * Authors: Gehrig Wilcox
 * */
public class User {

    final String NAME;
    final long connectionTime;

    boolean isConnected;
    long connectionDuration;


    public User(String name, boolean isConnected, long connectionTime, long connectionDuration){
        this.NAME = name;
        this.isConnected = isConnected;
        this.connectionTime = connectionTime;
        this.connectionDuration = connectionDuration;
    }

    public User(String name){
        this(name,true,System.currentTimeMillis(),0);
    }

    public User(){
        this(null);
    }

    public void disconnect(){
        if(!this.isConnected) return;
        this.isConnected = false;
        this.connectionDuration = System.currentTimeMillis() - this.connectionTime;
    }

    public String getName(){
        return this.NAME;
    }

    public boolean getIsConnected(){
        return this.isConnected;
    }

    public long getConnectionTime(){
        return this.connectionTime;
    }

    public long getConnectionDuration(){
        if(this.isConnected) return System.currentTimeMillis() - this.connectionTime;
        return this.connectionDuration;
    }
}
