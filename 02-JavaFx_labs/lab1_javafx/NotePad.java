import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class NotePad extends Application{
    
    BorderPane bpane;
    MenuBar mbar;
    Menu File;
    Menu Edit;
    Menu Help;
    MenuItem New, Open, Save, Exit;
    MenuItem Undo, Cut, Copy, Paste, Delete, SelectAll;
    MenuItem About;
    TextArea ta;
    Alert Aboutalert;
    FileChooser fileChooser;
    File file;
    FileChooser.ExtensionFilter extFilter;

    
      @Override
    public void init() throws Exception {

        super.init(); 
        ta= new TextArea();

        /* Menu bar */
        File=new Menu("File");
        Edit=new Menu("Edit");
        Help=new Menu("Help");


        /* Menu items for file menu */
        New =new MenuItem("New");
        Open=new MenuItem("Open");
        Save=new MenuItem("Save");
        Exit=new MenuItem("Exit");

        File.getItems().addAll(New,Open, Save, Exit);


        /* Menu items for edit menu */
        Undo=new MenuItem("Undo");
        Cut=new MenuItem("Cut");
        Copy=new MenuItem("Copy");
        Paste=new MenuItem("Paste");
        Delete=new MenuItem("Delete");
        SelectAll=new MenuItem("SelectAll");

        Edit.getItems().addAll(Undo, Cut, Copy, Paste, Delete, SelectAll);


        /* Menu items for about menu */
        About=new MenuItem("About NotePad");

        Help.getItems().addAll(About);

      
        mbar=new MenuBar();
        mbar.getMenus().addAll(File,Edit,Help);
        bpane=new BorderPane();
        bpane.setTop(mbar);
        bpane.setCenter(ta);


    }
    
    
    public static void main(String[] args) {
        
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Aboutalert =  new Alert(Alert.AlertType.INFORMATION);
        Aboutalert.setTitle("About Notepad");
        Aboutalert.setHeaderText(null);
        Aboutalert.setContentText("This is a simple Notepad application made with JavaFX by Patrick.");

        
        
        Undo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.undo();
           }
        });

        Cut.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.cut();
           }
        });


        Copy.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.copy();
           }
        });


        Paste.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.paste();
           }
        });


        Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.deleteText(ta.getSelection());
            }
        });


        SelectAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                ta.selectAll();
            }
        });

        About.setOnAction(new EventHandler<ActionEvent>() {
    
                @Override
                public void handle(ActionEvent event) {
                    Aboutalert.showAndWait();
                }
            });

            Open.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fileChooser = new FileChooser();
                    fileChooser.setTitle("Open File");
                    file = fileChooser.showOpenDialog(null);
                
                    if (file != null) {
                        try {
                            String content = new String(Files.readAllBytes(file.toPath())); 
                            ta.setText(content); 
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });




            New.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    ta.clear();
                }

            });

            Save.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  fileChooser = new FileChooser();
                  fileChooser.setTitle("Save File");
                  extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
                  fileChooser.getExtensionFilters().add(extFilter);
                  file = fileChooser.showSaveDialog(null);

                        if (file != null) {
                            try (FileWriter writer = new FileWriter(file)) {
                                writer.write(ta.getText()); 
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                }
            });
            

            Exit.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event){

                    Aboutalert = new Alert(Alert.AlertType.CONFIRMATION);
                    Aboutalert.setTitle("Exit Notepad");
                    Aboutalert.setHeaderText(null);
                    Aboutalert.setContentText("Are you sure you want to exit?");
        
                    Optional<ButtonType> result = Aboutalert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        System.exit(0); // Close the application
                    }
                    
                }
            });
            
    
            Scene myS=new Scene(bpane,500,500);
            primaryStage.setScene(myS);
            primaryStage.setTitle("P2 Notepad");
            primaryStage.show();
        }
    
  
    
}