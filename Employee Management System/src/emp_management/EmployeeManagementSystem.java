package emp_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.MatteBorder;

public class EmployeeManagementSystem extends JFrame {
    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField regEmpId, regName, regEmail, regBloodGroup, regPhone, regJobPosition, regQualification, regSalary;
    private JPasswordField regPassword;
    private JTextField loginEmpId;
    private JPasswordField loginPassword;

    public EmployeeManagementSystem() {
        setTitle("Employee Management System");
        setSize(511, 600); // Increased size for better layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel firstPage = createFirstPage();
        JPanel registerPage = createRegisterPage();
        JPanel loginPage = createLoginPage();
        JPanel welcomePage = createWelcomePage();

        mainPanel.add(firstPage, "FirstPage");
        mainPanel.add(registerPage, "RegisterPage");
        mainPanel.add(loginPage, "LoginPage");
        mainPanel.add(welcomePage, "WelcomePage");

        getContentPane().add(mainPanel);
        cardLayout.show(mainPanel, "FirstPage");
    }

    private JPanel createFirstPage() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 192, 203));
        panel.setLayout(null);

        JButton registerButton = new JButton("Register");
     
        registerButton.setBackground(new Color(255, 20, 147));
        registerButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        registerButton.setForeground(new Color(0, 0, 0));
        registerButton.setBounds(157, 202, 200, 39);
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "RegisterPage"));
        panel.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.setBackground(new Color(255, 20, 147));
        loginButton.setBounds(157, 289, 200, 39);
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "LoginPage"));
        panel.add(loginButton);
        
        JLabel lblNewLabel_1 = new JLabel("Employee Management System");
        lblNewLabel_1.setForeground(new Color(128, 0, 128));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
        lblNewLabel_1.setBounds(113, 124, 315, 39);
        panel.add(lblNewLabel_1);

        return panel;
    }

    private JPanel createRegisterPage() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 192, 203));
        panel.setLayout(null);

        JLabel label = new JLabel("Employee ID:");
        label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label.setBounds(20, 20, 120, 25);
        panel.add(label);
        regEmpId = new JTextField();
        regEmpId.setBounds(180, 20, 180, 25);
        panel.add(regEmpId);

        JLabel label_1 = new JLabel("Password:");
        label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_1.setBounds(20, 60, 120, 25);
        panel.add(label_1);
        regPassword = new JPasswordField();
        regPassword.setBounds(180, 60, 180, 25);
        panel.add(regPassword);

        JLabel label_2 = new JLabel("Name:");
        label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_2.setBounds(20, 101, 120, 25);
        panel.add(label_2);
        regName = new JTextField();
        regName.setBounds(180, 101, 180, 25);
        panel.add(regName);

        JLabel label_3 = new JLabel("Email ID:");
        label_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_3.setBounds(20, 151, 120, 25);
        panel.add(label_3);
        regEmail = new JTextField();
        regEmail.setBounds(180, 152, 180, 25);
        panel.add(regEmail);

        JLabel label_4 = new JLabel("Blood Group:");
        label_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_4.setBounds(20, 198, 120, 25);
        panel.add(label_4);
        regBloodGroup = new JTextField();
        regBloodGroup.setBounds(180, 199, 180, 25);
        panel.add(regBloodGroup);

        JLabel label_5 = new JLabel("Phone Number:");
        label_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_5.setBounds(20, 245, 120, 25);
        panel.add(label_5);
        regPhone = new JTextField();
        regPhone.setBounds(180, 246, 180, 25);
        panel.add(regPhone);

        JLabel label_6 = new JLabel("Job Position:");
        label_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_6.setBounds(20, 294, 120, 25);
        panel.add(label_6);
        regJobPosition = new JTextField();
        regJobPosition.setBounds(180, 295, 180, 25);
        panel.add(regJobPosition);

        JLabel label_7 = new JLabel("Qualification:");
        label_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_7.setBounds(20, 341, 120, 25);
        panel.add(label_7);
        regQualification = new JTextField();
        regQualification.setBounds(180, 342, 180, 25);
        panel.add(regQualification);

        JLabel label_8 = new JLabel("Salary:");
        label_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_8.setBounds(20, 386, 120, 25);
        panel.add(label_8);
        regSalary = new JTextField();
        regSalary.setBounds(180, 386, 180, 25);
        panel.add(regSalary);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(255, 20, 147));
        submitButton.setFont(new Font("Georgia", Font.BOLD, 18));
        submitButton.setForeground(new Color(0, 0, 0));
        submitButton.setBounds(102, 440, 120, 30);
        submitButton.addActionListener(e -> registerUser());
        panel.add(submitButton);
        return panel;
    }

    private JPanel createLoginPage() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(154, 205, 50));
        JLabel label_1 = new JLabel("Employee ID:");
        label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_1.setBounds(20, 80, 120, 25);
        panel.add(label_1);
        loginEmpId = new JTextField();
        loginEmpId.setBounds(119, 80, 180, 25);
        panel.add(loginEmpId);

        JLabel label_2 = new JLabel("Password:");
        label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label_2.setBounds(20, 139, 120, 25);
        panel.add(label_2);
        loginPassword = new JPasswordField();
        loginPassword.setBounds(119, 140, 180, 25);
        panel.add(loginPassword);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        loginButton.setBackground(new Color(199, 21, 133));
        loginButton.setBounds(62, 194, 120, 30);
        loginButton.addActionListener(e -> loginUser());
        panel.add(loginButton);
        
        JLabel lblNewLabel = new JLabel("EMPLOYEE LOGIN");
        lblNewLabel.setForeground(new Color(75, 0, 130));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(80, 23, 151, 28);
        panel.add(lblNewLabel);
        return panel;
    }

    private JPanel createWelcomePage() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(0, 125, 0));
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(186, 85, 211));
        panel.add(welcomeLabel, BorderLayout.NORTH);
        String[] columnNames = {"Field", "Value"};
        Object[][] data = new Object[8][2];
        JTable userDetailsTable = new JTable(data, columnNames);
        userDetailsTable.setRowHeight(30);
        userDetailsTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        userDetailsTable.setBackground(new Color(240, 248, 255));
        userDetailsTable.setForeground(new Color(0, 0, 0));
        userDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        userDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(300);

        JScrollPane scrollPane = new JScrollPane(userDetailsTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void registerUser() {
        try {
            int empId = Integer.parseInt(regEmpId.getText());
            String password = new String(regPassword.getPassword());
            String name = regName.getText();
            String email = regEmail.getText();
            String bloodGroup = regBloodGroup.getText();
            String phone = regPhone.getText();
            String jobPosition = regJobPosition.getText();
            String qualification = regQualification.getText();
            double salary = Double.parseDouble(regSalary.getText());

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE employee_id = ?")) {
                ps.setInt(1, empId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Employee ID already exists");
                        System.out.println("Duplicate Employee ID: " + empId);
                        return;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                return;
            }

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                         "INSERT INTO employees (employee_id, password, name, email_id, blood_group, phone_number, job_position, qualification, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
                ps.setInt(1, empId);
                ps.setString(2, password);
                ps.setString(3, name);
                ps.setString(4, email);
                ps.setString(5, bloodGroup);
                ps.setString(6, phone);
                ps.setString(7, jobPosition);
                ps.setString(8, qualification);
                ps.setDouble(9, salary);
                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "User registered successfully");
                    System.out.println("User registered successfully with ID: " + empId);
                } else {
                    JOptionPane.showMessageDialog(this, "Error registering user");
                    System.out.println("Error registering user with ID: " + empId);
                }
                cardLayout.show(mainPanel, "FirstPage");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Employee ID or Salary.");
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    private void loginUser() {
        try {
            int empId = Integer.parseInt(loginEmpId.getText());
            String password = new String(loginPassword.getPassword());

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE employee_id = ? AND password = ?")) {
                ps.setInt(1, empId);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Login successful");
                        System.out.println("User logged in successfully with ID: " + empId);
                        cardLayout.show(mainPanel, "WelcomePage");

                        JPanel welcomePage = (JPanel) mainPanel.getComponent(3);
                        JTable userDetailsTable = (JTable) ((JScrollPane) welcomePage.getComponent(1)).getViewport().getView();

                        userDetailsTable.setValueAt("Employee ID", 0, 0);
                        userDetailsTable.setValueAt(rs.getInt("employee_id"), 0, 1);
                        userDetailsTable.setValueAt("Name", 1, 0);
                        userDetailsTable.setValueAt(rs.getString("name"), 1, 1);
                        userDetailsTable.setValueAt("Email ID", 2, 0);
                        userDetailsTable.setValueAt(rs.getString("email_id"), 2, 1);
                        userDetailsTable.setValueAt("Blood Group", 3, 0);
                        userDetailsTable.setValueAt(rs.getString("blood_group"), 3, 1);
                        userDetailsTable.setValueAt("Phone Number", 4, 0);
                        userDetailsTable.setValueAt(rs.getString("phone_number"), 4, 1);
                        userDetailsTable.setValueAt("Job Position", 5, 0);
                        userDetailsTable.setValueAt(rs.getString("job_position"), 5, 1);
                        userDetailsTable.setValueAt("Qualification", 6, 0);
                        userDetailsTable.setValueAt(rs.getString("qualification"), 6, 1);
                        userDetailsTable.setValueAt("Salary", 7, 0);
                        userDetailsTable.setValueAt(rs.getDouble("salary"), 7, 1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Login unsuccessful");
                        System.out.println("Failed login attempt with ID: " + empId);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Employee ID.");
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagementSystem frame = new EmployeeManagementSystem();
            frame.setVisible(true);
        });
    }
}
