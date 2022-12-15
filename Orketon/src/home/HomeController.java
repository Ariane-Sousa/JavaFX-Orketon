package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML private AnchorPane dashboard;
    @FXML private Button fechar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dashboard.toFront();
    }

    @FXML
    private void fechar(ActionEvent event){
        System.exit(0);
    }
}
