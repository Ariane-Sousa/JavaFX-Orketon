package login;

import conexao.Conexao;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLLoginController implements Initializable {
    
    @FXML private TextField tfEmail;
    @FXML private PasswordField pwSenha;
    @FXML private Label mensagemErro;
    @FXML private Button maximizar;
    
    @FXML
    private void fechar(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void entrar(ActionEvent event){
        String email = tfEmail.getText();
        String senha = pwSenha.getText();
        if((email.isEmpty()) || (senha.isEmpty())){
            mensagemErro.setText("Preencha os campos!");
        } else {
            try {
                Connection con = Conexao.faz_conexao();
                String sql = "select email, senha from candidato where email = ? and senha = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, senha);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/home/Home.fxml")));
                    stage.setScene(scene);
                    stage.show();
                } else {
                    mensagemErro.setText("E-mail ou senha incorreto!");
                }
            } catch (Exception e) {
                System.out.println("Erro:" + e);
            }
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
