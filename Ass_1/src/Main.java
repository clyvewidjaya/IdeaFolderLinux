import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by clyve on 09/02/17.
 */
public class Main extends Application {
    private TableView<TestFile> table;

    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("SPAM MASTER");

        BorderPane layout = new BorderPane();

        table = new TableView<>();
        table.setItems(DataSource.getResult());

        TableColumn<TestFile,String> fileNameColumn = new TableColumn<>("File");
        fileNameColumn.setMinWidth(100);
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("filename");

        TableColumn<TestFile,String> actualClassColumn = new TableColumn<>("Actual Class");
        actualClassColumn.setMinWidth(100);
        actualClassColumn.setCellValueFactory(new PropertyValueFactory<>("actualClass");

        TableColumn<TestFile,Double> spamProbColumn = new TableColumn<>("Spam Probability");
        spamProbColumn.setMinWidth(100);
        spamProbColumn.setCellValueFactory(new PropertyValueFactory<>("spamProbability");

        table.getColumns().add(fileNameColumn);
        table.getColumns().add(actualClassColumn);
        table.getColumns().add(spamProbColumn);

        layout.setCenter(table);

        Scene scene = new Scene(layout, 600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}
