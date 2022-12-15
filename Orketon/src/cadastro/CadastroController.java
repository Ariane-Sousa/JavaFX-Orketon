package cadastro;

import candidato.Candidato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML private AnchorPane criaConta;
    @FXML private AnchorPane cadastro;
    @FXML private Button fechar;
    @FXML private TextField tfNome;
    @FXML private TextField tfEmail;
    @FXML private TextField tfConfirmaEmail;
    @FXML private PasswordField pwSenha;
    @FXML private PasswordField pwConfirmaSenha;
    @FXML private DatePicker dpDataNascimento;
    @FXML private TextField tfCpf;
    @FXML private TextField tfTelefone;
    @FXML private Label mensagemErro1;
    @FXML private Label mensagemErro;
    @FXML private Button voltar;
    @FXML private Button voltarLogin;

    @FXML
    private void fechar(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void voltar(ActionEvent event){
        cadastro.toFront();
    }

    @FXML
    private void voltarLogin(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/login/Login.fxml")));
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void passosCriaConta(ActionEvent event){
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String confirmaEmail = tfConfirmaEmail.getText();
        String senha = pwSenha.getText();
        String confirmaSenha = pwConfirmaSenha.getText();
        if((nome.isEmpty()) || (email.isEmpty()) || (confirmaSenha.isEmpty()) || (senha.isEmpty()) || (confirmaEmail.isEmpty())){
            mensagemErro.setText("Preencha todos os campos!");
        } else {
            if(email.equals(confirmaEmail) && senha.equals(confirmaSenha)) {
                criaConta.toFront();
                fechar.toFront();
            } else {
                mensagemErro.setText("E-mail ou senha não corresponde!!");
            }
        }

    }

    @FXML
    private void criaConta(ActionEvent event) throws IOException{
        Date data_nascimento = Date.valueOf(dpDataNascimento.getValue());
        String data_nasc = String.valueOf(data_nascimento);
        String cpf = tfCpf.getText();
        String telefone = tfTelefone.getText();
        if((data_nasc.isEmpty()) || (cpf.isEmpty()) || telefone.isEmpty()){
            mensagemErro1.setText("Preencha todos os campos");
        } else {
            Candidato c1 = new Candidato();
            c1.setNome(tfNome.getText());
            c1.setEmail(tfEmail.getText());
            c1.setSenha(pwSenha.getText());
            c1.setData_nascimento(Date.valueOf(dpDataNascimento.getValue()));
            c1.setCpf(tfCpf.getText());
            c1.setTelefone(tfTelefone.getText());
            c1.fazLogin();
            if(c1.getStatus() == true){
                Alert Dialogs = new Alert(Alert.AlertType.INFORMATION);
                Dialogs.setTitle(null);
                Dialogs.setHeaderText(null);
                Dialogs.setContentText("Cadastrado com sucesso. Voltando para a tela de Login!");
                Dialogs.showAndWait();
                //Abre tela Home
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/login/Login.fxml")));
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastro.toFront();
    }

}
