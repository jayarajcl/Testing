public class SQLInjection {
    public void doPost(HttpServletRequest request) {
        String userInput = request.getParameter("userInput"); // Assume this comes from user input
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        System.out.println("Executing query: " + query);
    }
}