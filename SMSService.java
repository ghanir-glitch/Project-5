/**
 * SMS (Short Message Service) implementation of the NotificationMedium interface.
 * This class provides functionality to send notifications via text message.
 * 
 * <p>In a production environment, this class would integrate with an SMS
 * gateway provider (e.g., Twilio, Nexmo). For demonstration purposes,
 * this implementation simulates sending by printing to the console.</p>
 * 
 * @author Raazia Ghani
 * @version 1.0
 * @since 2025-02-09
 * @see NotificationMedium
 */
public class SMSService implements NotificationMedium {
    
    /**
     * Sends a notification message via SMS.
     * 
     * <p>This method simulates sending an SMS by printing the message
     * to the console with an SMS-specific prefix.</p>
     * 
     * @param message the notification message to be sent via SMS
     * @throws IllegalArgumentException if the message is null or empty
     */
    @Override
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println("[SMS] Sending text message: " + message);
    }
}
