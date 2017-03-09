package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TreeView<String> projectTreeView;
    @FXML private TextArea editor;

    public void initialize(){
        TreeItem<String> rootItem = new TreeItem<>("Project");
        rootItem.setExpanded(true);

        TreeItem<String> src = new TreeItem<>("src");
        src.setExpanded(true);
        rootItem.getChildren().add(src);

        TreeItem<String> main = new TreeItem<>("main");
        main.setExpanded(true);
        src.getChildren().add(main);

        TreeItem<String> java = new TreeItem<>("java");
        java.setExpanded(true);
        main.getChildren().add(java);

        TreeItem<String> sourceFile = new TreeItem<>("HelloWorld.java");
        java.getChildren().add(sourceFile);

        TreeItem<String> gradleFile = new TreeItem<>("build.gradle");
        rootItem.getChildren().add(gradleFile);

        projectTreeView.setRoot(rootItem);

        //add this controller as an event handler
        ChangeListener listener = new ChangeListener(){
            @Override
            public void changed(ObservableValue observable,
                                Object previousValue,
                                Object currentValue){
                TreeItem<String> selectedItem = (TreeItem<String>)currentValue;
                if (selectedItem.getValue().equals("HelloWorld.java")) {
                    editor.setText(
                            "public class HelloWorld{\n" +
                            "\tpublic static void main(String[] args){\n" +
                            "\t\tSystem.out.println(\"Hello,world! Im Clyve\");\n" +
                            "\t}\n" +
                            "}\n"
                    );
                } else if (selectedItem.getValue().equals("build.gradle")){
                    editor.setText("apply plugin: 'java'");
                }
            }
        };

        projectTreeView.getSelectionModel().selectedItemProperty().addListener(listener);
    }

    public void login(ActionEvent event){
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Login(), username = " + username + ", password = " + password);
    }
}
