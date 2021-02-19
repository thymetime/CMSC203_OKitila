package Lab2;



import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button button1 = new Button("Hello");
	Button button2 = new Button("Howdy");
	Button button3 = new Button("Chinese");
	Button button4 = new Button("Clear");
	Button button5 = new Button("Exit");
	Button button6 = new Button("Learn");
	Label textLabel = new Label("Feedback ");
	TextField textInput = new TextField();

	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	
	DataManager data = new DataManager();
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes

		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hbox1.getChildren().addAll(button1, button2, button3, button4, button5, button6);
		hbox2.getChildren().addAll(textLabel, textInput);
		
		this.getChildren().addAll(hbox1, hbox2);
		
		button1.setOnAction(new ButtonHandler());
		button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());
		button6.setOnAction(new ButtonHandler());
		
		Insets buttonInset = new Insets(0, 25, 0, 25);
		HBox.setMargin(button1, buttonInset); 
		HBox.setMargin(button2, buttonInset); 
		HBox.setMargin(button3, buttonInset); 
		HBox.setMargin(button4, buttonInset); 
		HBox.setMargin(button5, buttonInset); 
		HBox.setMargin(button6, buttonInset);
		
		Insets textInset = new Insets(0, 10, 0, 10);
		HBox.setMargin(textLabel, textInset);
		HBox.setMargin(textInput, textInset);



		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.BASELINE_CENTER);
		
		Insets padding = new Insets(25);
		hbox1.setPadding(padding);
		hbox2.setPadding(padding);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	public class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getTarget() == button1) 
				textInput.setText(data.getHello());
			
			else if (arg0.getTarget() == button2) 
				textInput.setText(data.getHowdy());
			
			else if(arg0.getTarget() == button3) 
				textInput.setText(data.getChinese());
			
			else if (arg0.getTarget() == button4)
				textInput.setText("");
			
			else if (arg0.getTarget() == button5) {
				Platform.exit(); 
				System.exit(0);
			}
			
			else if (arg0.getTarget() == button6) 
				textInput.setText(data.getGreeting());
			
				
		}
		
	}
}
	