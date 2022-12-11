package cadastro;

import candidato.Candidato;
import conexao.Conexao;
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
import java.sql.Connection;
import java.time.LocalDate;
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



    @FXML
    private void fechar(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void passosCriaConta(ActionEvent event){
        criaConta.toFront();
        fechar.toFront();
    }

    @FXML
    private void criaConta(ActionEvent event) throws IOException{
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cadastro.toFront();
    }

}
