/**
 * Email implementation of the NotificationMedium interface.
 * This class provides functionality to send notifications via email.
 * 
 * <p>In a production environment, this class would integrate with an email
 * service provider (e.g., SendGrid, AWS SES). For demonstration purposes,
 * this implementation simulates sending by printing to the console.</p>
 * 
 * @author Raazia Ghani
 * @version 1.0
 * @since 2025-02-09
 * @see NotificationMedium
 */
public class EmailService implements NotificationMedium {
    
    /**
     * Sends a notification message via email.
     * 
     * <p>This method simulates sending an email by printing the message
     * to the console with an email-specific prefix.</p>
     * 
     * @param message the notification message to be sent via email
     * @throws IllegalArgumentException if the message is null or empty
     */
    @Override
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println("[EMAIL] Sending email: " + message);
    }
}
