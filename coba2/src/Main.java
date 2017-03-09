/**
 * Created by clyve on 24/01/17.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Main extends Application {
    private TableView<Student> table;

    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("UI Demo 1");

        BorderPane layout = new BorderPane();

        //menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New",imageFile("images/new.png"));
        newMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl + N"));
        fileMenu.getItems().add(newMenuItem);

        fileMenu.getItems().add(new SeparatorMenuItem());

        MenuItem exitMenuItem = new MenuItem("Exit",imageFile("images/exit.png"));
        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl + Q"));
        exitMenuItem.setOnAction( e -> System.exit(0) );
        fileMenu.getItems().add(exitMenuItem);

        menuBar.getMenus().add(fileMenu);

        //spreadsheet
        table = new TableView<>();
        //Todo: Add some data to our table
        table.setItems(DataSource.getAllStudents());

        TableColumn<Student,Integer> sidColumn = new TableColumn<>("SID");
        sidColumn.setMinWidth(100);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));

        TableColumn<Student,String> fnColumn = new TableColumn<>("First Name");
        fnColumn.setMinWidth(200);
        fnColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Student,String> lnColumn = new TableColumn<>("Last Name");
        lnColumn.setMinWidth(200);
        lnColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Student,Double> gpaColumn = new TableColumn<>("GPA");
        gpaColumn.setMinWidth(100);
        gpaColumn.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        table.getColumns().add(sidColumn);
        table.getColumns().add(fnColumn);
        table.getColumns().add(lnColumn);
        table.getColumns().add(gpaColumn);

        //add the components to the layout
        layout.setTop(menuBar);
        layout.setCenter(table);

        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView imageFile(String path){
        return new ImageView (new Image("file:" + path));
    }

    public static void main(String[] args){
        launch(args);
    }
}
