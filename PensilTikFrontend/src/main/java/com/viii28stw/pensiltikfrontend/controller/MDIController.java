package com.viii28stw.pensiltikfrontend.controller;

import com.viii28stw.pensiltikfrontend.controller.form.cadastro.CadastroUsuarioController;
import com.viii28stw.pensiltikfrontend.model.domain.Sessao;
import com.viii28stw.pensiltikfrontend.MainApp;
import com.viii28stw.pensiltikfrontend.controller.form.ajuda.SobreController;
import com.viii28stw.pensiltikfrontend.enumeration.MenuEnum;
import com.viii28stw.pensiltikfrontend.model.domain.FormMenu;
import com.viii28stw.pensiltikfrontend.util.CentralizeLocationRelativeToScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Plamedi L. Lusembo
 */

@NoArgsConstructor
public class MDIController implements Initializable {

    @Setter
    private Stage mdiStage;
    private static HashMap<MenuEnum, FormMenu> listFormsMenu;
    @FXML
    private Hyperlink hlkNomeUsuario;
    @FXML
    private ImageView imgvwLogoVergo;
    @FXML
    private Label lblDataHora;

    @FXML
    private Menu mnConfiguracoes;
    @FXML
    private Menu mnCadastro;

    private Sessao usuarioLogado;

    private static MDIController uniqueInstance;

    public static synchronized MDIController getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MDIController();
        }
        return uniqueInstance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblDataHora.setText("");
        listFormsMenu = new HashMap<>();
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaDataHora());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        imgvwLogoVergo.setX(180);
        imgvwLogoVergo.setY(50);
    }

    private void atualizaDataHora() {
        Locale.setDefault(new Locale("pt", "BR"));
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE',' dd/MM/yyyy HH:mm:ss");
        String dataHora = sdf.format(Calendar.getInstance().getTime());
        lblDataHora.setText(dataHora.substring(0,1).toUpperCase().concat(dataHora.substring(1)));
    }

//    private double calculaX(double w) {
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension dm = tk.getScreenSize();
//        return (dm.width - w) / 2.0;
//    }
//
//    private double calculaY(double h) {
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension dm = tk.getScreenSize();
//        return (dm.height - h) / 2.0;
//    }

    @FXML
    private void mnuConfiguracaoContaUsuarioAction() {
        abreForm(MenuEnum.CONFIGURACOES_CONTA_USUARIO,
                "configuracao-conta-usuario.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(627),
                CentralizeLocationRelativeToScreen.getY(485));
    }

    @FXML
    private void mnuCadastroTipoRendaAction() {
        abreForm(MenuEnum.CADASTRO_TIPO_RENDA,
                "cadastro-tipo-renda.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(627),
                CentralizeLocationRelativeToScreen.getY(562));
    }

    @FXML
    private void mnuCadastroRendaAction() {
        abreForm(MenuEnum.CADASTRO_RENDA,
                "cadastro-renda.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(1207),
                CentralizeLocationRelativeToScreen.getY(614));
    }

    @FXML
    private void mnuCadastroTipoDespesaAction() {
        abreForm(MenuEnum.CADASTRO_TIPO_DESPESA,
                "cadastro-tipo-despesa.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(627),
                CentralizeLocationRelativeToScreen.getY(533));
    }

    @FXML
    private void mnuCadastroDespesaAction() {
        abreForm(MenuEnum.CADASTRO_DESPESA,
                "cadastro-despesa.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(627),
                CentralizeLocationRelativeToScreen.getY(439));
    }

    @FXML
    private void mnuCadastroUsuarioAction() {
        abreForm(MenuEnum.CADASTRO_USUARIO,
                "/fxml/form/cadastro/cadastro_usuario.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(700),
                CentralizeLocationRelativeToScreen.getY(500));
    }

    @FXML
    private void mnuRelatorioRendaAction() {
        abreForm(MenuEnum.RELATORIO_RENDA,
                "relatorio-renda.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(650),
                CentralizeLocationRelativeToScreen.getY(600));
    }

    @FXML
    private void mnuRelatorioDespesasAction() {
        abreForm(MenuEnum.RELATORIO_DESPESAS,
                "relatorio-despesas.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(670),
                CentralizeLocationRelativeToScreen.getY(289));
    }

    @FXML
    private void mnuAjudaSobreAction() {
        abreForm(MenuEnum.AJUDA_SOBRE,
                "/fxml/form/ajuda/sobre.fxml",
                null,
                CentralizeLocationRelativeToScreen.getX(670),
                CentralizeLocationRelativeToScreen.getY(289));
    }

    //--- *** ----- ### ----- *** ---
    @FXML
    private void hlkSairOnAction() {
        mdiStage.close();
    }

    private void abreForm(MenuEnum menum, String arquivofxml, String icone, double x, double y) {
        boolean aberto = false;
        try {
            if(listFormsMenu.containsKey(menum)) {
                aberto = true;
                listFormsMenu.get(menum).getStage().toFront();
            }

            if (!aberto) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(arquivofxml));
                StackPane parent = loader.load();

                Stage formStage = new Stage();
                formStage.initOwner(hlkNomeUsuario.getScene().getWindow());
                formStage.setResizable(false);
                formStage.setMaximized(false);
                formStage.initModality(menum.equals(MenuEnum.AJUDA_SOBRE) ? Modality.APPLICATION_MODAL : Modality.NONE);
                formStage.setTitle(menum.getTitulo());
                if (icone != null && !icone.equals("")) { formStage.getIcons().add(new Image(icone)); }
                if (x != 0) { formStage.setX(x); }
                if (y != 0) { formStage.setY(y); }

                Scene scene = new Scene(parent);
                formStage.setScene(scene);

                formStage.setOnCloseRequest((WindowEvent we) -> fechaJanela(menum));

                listFormsMenu.put(menum, new FormMenu(menum, formStage));

                //Flexible zone begining
                switch (menum) {
//
//                    case CONFIGURACOES_CONTA_USUARIO: {
//                        ConfiguracaoContaUsuarioController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//
//                    case CADASTRO_PECA: {
//                        CadastroPecaSimplesController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//                    case CADASTRO_MONTAGEM: {
//                        CadastroMontagemPecaController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//                    case CADASTRO_UNIDADE_MEDIDA: {
//                        CadastroUnidadeMedidaController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//
//                    case CADASTRO_MAO_OBRA: {
//                        CadastroMaoDeObraController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//
//                    case CADASTRO_GRUPO_USUARIO: {
//                        CadastroGrupoUsuarioController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//
                    case CADASTRO_USUARIO: {
                        CadastroUsuarioController controller = loader.getController();
                        controller.setCadastroUsuarioStage(formStage);
                        break;
                    }
//
//                    case RELATORIO_PECAS: {
//                        RelatorioPecaController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//                    case RELATORIO_MONTAGEM_PECA: {
//                        RelatorioMontagemPecaController controller = loader.getController();
//                        controller.setFormStage(formStage);
//                        break;
//                    }
//
                    case AJUDA_SOBRE: {
                        SobreController controller = loader.getController();
                        controller.setSobreStage(formStage);
                        break;
                    }
//
                    default:
                        break;
                }
                //Flexible zone final

                formStage.showAndWait();

                if (usuarioLogado.isRequerLogout()) {
                    hlkSairOnAction();
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MDIController.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public static void fechaJanela(MenuEnum menum) {
        if(listFormsMenu.containsKey(menum)) {
            listFormsMenu.remove(menum);
        }

    }

}
