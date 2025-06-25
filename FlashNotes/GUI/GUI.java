package GUI;
import java.lang.*;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class GUI extends JFrame{
    private JPanel sidePanel, topPanel, addNotePanel, notePanel, headPanel;
    private JButton addNote, noteAdd, showNotes, clearNotes, clearWritable;
    private JLabel titleLabel, noteLabel, noteTitleLabel, noteDescriptionLabel, welcomeLabel, dateLabel;
    private JTextField noteTitleField;
    private JTextArea noteText, noteDescriptionArea;
    private JScrollPane noteScroll, descriptionScroll;
    private String title, description;
    private User user1;
	private ImageIcon iconImage;

    //color
    public static Color PRIMARY_BLUE = new Color(41, 128, 185);
    public static Color LIGHT_BLUE = new Color(52, 152, 219);
    public static Color DARK_BLUE = new Color(44, 62, 80);
    public static Color LIGHT_GRAY = new Color(236, 240, 241);
    public static Color WHITE = Color.WHITE;
    public static Color SUCCESS_GREEN = new Color(39, 174, 96);
    public static Color DANGER_RED = new Color(231, 76, 60);
	
    //font
    public static Font TITLE_FONT = new Font("SF Pro Display", Font.BOLD, 24);
    public static Font BUTTON_FONT = new Font("SF Pro Display", Font.BOLD, 14);
    public static Font LABEL_FONT = new Font("SF Pro Display", Font.BOLD, 16);
    public static Font TEXT_FONT = new Font("SF Pro Display", Font.PLAIN, 14);
    public static Font SMALL_FONT = new Font("SF Pro Display", Font.PLAIN, 12);

    public GUI(){
        welcomeLabel = new JLabel("Welcome to FlashNotes!");
        dateLabel = new JLabel("Current Date & Time");
        clearNotes = new JButton("Clear All Notes");
        clearWritable = new JButton("Clear Fields");
        sidePanel = new JPanel();
        headPanel = new JPanel();
        user1 = new User();
        noteAdd = new JButton("Save Note");
        noteLabel = new JLabel();
        noteTitleField = new JTextField();
        noteDescriptionLabel = new JLabel("Description:");
        noteTitleLabel = new JLabel("Title:");
        noteDescriptionArea = new JTextArea();
        noteText = new JTextArea();
        addNotePanel = new JPanel();
        notePanel = new JPanel();
        titleLabel = new JLabel("FlashNotes", SwingConstants.CENTER);
        topPanel = new JPanel();
        addNote = new JButton("+ Add New Note");
        showNotes = new JButton("Show All Notes");
        noteScroll = new JScrollPane(notePanel);
        descriptionScroll = new JScrollPane(noteDescriptionArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy - HH:mm");
        String formattedDateTime = now.format(formatter);
        dateLabel.setText(formattedDateTime);

        notePanel.setLayout(new BoxLayout(notePanel, BoxLayout.Y_AXIS));
        notePanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        topPanel.setLayout(null);
        addNotePanel.setLayout(null);
        sidePanel.setLayout(null);
        headPanel.setLayout(null);

        noteDescriptionArea.setLineWrap(true);
        noteDescriptionArea.setWrapStyleWord(true);
        noteScroll.getVerticalScrollBar().setUnitIncrement(16);

        addNotePanel.setVisible(false);

        addNote.setFocusable(false);
        noteAdd.setFocusable(false);
        clearNotes.setFocusable(false);
        clearWritable.setFocusable(false);
        showNotes.setFocusable(false);

        this.getContentPane().setBackground(LIGHT_GRAY);
        sidePanel.setBackground(DARK_BLUE);
        headPanel.setBackground(WHITE);
        addNotePanel.setBackground(WHITE);
        notePanel.setBackground(WHITE);
        topPanel.setBackground(PRIMARY_BLUE);

        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(WHITE);
        welcomeLabel.setFont(new Font("SF Pro Display", Font.BOLD, 20));
        welcomeLabel.setForeground(DARK_BLUE);
        dateLabel.setFont(SMALL_FONT);
        dateLabel.setForeground(new Color(127, 140, 141));
        noteTitleLabel.setFont(LABEL_FONT);
        noteDescriptionLabel.setFont(LABEL_FONT);
        noteTitleField.setFont(TEXT_FONT);
        noteDescriptionArea.setFont(TEXT_FONT);

        styleButton(addNote, SUCCESS_GREEN, WHITE);
        styleButton(noteAdd, PRIMARY_BLUE, WHITE);
        styleButton(clearNotes, DANGER_RED, WHITE);
        styleButton(clearWritable, new Color(149, 165, 166), WHITE);
        styleButton(showNotes, LIGHT_BLUE, WHITE);

        noteTitleField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(8, 10, 8, 10)
        ));

        noteDescriptionArea.setBorder(new EmptyBorder(8, 10, 8, 10));
        descriptionScroll.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));

        addNotePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(20, 20, 20, 20)
        ));

        noteScroll.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(5, 5, 5, 5)
        ));

        headPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(15, 20, 15, 20)
        ));

        topPanel.add(titleLabel);
        addNotePanel.add(noteAdd);
        addNotePanel.add(noteTitleField);
        addNotePanel.add(noteTitleLabel);
        addNotePanel.add(noteDescriptionLabel);
        addNotePanel.add(descriptionScroll);
        addNotePanel.add(clearWritable);

        sidePanel.add(addNote);
        sidePanel.add(showNotes);
        sidePanel.add(clearNotes);

        headPanel.add(welcomeLabel);
        headPanel.add(dateLabel);

        sidePanel.setBounds(0, 0, 180, 650);
        topPanel.setBounds(180, 0, 820, 70);
        headPanel.setBounds(200, 90, 780, 80);
        addNotePanel.setBounds(200, 90, 780, 280);
        noteScroll.setBounds(200, 200, 780, 390);
        titleLabel.setBounds(0, 15, 820, 40);
        addNote.setBounds(20, 30, 140, 40);
        showNotes.setBounds(20, 80, 140, 40);
        clearNotes.setBounds(20, 130, 140, 40);

        noteTitleLabel.setBounds(30, 20, 100, 30);
        noteTitleField.setBounds(30, 50, 500, 35);
        noteDescriptionLabel.setBounds(30, 100, 100, 30);
        descriptionScroll.setBounds(30, 130, 500, 80);
        noteAdd.setBounds(560, 130, 120, 40);
        clearWritable.setBounds(560, 180, 120, 40);

        welcomeLabel.setBounds(20, 15, 400, 30);
        dateLabel.setBounds(20, 45, 400, 20);

        // Button work using ActionListener
        addNote.addActionListener(e -> {
            addNotePanel.setVisible(true);
            headPanel.setVisible(false);
            noteTitleField.requestFocus();
        });

        showNotes.addActionListener(e -> {
            addNotePanel.setVisible(false);
            headPanel.setVisible(true);
            readHistory();
        });

        clearWritable.addActionListener(e -> {
            noteTitleField.setText("");
            noteDescriptionArea.setText("");
            noteTitleField.requestFocus();
        });

        clearNotes.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete all notes?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (result == JOptionPane.YES_OPTION) {
                try {
                    File file = new File("notes.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    noteScroll.setVisible(false);
                    notePanel.removeAll();
                    notePanel.revalidate();
                    notePanel.repaint();
                    JOptionPane.showMessageDialog(this, "All notes have been deleted!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error deleting notes!");
                }
            }
        });

        noteAdd.addActionListener(e -> {
            title = noteTitleField.getText().trim();
            description = noteDescriptionArea.getText().trim();

            if(!title.isEmpty() && !description.isEmpty())
			{
                writeHistory(title, description);
                noteTitleField.setText("");
                noteDescriptionArea.setText("");

                JOptionPane.showMessageDialog(this, "Note saved successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                addNotePanel.setVisible(false);
                headPanel.setVisible(true);
                readHistory();
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "Please fill in both title and description!",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
            }
        });
		
        readHistory();
        iconImage = new ImageIcon("Logo.png");
        this.setIconImage(iconImage.getImage());
        this.setTitle("FlashNotes - Professional Note Taking");
        this.setSize(1000, 670);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(sidePanel);
        this.add(topPanel);
        this.add(addNotePanel);
        this.add(headPanel);
        this.add(noteScroll);
    }

    // baton style
    private void styleButton(JButton button, Color bgColor, Color textColor) 
	{
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFont(BUTTON_FONT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            Color originalColor = button.getBackground();

            public void mouseEntered(MouseEvent e) {
                button.setBackground(originalColor.darker());
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    // note writing 
    private void writeHistory(String title, String description)
	{
        try{
			MyNote myNote = new MyNote(title, description);
            user1.addNote(myNote);

            FileWriter writer = new FileWriter("notes.txt", true);
            writer.write("Title: " + myNote.getTitle() + "\n" + "Description: " + myNote.getDescription() + "\n" + "\n");
            writer.close();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(this, "Error saving note!");
        }
    }

    private void readHistory()
	{
        notePanel.removeAll();
        notePanel.revalidate();
        notePanel.repaint();

        try {
            File file = new File("notes.txt");
            if (!file.exists()) {
                noteScroll.setVisible(false);
                return;
            }

            noteScroll.setVisible(true);
            BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
            StringBuilder block = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    String noteContent = block.toString();

                    JPanel noteCard = new JPanel();
                    noteCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
                    noteCard.setLayout(new BorderLayout());
                    noteCard.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                            new EmptyBorder(15, 15, 15, 15)
                    ));
                    noteCard.setBackground(WHITE);

                    JLabel noteContentLabel = new JLabel("<html>" +
                            noteContent.replace("\n", "<br>") + "</html>");
                    noteContentLabel.setFont(TEXT_FONT);
                    noteContentLabel.setForeground(DARK_BLUE);

                    noteCard.add(noteContentLabel, BorderLayout.CENTER);
                    notePanel.add(noteCard);
                    notePanel.add(Box.createVerticalStrut(10));

                    block.setLength(0);
                } 
				else 
				{
                    block.append(line).append("\n");
                }
            }
            reader.close();
        }
        catch (IOException e) 
		{
            JOptionPane.showMessageDialog(this, "Error loading notes!");
        }
    }
}