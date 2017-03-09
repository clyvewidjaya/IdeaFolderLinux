import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * Created by clyve on 24/01/17.
 */
public class DataSource {
    public static ObservableList<Student> getAllStudents(){
        ObservableList<Student> list = FXCollections.observableArrayList();

        list.add(new Student(100590208, "Clyve", "Widjaya",3.57));

        return list;
    }
}
