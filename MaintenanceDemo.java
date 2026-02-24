import java.util.List;

/**
 * CLI driver for the Module 5 maintenance enhancement.
 *
 * <p>This class proves that the new {@link WhatsAppService} can be "plugged in"
 * at runtime using {@link AlertSystem#setMedium(NotificationMedium)} without
 * changing (or rewriting) {@link AlertSystem} or the {@link NotificationMedium}
 * interface.</p>
 *
 * @author Raazia Ghani
 * @version 1.0
 * @since 2026-02-17
 * @see AlertSystem
 * @see WhatsAppService
 */
public class MaintenanceDemo {

    /**
     * Runs a CLI demonstration that switches between Email, SMS, and WhatsApp
     * services at runtime and verifies that each message is logged in the
     * {@link AlertSystem}'s internal ArrayList.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Module 5 Maintenance Enhancement Demo ===\n");

        AlertSystem alertSystem = new AlertSystem();

        NotificationMedium email = new EmailService();
        NotificationMedium sms = new SMSService();
        NotificationMedium whatsapp = new WhatsAppService();

        // 1) Email
        System.out.println("1. Using EmailService...");
        alertSystem.setMedium(email);
        alertSystem.notifyUser("Maintenance notice: Scheduled downtime at 11:00 PM ET.");

        // 2) SMS
        System.out.println("\n2. Switching to SMSService...");
        alertSystem.setMedium(sms);
        alertSystem.notifyUser("Maintenance update: Downtime begins in 15 minutes.");

        // 3) WhatsApp
        System.out.println("\n3. Switching to WhatsAppService...");
        alertSystem.setMedium(whatsapp);
        alertSystem.notifyUser("Maintenance complete: Services restored. Thank you for your patience.");

        // 4) Switch back to prove runtime composition
        System.out.println("\n4. Switching back to EmailService...");
        alertSystem.setMedium(email);
        alertSystem.notifyUser("Post-maintenance: Please verify your access and report any issues.");

        // Verify collection logging
        System.out.println("\n--- Log Verification (ArrayList via composition) ---");
        alertSystem.printLog();

        List<String> log = alertSystem.getMessageLog();
        System.out.println("Log size reported by getMessageCount(): " + alertSystem.getMessageCount());
        System.out.println("First log entry: " + log.get(0));
        System.out.println("Last log entry: " + log.get(log.size() - 1));

        System.out.println("\n=== Demo Complete ===");
        System.out.println("Maintenance proof: WhatsAppService was added without modifying AlertSystem.java");
        System.out.println("and the medium was switched at runtime using setMedium().");
    }
}
