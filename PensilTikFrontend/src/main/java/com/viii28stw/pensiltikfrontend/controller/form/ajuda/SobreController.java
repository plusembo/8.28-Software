package com.viii28stw.pensiltikfrontend.controller.form.ajuda;

import com.viii28stw.pensiltikfrontend.controller.MDIController;
import com.viii28stw.pensiltikfrontend.enumeration.MenuEnum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

@NoArgsConstructor
public class SobreController implements Initializable {

    @FXML private Label lblVersao;
    @Setter private Stage sobreStage;
    private static SobreController uniqueInstance;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblVersao.setText("Versao");
    }

    public static synchronized SobreController getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SobreController();
        }
        return uniqueInstance;
    }

    @FXML
    private void jbtnFecharAction() {
        sobreStage.close();
        MDIController.fechaJanela(MenuEnum.AJUDA_SOBRE);
    }

}