
package sistema.modelo;

public class LoginM {
    
    private int id;
    private String user;
    private String password;

    private static LoginM User;
    
    public LoginM(){

    }
    
    public static LoginM getInstance(){
        
        if(User == null){
            User = new LoginM();
        }
        
        return User;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
