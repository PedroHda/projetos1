package consultorio;

public class Consultorio {
    private static int role = 0;

    public static int getRole() {
        return role;
    }

    public void setRole(int pRole) {
        this.role = pRole;
    }

    public static void main(String[] args) {
        Consultorio consul = new Consultorio();
        LoginSenha telaLogin = new LoginSenha();
        while (telaLogin.getRole() == 0)
        {
            telaLogin.setVisible(true);
        }
        
        consul.setRole(telaLogin.getRole());
        if (consul.getRole() > 0)
        {
            mainTela telaMain = new mainTela();
            telaLogin.dispose();
            telaMain.setVisible(true);
        }
    }
    
}
