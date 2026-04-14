import javax.swing.*;

public class BookingGUI extends JFrame {

    private BookingManager manager = new BookingManager();

    public BookingGUI() {
        setTitle("Hotel Booking System");
        setSize(400, 400);
        setLayout(null);

        manager.loadObject();

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 25);
        add(nameField);

        JLabel roomLabel = new JLabel("Room:");
        roomLabel.setBounds(20, 60, 80, 25);
        add(roomLabel);

        JTextField roomField = new JTextField();
        roomField.setBounds(100, 60, 200, 25);
        add(roomField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(20, 100, 80, 25);
        add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(100, 100, 200, 25);
        add(dateField);

        JTextArea output = new JTextArea();
        output.setBounds(20, 200, 350, 120);
        add(output);

        JButton addBtn = new JButton("Add Booking");
        addBtn.setBounds(100, 150, 150, 30);
        add(addBtn);

        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int room = Integer.parseInt(roomField.getText());
                String date = dateField.getText();

                if (name.isEmpty() || date.isEmpty()) {
                    throw new InvalidDateException("Fields cannot be empty!");
                }

                Booking b = new Booking(name, room, date);
                manager.addBooking(b);
                manager.saveToFile();
                manager.saveObject();

                output.setText("SUCCESS\n" + b.display());

            } catch (Exception ex) {
                output.setText("ERROR: " + ex.getMessage());
            }
        });
    }
}