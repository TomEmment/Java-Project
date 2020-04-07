
package farmerclientserver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogInScreen extends javax.swing.JFrame {

    public LogInScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        New_Username = new javax.swing.JTextField();
        New_Password = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        Create_User = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();

        jLabel5.setText("Password:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login.setText("Log in");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        Create_User.setText("Create User");
        Create_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_UserActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel4.setText("Password:");

        jLabel6.setText("New Username:");

        jLabel7.setText("New Password:");

        Password.setText("jPasswordField1");
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(New_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(New_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Login)
                            .addComponent(Create_User, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Login))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(New_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(New_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Create_User)))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        String name =String.valueOf(Username.getText());
        String pass = String.valueOf(Password.getPassword());
        boolean Success = Log_in(name,pass);
        if(Success){
            setVisible(false); 
            dispose(); 
            System.out.println("Oppening information window");
            DataDisplayScreen Instance = new DataDisplayScreen();
            Instance.setVisible(true);
        }
        
    }//GEN-LAST:event_LoginActionPerformed

    private void Create_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create_UserActionPerformed
        String name =String.valueOf(Username.getText());
        String pass = String.valueOf(Password.getPassword());
        String new_name =String.valueOf(New_Username.getText());
        String new_pass =String.valueOf(New_Password.getText());
        boolean Success = New_User(name,pass,new_name,new_pass);
        if(Success){
            setVisible(false); 
            dispose(); 
            System.out.println("Oppening information window");
            DataDisplayScreen Instance = new DataDisplayScreen();
            Instance.setVisible(true);
        }
    }//GEN-LAST:event_Create_UserActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInScreen().setVisible(true);
            }
        });
    }
    public static boolean Log_in(String Username, String Password){
        List<String> Userdata;
        Userdata = GetUsers();
        int size = Userdata.size()-1;
        boolean Present = false;
        while (size >= 1){
            System.out.println(Userdata.get(size-1));
            System.out.println(Username);
            if ((Userdata.get(size).equals(Password))&&(Userdata.get(size-1).equals(Username))){
                Present = true;
                System.out.println("User found");
            }
            size = size -2;
        }
        if (Present == false){
            System.out.println("Not User");
        }
        return Present;
    }
    public static boolean New_User(String Username, String Password,String New_Username, String New_Password){
        boolean Present ;
        Present = Log_in(Username, Password);
        if(Present){
            AddUser(New_Username, New_Password);
            return true;
        }else{
            System.out.println("Could not add new user");
            return false;
        }
    }
    public static void AddUser(String New_Username, String New_Password){
        boolean User_Already_Present = Log_in(New_Username, New_Password);
        if (User_Already_Present){
            System.out.println("Unable to add new user as already exists");
        }
        else{
        try{
            FileWriter fout = new FileWriter("Admin.txt",true);
            BufferedWriter x = new BufferedWriter(fout);
            PrintWriter pout = new PrintWriter(x);
            pout.println(New_Username);
            pout.println(New_Password);
            pout.close();
            x.close();
            fout.close();
            System.out.println("New User added!");
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }
    }
    }
    public static List<String> GetUsers(){
        List<String> Userdata = new ArrayList<String>();
        try{
            Path path = Paths.get("Admin.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                Userdata.add(line);

            }
            scanner.close();
            System.out.println("Data collected");
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }
        return Userdata;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create_User;
    private javax.swing.JButton Login;
    private javax.swing.JTextField New_Password;
    private javax.swing.JTextField New_Username;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
