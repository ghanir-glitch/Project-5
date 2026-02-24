import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A flexible alert notification system that uses composition to delegate
 * notification delivery to different medium implementations.
 * 
 * <p>This class demonstrates the Composition over Inheritance design pattern
 * by containing a NotificationMedium object rather than extending a notification
 * class. This allows the notification medium to be changed at runtime without
 * modifying the AlertSystem class itself.</p>
 * 
 * <p>The system maintains a log of all sent messages using an ArrayList,
 * providing an audit trail of notification activity during the session.</p>
 * 
 * @author Raazia Ghani
 * @version 1.0
 * @since 2025-02-09
 * @see NotificationMedium
 * @see EmailService
 * @see SMSService
 */
public class AlertSystem {
    
    /**
     * The current notification medium used to send messages.
     * This can be changed at runtime using the setMedium method.
     */
    private NotificationMedium medium;
    
    /**
     * Log of all messages sent during this session.
     * Provides an audit trail of notification activity.
     */
    private ArrayList<String> messageLog;
    
    /**
     * Constructs a new AlertSystem with no initial notification medium.
     * The medium must be set using setMedium before calling notifyUser.
     */
    public AlertSystem() {
        this.messageLog = new ArrayList<>();
    }
    
    /**
     * Constructs a new AlertSystem with the specified notification medium.
     * 
     * @param medium the initial notification medium to use
     * @throws IllegalArgumentException if medium is null
     */
    public AlertSystem(NotificationMedium medium) {
        if (medium == null) {
            throw new IllegalArgumentException("Notification medium cannot be null");
        }
        this.medium = medium;
        this.messageLog = new ArrayList<>();
    }
    
    /**
     * Sets or changes the notification medium used by this alert system.
     * 
     * <p>This method allows the system to dynamically switch between different
     * notification channels (email, SMS, etc.) at runtime without requiring
     * changes to the core system logic.</p>
     * 
     * @param medium the new notification medium to use
     * @throws IllegalArgumentException if medium is null
     */
    public void setMedium(NotificationMedium medium) {
        if (medium == null) {
            throw new IllegalArgumentException("Notification medium cannot be null");
        }
        this.medium = medium;
    }
    
    /**
     * Sends a notification message using the currently configured medium
     * and logs the message to the session history.
     * 
     * <p>This method delegates the actual sending to the configured
     * NotificationMedium implementation, demonstrating the power of
     * composition-based design.</p>
     * 
     * @param message the notification message to send
     * @throws IllegalStateException if no notification medium has been set
     * @throws IllegalArgumentException if the message is null or empty
     */
    public void notifyUser(String message) {
        if (medium == null) {
            throw new IllegalStateException("Notification medium has not been set. " +
                    "Please use setMedium() before calling notifyUser()");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        
        // Delegate sending to the current medium
        medium.send(message);
        
        // Log the message
        messageLog.add(message);
    }
    
    /**
     * Retrieves an unmodifiable view of all messages sent during this session.
     * 
     * <p>This method returns an unmodifiable list to preserve encapsulation
     * and prevent external modification of the internal log.</p>
     * 
     * @return an unmodifiable List containing all logged messages
     */
    public List<String> getMessageLog() {
        return Collections.unmodifiableList(messageLog);
    }
    
    /**
     * Returns the number of messages sent during this session.
     * 
     * @return the count of logged messages
     */
    public int getMessageCount() {
        return messageLog.size();
    }
    
    /**
     * Clears all messages from the session log.
     * This does not affect the currently configured notification medium.
     */
    public void clearLog() {
        messageLog.clear();
    }
    
    /**
     * Prints all logged messages to the console.
     * Useful for debugging and auditing notification activity.
     */
    public void printLog() {
        System.out.println("\n=== Message Log ===");
        System.out.println("Total messages sent: " + messageLog.size());
        if (messageLog.isEmpty()) {
            System.out.println("No messages logged.");
        } else {
            for (int i = 0; i < messageLog.size(); i++) {
                System.out.println((i + 1) + ". " + messageLog.get(i));
            }
        }
        System.out.println("==================\n");
    }
    
    /**
     * Main method demonstrating the flexible notification system.
     * 
     * <p>This method demonstrates:</p>
     * <ul>
     *   <li>Creating an AlertSystem instance</li>
     *   <li>Using composition to set different notification mediums</li>
     *   <li>Sending messages through different channels</li>
     *   <li>Dynamically switching between mediums at runtime</li>
     *   <li>Retrieving and displaying the message log</li>
     * </ul>
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Flexible Notification System Demo ===\n");
        
        // Create an AlertSystem instance
        AlertSystem alertSystem = new AlertSystem();
        
        // Set up email notification medium
        System.out.println("1. Configuring Email Service...");
        NotificationMedium emailService = new EmailService();
        alertSystem.setMedium(emailService);
        
        // Send notifications via email
        alertSystem.notifyUser("Welcome to our service!");
        alertSystem.notifyUser("Your account has been activated.");
        
        // Switch to SMS medium at runtime (composition advantage)
        System.out.println("\n2. Switching to SMS Service...");
        NotificationMedium smsService = new SMSService();
        alertSystem.setMedium(smsService);
        
        // Send notifications via SMS
        alertSystem.notifyUser("Your verification code is 123456");
        alertSystem.notifyUser("Password reset requested");
        
        // Switch back to email
        System.out.println("\n3. Switching back to Email Service...");
        alertSystem.setMedium(emailService);
        alertSystem.notifyUser("Security alert: New login detected");
        
        // Display the complete message log
        alertSystem.printLog();
        
        // Demonstrate log retrieval
        System.out.println("Accessing message log programmatically:");
        List<String> log = alertSystem.getMessageLog();
        System.out.println("First message: " + log.get(0));
        System.out.println("Last message: " + log.get(log.size() - 1));
        System.out.println("Total messages: " + alertSystem.getMessageCount());
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("\nKey Design Benefits:");
        System.out.println("- Easy to add new notification mediums (e.g., WhatsApp)");
        System.out.println("- Can switch mediums at runtime without code changes");
        System.out.println("- No complex inheritance hierarchy to maintain");
        System.out.println("- Each medium is independently testable");
    }
}
