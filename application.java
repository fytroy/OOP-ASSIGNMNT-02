import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetDisplayApp {
    private JFrame frame;
    private JLabel displayLabel;
    private ButtonGroup buttonGroup;

    public PetDisplayApp() {
        frame = new JFrame("Pet Display App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(6, 1));

        displayLabel = new JLabel("Select a pet to display:");
        frame.add(displayLabel);

        buttonGroup = new ButtonGroup();

        createRadioButton("Dog");
        createRadioButton("Cat");
        createRadioButton("Bird");
        createRadioButton("Fish");
        createRadioButton("Rabbit");

        frame.setVisible(true);
    }

    private void createRadioButton(String petName) {
        JRadioButton radioButton = new JRadioButton(petName);
        radioButton.setActionCommand(petName.toLowerCase());
        buttonGroup.add(radioButton);
        frame.add(radioButton);

        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPet = buttonGroup.getSelection().getActionCommand();
                displayLabel.setText("Selected pet: " + selectedPet);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetDisplayApp();
        });
    }
}
