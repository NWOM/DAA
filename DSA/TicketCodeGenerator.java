/**Ticket Encoding Sequence
Last Updated : 09 Dec, 2023
You are working at a ticketing company that generates unique ticket codes for various events. You have given a number N and your task is to print the Nth ticket code. The ticket codes are generated based on a specific encoding sequence. The encoding sequence follows the recursive formula as described below:

The ticket code for the first ticket (ticket #1) is “A.”
Now, to generate rth ticket you have to take an r-1 th ticket and create a new encoding by writing down the frequency followed by a digit.
        for example Ticket#(r-1) = “1121A” (Two 1, One 2, One 1, One A) so Ticket#(r) = “2112111A”**/
public class TicketCodeGenerator {

    // Function to generate the ticket code for a given N
    static String generateTicketCode(int N) {
        // Initialize the first ticket code as "A"
        StringBuilder ticketCode = new StringBuilder("A");

        for (int i = 2; i <= N; i++) {
            // Initialize a new ticket code
            StringBuilder newTicketCode = new StringBuilder();

            // Initialize the current character
            char currentChar = ticketCode.charAt(0);
            // Initialize the character count
            int charCount = 0;

            // Loop through the characters in the previous ticket code
            for (int j = 0; j < ticketCode.length(); j++) {
                if (ticketCode.charAt(j) == currentChar) {
                    // Increment character count if the character is the same
                    charCount++;
                } else {
                    // If a different character is encountered, add the character
                    // count and current character to the new ticket code
                    newTicketCode.append(charCount).append(currentChar);

                    // Update the current character
                    currentChar = ticketCode.charAt(j);
                    // Reset character count to 1
                    charCount = 1;
                }
            }

            // Add the character count and current character to the new ticket code
            // for the last character group
            newTicketCode.append(charCount).append(currentChar);
            // Update the ticket code for the next iteration
            ticketCode = newTicketCode;
        }

        return ticketCode.toString();
    }

    // Driver code
    public static void main(String[] args) {
        int N = 4;

        // Generate the ticket code for N
        String ticketCode = generateTicketCode(N);

        // Output the ticket code
        System.out.println(ticketCode);
    }
}
