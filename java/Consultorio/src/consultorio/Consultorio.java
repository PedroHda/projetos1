package consultorio;

public class Consultorio {
    // Members
    private static int role = 0;

    // Constructor
    public Consultorio(){
        // Not defined yet
    }

    // Getters and Setters
    public static int getRole() {
        return role;
    }
    public void setRole(int pRole) {
        this.role = pRole;
    }

    // Main method, to init the project
    public static void main(String[] args) {
        
        Consultorio consul = new Consultorio();
        
        // Init login screen
        LoginSenha telaLogin = new LoginSenha();
        while (telaLogin.getRole() == 0)
        {
            telaLogin.setVisible(true);
        }
        
        consul.setRole(telaLogin.getRole());
        if (consul.getRole() > 0)
        {
            // Init main screen
            mainTela telaMain = new mainTela();
            telaLogin.dispose();
            telaMain.setVisible(true);
        }
    }
    
}
