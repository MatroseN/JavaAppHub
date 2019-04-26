package Default;

public class ActiveUser {
    public ActiveUser(String username){
        this.activeUserUserName = username;
    }

    public String getActiveUserUserName(){
        return activeUserUserName;
    }

    private String activeUserUserName;
}
