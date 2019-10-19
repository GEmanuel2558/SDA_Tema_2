package ui.login;

import com.google.common.hash.Hashing;
import dao.repositorys.PermissionCheckerDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modules.UserEntity;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class LoginView {
    @FXML
    private TextField textFieldPassword;
    @FXML
    private TextField editTextUserName;
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonReset;
    @FXML
    private Label labelCredentialsStatus;

    private PermissionCheckerDao credentialHelper = new PermissionCheckerDao();

    public void loginFunction() {
        //editTextUserName.getStyleClass().clear();
        //textFieldPassword.getStyleClass().clear();
        String userInput = editTextUserName.getText();
        String passInput = textFieldPassword.getText();
        if (userInput.trim().isEmpty()) {
            editTextUserName.getStyleClass().add("-fx-border-color: red; -fx-border-width: 2px ;");
            return;
        }
        if (passInput.trim().isEmpty()) {
            textFieldPassword.getStyleClass().add("-fx-border-color: red; -fx-border-width: 2px ;");
            return;
        }
        Optional<UserEntity> isUserValid = credentialHelper.findUserByNameAndPassword(userInput, Hashing.sha256().hashString(passInput, StandardCharsets.UTF_8).toString());
        labelCredentialsStatus.getStyleClass().clear();
        labelCredentialsStatus.setVisible(true);
        if (isUserValid.isPresent()) {
            labelCredentialsStatus.setText("Credentials are valid");
            labelCredentialsStatus.getStyleClass().add("-fx-text-fill: white;");
        } else {
            labelCredentialsStatus.setText("Credentials are invalid");
            labelCredentialsStatus.getStyleClass().add("-fx-text-fill: red;");
        }
    }

}
