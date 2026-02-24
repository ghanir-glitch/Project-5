/**
 * WhatsApp implementation of the {@link NotificationMedium} interface.
 * This class provides functionality to send notifications via WhatsApp.
 *
 * <p>In a production environment, this class would integrate with the
 * WhatsApp Business Platform or a third-party provider. For demonstration
 * purposes, this implementation simulates sending by printing to the console.</p>
 *
 * @author Raazia Ghani
 * @version 1.0
 * @since 2026-02-17
 * @see NotificationMedium
 */
public class WhatsAppService implements NotificationMedium {

    /**
     * Sends a notification message via WhatsApp.
     *
     * <p>This method simulates sending a WhatsApp message by printing the
     * message to the console with a WhatsApp-specific prefix.</p>
     *
     * @param message the notification message to be sent via WhatsApp
     * @throws IllegalArgumentException if the message is null or empty
     */
    @Override
    public void send(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        System.out.println("[WhatsApp] Sending message: " + message);
    }
}
