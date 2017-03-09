//Joseph Robertson
package sample;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.net.Socket;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));

        final int port=1234;
        GridPane base=new GridPane();
        base.setPadding(new Insets(10,10,10,10));
        base.setVgap(10);
        base.setHgap(10);

        Label userNameP=new Label("UserName:");
        Label messageP=new Label("Message:");
        Label IPP=new Label("IP:");
        final TextField userName=new TextField();
        final TextField message=new TextField();
        final TextField IPBox=new TextField("10.160.19.222");
        Button send=new Button("send");
        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String IP=IPBox.getText();
                    //System.out.println((InetAddress.getLocalHost()+"").split("/")[1]);
                    Socket socket = new Socket(IP, port);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(userName.getText() + ": " + message.getText());
                    socket.close();
                }
                catch (Exception e){
                    System.err.println(e);
                }
            }
        });
        Button exit=new Button("exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));

        base.add(userNameP,0,0);
        base.add(userName,1,0);
        base.add(messageP,0,1);
        base.add(message,1,1);
        base.add(IPP,0,2);
        base.add(IPBox,1,2);
        base.add(send,0,3);
        base.add(exit,0,4);

        BorderPane layout=new BorderPane();
        layout.setBottom(base);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
