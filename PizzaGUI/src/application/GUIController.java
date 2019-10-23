package application;

import javafx.event.ActionEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;



public class GUIController{
	
	public double totalcost; 

    @FXML
    private Button Add;

    @FXML
    private TextField Number;

    @FXML
    private TextField Costper;

    @FXML
    private ChoiceBox<String> Size;
    
    @FXML
    private Slider num;

    @FXML
    private ChoiceBox<String> Cheese;

    @FXML
    private ChoiceBox<String> Pepperoni;
    
    @FXML
    private ComboBox<String> Pep2;
    
    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

	@FXML
	private TextField selectedText;
	
	@FXML 
	private Label Orders; 
	
	@FXML 
	private TextField TotalCost;

    private ObservableList<String> CheeseList = FXCollections.observableArrayList(
    		"None", "Single", "Double", "Triple");
    
    private ObservableList<String> MeatList = FXCollections.observableArrayList(
    		"None", "Single Pepperoni, No Ham", "Double Pepperoni, No Ham", "Triple Pepperoni, No Ham",
    		"Single Pepperoni, Single Ham", "Single Pepperoni, Double Ham", "Double Pepperoni, Single Ham"
    		, "No Pepperoni, Triple Ham", "No Pepperoni, Double Ham", "No Pepperoni, Single Ham");
    
    private ObservableList<String> SizeList = FXCollections.observableArrayList(
    		"Small", "Medium", "Large");
        

    // Add pizza's to the order
    @FXML
    void Save(ActionEvent event) throws IllegalPizza{
    	
		Pizza pizza = new Pizza(Size.getValue(), cheeseconvert(Cheese.getValue()), hamconvert(Pepperoni.getValue()), pepconvert(Pepperoni.getValue()) );

		LineItem lineitem = new LineItem((int)num.getValue(), pizza);
		
		Orders.setText(Orders.getText() + "\n" + lineitem.toString());
		
		totalcost = totalcost + lineitem.getCost();

    }
    
    @FXML
    void TotalCost(ActionEvent event) throws IllegalPizza{
    	
		Pizza pizza = new Pizza(Size.getValue(), cheeseconvert(Cheese.getValue()), hamconvert(Pepperoni.getValue()), pepconvert(Pepperoni.getValue()) );

		LineItem lineitem = new LineItem((int)num.getValue(), pizza);
		
		Orders.setText(Orders.getText() + "\nThe total cost of this order is: $" + totalcost);

    }
       
    @FXML
	void initialize() {
    	
    	
    	//Size List
    	Size.setValue("Small");
    	Size.setItems(SizeList);
    	Size.valueProperty().addListener((observableValue, oldVal, newVal) ->
    	{
        	selectedText.setText(newVal);
    	});
	
    	// Cheese List
    	Cheese.setValue("Single");
    	Cheese.setItems(CheeseList);
    	Cheese.valueProperty().addListener((observableValue, oldVal, newVal) ->
    	{
        	selectedText.setText(newVal);
    	});
    	
    	//Pepperoni List
    	Pepperoni.setValue("Single Pepperoni, No Ham");
    	Pepperoni.setItems(MeatList);
    	Pepperoni.valueProperty().addListener((observableValue, oldVal, newVal) ->
    	{
        	selectedText.setText(newVal);
    	});
 
    }
    
    public int pepconvert(String Toppings){
    	
    	if(Toppings == "Single Pepperoni, No Ham" || Toppings == "Single Pepperoni, Single Ham" || Toppings == "Single Pepperoni, Double Ham")
    		return 1;
    	else if(Toppings == "Double Pepperoni, No Ham" || Toppings == "Double Pepperoni, Single Ham"){
    		return 2;
    		}
    	else if(Toppings == "No Pepperoni, Single Ham" || Toppings == "No Pepperoni, Double Ham" || Toppings == "No Pepperoni, Triple Ham"){
    		return 0;
    		}
    	else
    		return 3;
    	}
    	
    public int cheeseconvert(String amount){
    	if(amount == "Single")
    		return 1; 
    	else if( amount == "Double")
    		return 2; 
    	else
    		return 3; 
    }

    public int hamconvert(String Toppings){
	
	if(Toppings == "No Pepperoni, Single Ham" || Toppings == "Single Pepperoni, Single Ham" || Toppings == "Double Pepperoni, Single Ham")
		return 1;
	else if(Toppings == "No Pepperoni, Double Ham" || Toppings == "Single Pepperoni, Double Ham"){
		return 2;
		}
	else if(Toppings == "Single Pepperoni, No Ham" || Toppings == "Double Pepperoni, No Ham" || Toppings == "Triple Pepperoni, No Ham"){
		return 0;
		}
	else
		return 3;
	}
	
}
