/*
 * @author Paulo Roberto Almeida Filho
 * @email palmeidaprogramming@gmail.com
 * @site http://www.github.com/palmeidaprog/compweek
 */

package com.github.palmeidaprog.compweek.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private Label matrLbl, nomeLbl, cursoLbl, horasLbl, machineLbl, reactLbl;
    @FXML
    private CheckBox fraldasCheck;
    @FXML
    private TextField matrText, nomeText, cursoText, machineText, reactText;
    @FXML
    private Label competLbl, modelLbl, pythonLbl, iaLbl, unity, gameLbl;
    @FXML
    private TextField competText, modelText, pythonText, iaText, unityText;
    @FXML
    private TextField gameText;
    @FXML
    private Button saveBtn, criarBtn, editBtn;

    public void criarBtnClick() {
        criarBtn.setDisable(true);
        editBtn.setDisable(false);
        enableCenterFields(true);
        saveBtn.setText("Criar");

    }

    public void editBtnClick() {
        criarBtn.setDisable(false);
        editBtn.setDisable(true);
        enableCenterFields(false);
        saveBtn.setText("Procurar");
    }

    private void enableCenterFields(boolean value) {
        nomeText.setDisable(!value);
        cursoText.setDisable(!value);
        machineText.setDisable(!value);
        reactText.setDisable(!value);
        gameText.setDisable(!value);
        nomeLbl.setDisable(!value);
        cursoLbl.setDisable(!value);
        horasLbl.setDisable(!value);
        machineLbl.setDisable(!value);
        reactLbl.setDisable(!value);
        fraldasCheck.setDisable(!value);
        competLbl.setDisable(!value);
        modelLbl.setDisable(!value);
        pythonLbl.setDisable(!value);
        iaLbl.setDisable(!value);
        unity.setDisable(!value);
        gameLbl.setDisable(!value);
        competText.setDisable(!value);
        modelText.setDisable(!value);
        pythonText.setDisable(!value);
        iaText.setDisable(!value);
        unityText.setDisable(!value);
    }



}
