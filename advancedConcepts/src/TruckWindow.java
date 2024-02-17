import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TruckWindow extends JFrame {
    private JLabel makeLabel, modelLabel, yearLabel, doorsLabel, fuelLabel, rangeLabel, towingLabel, payloadLabel, extraLoadLabel;
    private JTextField makeField, modelField, yearField, doorsField, fuelField, rangeField, towingField, payloadField, extraLoadField;
    private JButton calculateMPGButton;

    public TruckWindow() {
        setTitle("Truck Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        // Initialize labels and text fields
        makeLabel = new JLabel("Make:");
        makeField = new JTextField();
        add(makeLabel);
        add(makeField);

        modelLabel = new JLabel("Model:");
        modelField = new JTextField();
        add(modelLabel);
        add(modelField);

        yearLabel = new JLabel("Year:");
        yearField = new JTextField();
        add(yearLabel);
        add(yearField);

        doorsLabel = new JLabel("Number of Doors:");
        doorsField = new JTextField();
        add(doorsLabel);
        add(doorsField);

        fuelLabel = new JLabel("Fuel Tank Capacity:");
        fuelField = new JTextField();
        add(fuelLabel);
        add(fuelField);

        rangeLabel = new JLabel("Driving Range:");
        rangeField = new JTextField();
        add(rangeLabel);
        add(rangeField);

        towingLabel = new JLabel("Towing Capacity:");
        towingField = new JTextField();
        add(towingLabel);
        add(towingField);

        payloadLabel = new JLabel("Payload Capacity:");
        payloadField = new JTextField();
        add(payloadLabel);
        add(payloadField);

        extraLoadLabel = new JLabel("Extra Load:");
        extraLoadField = new JTextField();
        add(extraLoadLabel);
        add(extraLoadField);

        // Create calculate MPG button
        calculateMPGButton = new JButton("Calculate MPG");
        calculateMPGButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform calculation
                try {
                    double fuelCapacity = Double.parseDouble(fuelField.getText());
                    int range = Integer.parseInt(rangeField.getText());
                    int extraLoad = Integer.parseInt(extraLoadField.getText());
                    Truck truck = new Truck(makeField.getText(), modelField.getText(), Integer.parseInt(yearField.getText()),
                            Integer.parseInt(doorsField.getText()), fuelCapacity, range, Integer.parseInt(towingField.getText()),
                            Integer.parseInt(payloadField.getText()));
                    double mpgWithoutLoad = truck.calcMPG();
                    double mpgWithLoad = truck.calcMPG(extraLoad);
                    JOptionPane.showMessageDialog(null, "MPG (without extra load): " + mpgWithoutLoad +
                            "\nMPG (with extra load): " + mpgWithLoad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numbers.");
                }
            }
        });
        add(calculateMPGButton);

        pack();
        setLocationRelativeTo(null); 
    }
}
