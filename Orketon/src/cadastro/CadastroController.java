package cadastro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML private AnchorPane criaConta;
    @FXML private AnchorPane cadastro;

    @FXML private Button fechar;

    @FXML
    private void fechar(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void criaConta(ActionEvent event){
        criaConta.toFront();
        fechar.toFront();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
