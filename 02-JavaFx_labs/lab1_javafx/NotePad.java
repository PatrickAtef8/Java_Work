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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.FileDialog;
import java.awt.Frame;




public class NotePad extends Application{
    
    BorderPane bpane;
    MenuBar mbar;
    Menu File;
    Menu Edit;
    Menu Help;
    MenuItem New, OpenLL, SaveLL, OpenHL, SaveHL ,Exit;
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
        OpenLL=new MenuItem("Open LL");
        OpenHL=new MenuItem("Open HL");
        SaveHL=new MenuItem("Save HL");
        SaveLL=new MenuItem("Save LL");
        Exit=new MenuItem("Exit");

        File.getItems().addAll(New, OpenLL,SaveLL,OpenHL,SaveHL,Exit);


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

            OpenLL.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open File with low level stream");
                    File file = fileChooser.showOpenDialog(null);
            
                    if (file != null) {
                        try {
                            FileInputStream fis = new FileInputStream(file);
                            int size = fis.available();
                            byte[] b = new byte[size];
                            fis.read(b);
                            ta.setText(new String(b));
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            


            OpenHL.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open File with high-level stream");
                    File file = fileChooser.showOpenDialog(null);
            
                    if (file != null) {
                        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
                            byte[] b = new byte[(int) file.length()];
                            ta.setText(new String(b));
                            dis.close();
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


            SaveLL.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save File with low-level stream");
                    File file = fileChooser.showSaveDialog(null);
                    
                    if (file != null) {
                        try {
                            FileOutputStream fos = new FileOutputStream(file);
                            byte[] b = ta.getText().getBytes();
                            fos.write(b);
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });


            SaveHL.setOnAction(new EventHandler<ActionEvent>()
             {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save File with high-level stream");
                    File file = fileChooser.showSaveDialog(null);
                    
                    if (file != null) {
                        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) 
                        {
                            byte[] b = ta.getText().getBytes();
                            dos.write(b);
                            dos.close();
                        } 
                        
                        catch (IOException e) 
                        
                        
                        {
                            e.printStackTrace();
                        }
                    }
                }
            });
            
            

            Exit.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent event){

                    Aboutalert = new Alert(Alert.AlertType.CONFIRMATION);
                    Aboutalert.setTitle("Exit Notepad");
                    Aboutalert.setHeaderText(null);
                    Aboutalert.setContentText("Are you sure you want to exit?");
        
                    Optional<ButtonType> result = Aboutalert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        System.exit(0);
                    }
                    
                }
            });
            
    
            Scene myS=new Scene(bpane,500,500);
            primaryStage.setScene(myS);
            primaryStage.setTitle("P2 Notepad");
            primaryStage.show();
        }
    
  
    
}