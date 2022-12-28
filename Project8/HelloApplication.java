// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to extract Data from an input file named "PlanetInfo.txt" and computes different result
//						based on the user's input.
package com.example.planetinfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.application.Platform;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class HelloApplication extends Application {
    private TextField weightEarth;
    private Label resultLabel1;
    private RadioButton mercury;
    private  RadioButton venus;
    private RadioButton earth;
    private RadioButton mars;
    private RadioButton jupiter;
    private RadioButton saturn;
    private RadioButton uranus;
    private RadioButton neptune;

    CheckBox surfaceArea;
    CheckBox circumference;
    CheckBox distance;

    ArrayList<PlanetEntry> planetlist = new ArrayList<>();

    CheckBox weight;

    @Override
    public void start(Stage primaryStage) throws IOException, InputMismatchException{
        //label for a TextField
        Label prompt = new Label("Choose a Planet of your choice ");


        //Add radio buttons
        mercury = new RadioButton("Mercury");
        venus = new RadioButton("Venus");
        earth = new RadioButton("Earth");
        mars = new RadioButton("Mars");
        jupiter = new RadioButton("Jupiter");
        saturn = new RadioButton("Saturn");
        uranus = new RadioButton("Uranus");
        neptune = new RadioButton("Neptune");


        //make first radio button selected
        mercury.setSelected(true);

        //set radio buttons to a group so, they become mutually exclusive
        ToggleGroup radioGroup = new ToggleGroup();
        mercury.setToggleGroup(radioGroup);
        venus.setToggleGroup(radioGroup);
        earth.setToggleGroup(radioGroup);
        mars.setToggleGroup(radioGroup);
        jupiter.setToggleGroup(radioGroup);
        saturn.setToggleGroup(radioGroup);
        uranus.setToggleGroup(radioGroup);
        neptune.setToggleGroup(radioGroup);

        //Label for checkbox
        Label prompt2 = new Label("Enter your weight on Earth in Kg");
        //create a TextField
        weightEarth = new TextField();

        //Label for checkbox
        Label prompt3 = new Label("Select the details you wish to display of the Planet");
        //Create the checkboxes
        surfaceArea = new CheckBox("Surface Area of the Planet");
        circumference = new CheckBox("Circumference of the Planet");
        distance = new CheckBox("Distance from the sun");
        weight = new CheckBox("Corresponding weight on the Planet");

        //create a button control
        Button disButton = new Button("Display");

        buildList();

        //what to do when the button is clicked
        disButton.setOnAction(new DisButtonHandler());

        //create a result label to hold converted values
        resultLabel1 = new Label();


        //create a horizontal box and place prompt label and TextField within
        HBox promptHB = new HBox(10, prompt);

        //create a HBox and place radio button options
        VBox radioHBox = new VBox(20, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune);

        //put the checkboxes in the VBox
        VBox chkVBox = new VBox(10, prompt2, weightEarth,prompt3,surfaceArea, circumference, distance, weight);

        //create a Vertical box and place the two HBox and the result label in order
        VBox mainVBox = new VBox(10, promptHB,radioHBox, chkVBox, disButton, resultLabel1);

        //center the VBox
        mainVBox.setAlignment(Pos.CENTER);

        //pad by 10 pixels
        mainVBox.setPadding(new Insets(10));

        //create the scene
        Scene scene = new Scene(mainVBox);

        //set the stage and title
        primaryStage.setScene(scene);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Planet Information");
        primaryStage.show();
    }
    class DisButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            final double P_I = 3.14159;
            double sA = -1;
            double c =-1;
            double d =-1;
            double w =-1;

            try{
                if(weightEarth.getText().length()==0){
                    throw new EmptyStringException("Weight cannot be empty.");
                }
            }
            catch (EmptyStringException e){
                Platform.runLater(() -> {
                    Alert dialog = new Alert(Alert.AlertType.ERROR, String.valueOf(e), ButtonType.OK);
                    dialog.show();
                    weightEarth.requestFocus();
                });
            }
            try{
                double check = Double.parseDouble(weightEarth.getText());
            }
            catch (NumberFormatException es){
                Platform.runLater(() -> {
                    Alert dialog = new Alert(Alert.AlertType.ERROR,"InputMismatchException", ButtonType.OK);
                    dialog.show();
                    weightEarth.requestFocus();
                });
            }
            try{
                if(Double.parseDouble(weightEarth.getText()) < 0){
                    throw new NegativeInputValueException("Input Weight Cannot be negative");
                }
            }
            catch(NegativeInputValueException e){
                Platform.runLater(() -> {
                    Alert dialog = new Alert(Alert.AlertType.ERROR, String.valueOf(e), ButtonType.OK);
                    dialog.show();
                    weightEarth.requestFocus();
                });
            }
            if(mercury.isSelected()){
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Mercury")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            }
            else if(venus.isSelected()){
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Venus")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            } else if (earth.isSelected()) {
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Earth")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            } else if (mars.isSelected()) {
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Mars")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            } else if (jupiter.isSelected()) {
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Jupiter")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            } else if (saturn.isSelected()) {
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Saturn")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            } else if (uranus.isSelected()) {
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Uranus")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            }
            else{
                int i=0;
                for(i =0; i<planetlist.size();i++){
                    if(planetlist.get(i).getName().equals("Neptune")){
                        break;
                    }
                }
                if(surfaceArea.isSelected()){
                    sA = 4 * P_I * planetlist.get(i).getRadius() * planetlist.get(i).getRadius();
                }
                if(circumference.isSelected()){
                    c = 2 * P_I * planetlist.get(i).getRadius();
                }
                if(distance.isSelected()){
                    d = planetlist.get(i).getDistance();
                }
                if(weight.isSelected()){
                    w = planetlist.get(i).getwRatio() * Double.parseDouble(weightEarth.getText());
                }
            }

            String m1 ="";
            if(sA!=-1) {
                m1+= "Surface Area = " + String.format("%,.2f  km*km  ", sA)+"\n";
            }
            if(c!=-1){
                m1+= "Circumference = " + String.format("%,.2f  km  ",c)+"\n";
            }
            if(d!=-1){
                m1+= "Distance from the sun = " + String.format("%,.2f  AU  ",d)+"\n";
            }
            if(w!=-1){
                m1+=" Weight = " + String.format("%,.2f  kg",w)+"\n";
            }
            resultLabel1.setText(m1);
        }

    }

    public static void main(String[] args) {
        launch();
    }
    public void buildList() throws IOException
    {
        try{
            //Open the file
            String input_fileName = "PlanetInfo.txt";
            File inp_file = new File(input_fileName);
            Scanner infile = new Scanner(inp_file);
            //Read the file's contents into the ArrayList

            while(infile.hasNext()) {

                //Read a Line
                String line = infile.nextLine();

                //Split the data using ','
                String[] tokens = line.split(",");


                //Build a PlanetEntry object and add it to the arrayList
                planetlist.add(new PlanetEntry(tokens[0],
                        Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3])));

            }

            //close the file
            infile.close();
        }catch (FileNotFoundException e){
            Platform.runLater(() -> {
                Alert dialog = new Alert(Alert.AlertType.ERROR, "File Not Found.", ButtonType.OK);
                dialog.show();
                System.exit(0);
            });
        }

    }
    // Define a NegativeInputValue exception class
    class NegativeInputValueException extends Exception {
        String str = null;
        public NegativeInputValueException(String x){
            str = x;
        }
        public String toString()
        {
            return("NegativeInputValueException: "+str);
        }
    }

    class InputMismatchException extends Exception
    {
        String str = null;
        public InputMismatchException(String x){
            str = x;
        }
        public String toString()
        {
            return("InputMismatchException: "+str);
        }
    }
    class EmptyStringException extends Exception{
        String str = null;
        public EmptyStringException(String x){
            str = x;
        }
        public String toString()
        {
            return("EmptyStringException: "+str);
        }
    }
}
