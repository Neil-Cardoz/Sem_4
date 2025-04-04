import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

// Exception for low balance
class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

// Exception for invalid transaction
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

// Encapsulated User class
class User {
    private int id;
    private String username;
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}

// Base Transaction class
class Transaction {
    protected double amount;
    protected String category;
    protected Date date;

    public Transaction(double amount, String category, Date date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public Date getDate() { return date; }
}

// Inheritance: CreditCardTransaction
class CreditCardTransaction extends Transaction {
    private String cardNumber;

    public CreditCardTransaction(double amount, String category, Date date, String cardNumber) {
        super(amount, category, date);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() { return cardNumber; }
}

// Encapsulated Wallet class
class Wallet {
    private double balance;
    private double monthlyLimit;

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
    }

    private static void addExpense() throws SQLException, LowBalanceException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Category: ");
        String category = scanner.nextLine();
        Date date = new Date();


        Transaction tx = new Transaction(amount, category, date);
        wallet.addExpense(tx);

        // ✅ Format the date to MySQL DATETIME format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO transactions(user_id, amount, category, date) VALUES(?, ?, ?, ?)")) {
            ps.setInt(1, currentUser.getId());
            ps.setDouble(2, amount);
            ps.setString(3, category);
            ps.setString(4, formattedDate);
            ps.executeUpdate();
        }

        System.out.println("Expense added. Balance: " + wallet.getBalance());
    }


    public void addIncome(double amount) {
        balance += amount;
    }

    public void setMonthlyLimit(double limit) {
        this.monthlyLimit = limit;
    }

    public boolean isLimitExceeded(double monthTotal) {
        return monthTotal > monthlyLimit;
    }

    public double getBalance() { return balance; }
    public double getMonthlyLimit() { return monthlyLimit; }
}

// Database utility class
class DBUtil {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/digital_wallet", "root", "Weinachten01@");

    }

    public static void initDB() throws SQLException {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTO_INCREMENT, username TEXT, password TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS transactions (user_id INTEGER, amount REAL, category TEXT, date TEXT)");
        }
    }
}

public class DigitalWalletApp {
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;
    private static Wallet wallet = new Wallet(1000); // Default starting balance

    public static void main(String[] args) {
        try {
            DBUtil.initDB();
            while (true) {
                System.out.println("1. Register\n2. Login\n3. Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> register();
                    case 2 -> {
                        if (login()) dashboard();
                    }
                    case 3 -> System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void register() throws SQLException {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Registered with ID: " + rs.getInt(1));
            }
        }
    }

    private static boolean login() throws SQLException {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                currentUser = new User(rs.getInt("id"), username, password);
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid credentials.");
                return false;
            }
        }
    }

    private static void dashboard() throws SQLException, LowBalanceException {
        while (true) {
            System.out.println("\n1. Add Expense\n2. Add Income\n3. Set Monthly Limit\n4. View Report\n5. Logout");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addExpense();
                case 2 -> addIncome();
                case 3 -> setLimit();
                case 4 -> viewReport();
                case 5 -> { currentUser = null; return; }
            }
        }
    }

    private static void addExpense() throws SQLException, LowBalanceException {
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Category: ");
        String category = scanner.nextLine();
        Date date = new Date();
        Transaction tx = new Transaction(amount, category, date);
        wallet.addExpense(tx);

        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement("INSERT INTO transactions(user_id, amount, category, date) VALUES(?, ?, ?, ?)");) {
            ps.setInt(1, currentUser.getId());
            ps.setDouble(2, amount);
            ps.setString(3, category);
            ps.setString(4, date.toString());
            ps.executeUpdate();
        }

        System.out.println("Expense added. Balance: " + wallet.getBalance());
    }

    private static void addIncome() {
        System.out.print("Income Amount: ");
        double income = Double.parseDouble(scanner.nextLine());
        wallet.addIncome(income);
        System.out.println("Income added. Balance: " + wallet.getBalance());
    }

    private static void setLimit() {
        System.out.print("Set Monthly Limit: ");
        double limit = Double.parseDouble(scanner.nextLine());
        wallet.setMonthlyLimit(limit);
        System.out.println("Limit set to: " + limit);
    }

    private static void viewReport() throws SQLException {
        double total = 0;
        System.out.println("\n--- Monthly Expenses ---");
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM transactions WHERE user_id = ?");) {

            ps.setInt(1, currentUser.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("category") + " - " + rs.getDouble("amount") + " on " + rs.getString("date"));
                total += rs.getDouble("amount");
            }
        }
        System.out.println("Total Spent: " + total);
        if (wallet.isLimitExceeded(total)) {
            System.out.println("⚠️ Limit exceeded!");
        }
    }
}
