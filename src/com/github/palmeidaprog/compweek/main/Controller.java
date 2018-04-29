/*
 * @author Paulo Roberto Almeida Filho
 * @email palmeidaprogramming@gmail.com
 * @site http://www.github.com/palmeidaprog/compweek
 */

package com.github.palmeidaprog.compweek.main;

import com.github.palmeidaprog.compweek.inscritos.ControllerInscrito;
import com.github.palmeidaprog.compweek.inscritos.Inscrito;
import com.github.palmeidaprog.compweek.inscritos.NotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.*;


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
    private Button saveBtn, criarBtn, editBtn, gerarBtn;
    private Inscrito active;

    public void criarBtnClick() {
        criarBtn.setDisable(true);
        editBtn.setDisable(false);
        enableCenterFields(true);
        saveBtn.setText("Criar");
        active = null;
        limpaCampos();
    }

    public void editBtnClick() {
        criarBtn.setDisable(false);
        editBtn.setDisable(true);
        enableCenterFields(false);
        limpaCampos();
        active = null;
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

    public void saveBtnClick() {
        ControllerInscrito inscritos = new ControllerInscrito();
        if(saveBtn.getText().equals("Procurar")) {
            try {
                active = inscritos.get(matrText.getText());
                show(active);
                enableCenterFields(true);
                saveBtn.setText("Salvar");
            } catch(NotFoundException e) {
                showDialog("Não encontrado", e.getMessage());
            }
        } else if(saveBtn.getText().equals("Criar")) {
            if(inscritos.isInscrito(matrText.getText())) {
                showDialog("Já inscrito", "Matricula já inscrita!"
                    );
                matrText.requestFocus();
                return ;
            }

            Inscrito inscrito = new Inscrito(nomeText.getText(), matrText
                    .getText(), cursoText.getText());
            getData(inscrito);
            inscritos.adicionar(inscrito);
            limpaCampos();
        } else {
            getData(active);
            limpaCampos();
            active = null;
            enableCenterFields(false);
            inscritos.update();
            saveBtn.setText("Procurar");
        }
    }

    private void limpaCampos() {
        matrText.setText(null);
        nomeText.setText(null);
        cursoText.setText(null);
        fraldasCheck.setSelected(false);
        machineText.setText("0");
        reactText.setText("0");
        competText.setText("0");
        modelText.setText("0");
        pythonText.setText("0");
        iaText.setText("0");
        unityText.setText("0");
        gameText.setText("0");
    }

    private void getData(Inscrito inscrito) {
        inscrito.setMatricula(matrText.getText());
        inscrito.setCurso(cursoText.getText());
        inscrito.setNome(nomeText.getText());
        inscrito.setFralda(fraldasCheck.isSelected());
        inscrito.sethMachine(Double.parseDouble(machineText.getText()));
        inscrito.sethReact(Double.parseDouble(reactText.getText()));
        inscrito.sethCompeticao(Double.parseDouble(competText.getText()));
        inscrito.sethModelagem(Double.parseDouble(modelText.getText()));
        inscrito.sethPython(Double.parseDouble(pythonText.getText()));
        inscrito.sethIA(Double.parseDouble(iaText.getText()));
        inscrito.sethUnity(Double.parseDouble(unityText.getText()));
        inscrito.sethGame(Double.parseDouble(gameText.getText()));
    }

    private void show(Inscrito inscrito) {
        matrText.setText(inscrito.getMatricula());
        nomeText.setText(inscrito.getNome());
        cursoText.setText(inscrito.getCurso());
        fraldasCheck.setSelected(inscrito.isFralda());
        machineText.setText(Double.toString(inscrito.gethMachine()));
        reactText.setText(Double.toString(inscrito.gethReact()));
        competText.setText(Double.toString(inscrito.gethCompeticao()));
        modelText.setText(Double.toString(inscrito.gethModelagem()));
        pythonText.setText(Double.toString(inscrito.gethPython()));
        iaText.setText(Double.toString(inscrito.gethIA()));
        unityText.setText(Double.toString(inscrito.gethUnity()));
        gameText.setText(Double.toString(inscrito.gethGame()));
    }

    private void showDialog(String title, String body) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(body);
        dialog.showAndWait();
    }

    public void geraCsv() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir vídeo escolhido");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos Arquivos", "*.*"),
                new FileChooser.ExtensionFilter("Arquivos PDF", "*.pdf"));
        fileChooser.setInitialFileName("ICC.pdf");
        String selectedFile = fileChooser.showSaveDialog(Main.primaryStage).toString();

        //File openFile = new File(selectedDir + "/ICC.pdf");
        File openFile = new File(selectedFile);
    }

}
