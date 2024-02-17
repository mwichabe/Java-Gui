import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VehicleSelector extends JFrame {
    private JComboBox<String> vehicleComboBox;
    private JButton selectButton;

    public VehicleSelector() {
        setTitle("Vehicle Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] vehicles = {"Car", "Truck"};
        vehicleComboBox = new JComboBox<>(vehicles);
        add(vehicleComboBox);

        selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedVehicle = (String) vehicleComboBox.getSelectedItem();
                if (selectedVehicle.equals("Car")) {
                    // Open car window
                    CarWindow carWindow = new CarWindow();
                    carWindow.setVisible(true);
                } else if (selectedVehicle.equals("Truck")) {
                    // Open truck window
                    TruckWindow truckWindow = new TruckWindow();
                    truckWindow.setVisible(true);
                }
            }
        });
        add(selectButton);

        setSize(300, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VehicleSelector selector = new VehicleSelector();
                selector.setVisible(true);
            }
        });
    }
}
