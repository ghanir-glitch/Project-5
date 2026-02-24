/**
 * Interface for notification delivery mechanisms in a flexible notification system.
 * This interface defines the contract for all notification services that can send
 * messages to users through different communication channels.
 * 
 * <p>This design uses composition over inheritance to allow the notification system
 * to dynamically switch between different notification mediums at runtime without
 * requiring changes to the core system logic.</p>
 * 
 * @author Raazia Ghani
 * @version 1.0
 * @since 2025-02-09
 */
public interface NotificationMedium {
    
    /**
     * Sends a notification message through this medium.
     * 
     * <p>Implementations of this method should handle the specific logic
     * required to deliver the message through their respective channels
     * (e.g., email, SMS, WhatsApp).</p>
     * 
     * @param message the notification message content to be sent
     * @throws IllegalArgumentException if the message is null or empty
     */
    void send(String message);
}
