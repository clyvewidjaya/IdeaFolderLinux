import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by clyve on 31/01/17.
 */
public class Main extends Application{
    private Canvas canvas;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root,500,400, Color.BLACK);

        canvas = new Canvas();
        //canvas.widthProperty().bind(primaryStage.widthProperty());
        //canvas.heightProperty().bind(primaryStage.heightProperty());

        canvas.setHeight(400);
        canvas.setWidth(500);

        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("UI Demo - 2D Graphics");
        primaryStage.show();

        draw(root);

        setupAnimation();

    }

    private void draw(Group root){
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        //Line
        //gc.setStroke(Color.BLUE);
        //gc.strokeLine(50,50,150,250);

        //Rectangle
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.fillRect(200,350, 100, 75);
        gc.strokeRect(250,175,100,75);
/*
        //Rounded Rectangle
        gc.setFill(Color.BEIGE);
        gc.setStroke(Color.BEIGE);
        gc.fillRoundRect(450,50,100,75,10,10);
        gc.strokeRoundRect(450,175,100,75,20,20);

        //Ellipses
        gc.setFill(Color.CORAL);
        gc.setStroke(Color.CORAL);
        gc.strokeOval(650,50,100,75);
        gc.fillOval(650,175,100,75);

        //Arcs
        gc.setFill(Color.DARKCYAN);
        gc.setStroke(Color.DARKCYAN);
        gc.strokeArc(50,350,100,75,0,115, ArcType.CHORD);
        gc.fillArc(50,500,100,75,115,140, ArcType.CHORD);

        //Polygons
        gc.setFill(Color.color(0.8,0.0,0.3,0.5));
        gc.setStroke(Color.HOTPINK);
        gc.strokePolygon(new double[] {250,310,300,250},
                         new double[] {350,360,380,400},
                 4);
        gc.fillPolygon(new double[] {250,310,300,250},
                       new double[] {500,510,530,550},
                4);
        //Text
        Font font = new Font("Arial",24);
        gc.setFont(font);
        gc.setStroke(Color.OLIVE);
        gc.setFill(Color.OLIVE);
        gc.strokeText("CSCI 2020U", 450,400);
        gc.fillText("CSCI2020U", 450, 550);

        //Image
        String filename = getClass().getClassLoader().getResource("images/disk.png").toString();
        System.err.println("Filename: " + filename);
        Image image = new Image(filename);
        gc.drawImage(image,685,400);
        */
    }

    private void setupAnimation(){
        String filename = getClass().getClassLoader().getResource("images/sprites.png").toString();
        Image sprites = new Image(filename);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        int frameOffsetX = 0;
        int frameOffsetY = 0;
        final int frameWidth = 128;
        final int frameHeight = 150;
        final int totalHeight = 900;

        KeyFrame keyFrame = new KeyFrame(
                Duration.millis(50),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        gc.setFill((Color.BLACK));
                        gc.fillRect(650,450, frameWidth, frameHeight);
                        gc.drawImage(
                                sprites,
                                frameOffsetX,
                                frameOffsetY,
                                frameWidth,
                                frameHeight,
                                650,
                                450,
                                frameWidth,
                                frameHeight);
                        //frameOffsetY;
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
    }

    public static void main(String[] args){
        launch(args);
    }
}
