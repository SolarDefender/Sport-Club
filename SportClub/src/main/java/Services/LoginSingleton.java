package Services;

import Models.Person;

public class LoginSingleton {
    private static Person currentUser;

    private LoginSingleton() {

    }
    public static void signOut(){
        currentUser=null;
    }

    public static Person getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Person currentUser) {
        LoginSingleton.currentUser = currentUser;
    }
}
