# Flexible Notification System
CSC6301 Module 4 Assignment 1



## Project Overview
This project demonstrates the **Composition over Inheritance** design pattern through a flexible notification system. The system can dynamically switch between different notification mediums (Email, SMS) at runtime without requiring changes to the core logic.

## Design Pattern: Composition Over Inheritance

### Why Composition?
- **Flexibility**: Notification mediums can be swapped at runtime
- **Maintainability**: Adding new mediums (e.g., WhatsApp) requires only creating one new class
- **No inheritance hierarchy**: Avoids the complexity and rigidity of deep inheritance trees
- **Single Responsibility**: Each class has one clear purpose

### Key Components

1. **NotificationMedium** (Interface)
   - Defines the contract for all notification services
   - Method: `send(String message)`

2. **EmailService** (Concrete Implementation)
   - Implements NotificationMedium
   - Sends notifications via email

3. **SMSService** (Concrete Implementation)
   - Implements NotificationMedium
   - Sends notifications via SMS

4. **AlertSystem** (Container Class)
   - **Uses composition**: Contains a NotificationMedium object
   - Can change behavior by setting different medium implementations
   - Maintains an ArrayList<String> log of all sent messages
   - Methods:
     - `setMedium(NotificationMedium medium)`: Switch notification medium
     - `notifyUser(String message)`: Send notification and log it
     - `getMessageLog()`: Retrieve all logged messages
     - `printLog()`: Display the message log

## Java Collections Framework
The AlertSystem uses an **ArrayList<String>** to maintain a log of all messages sent during the session. This provides:
- Dynamic sizing (no fixed capacity limit)
- Ordered collection (messages logged in chronological order)
- Easy retrieval and iteration
- Audit trail of notification activity

## Compilation and Execution (CLI)

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed
- Command-line access (Terminal, Command Prompt, or PowerShell)

### Step 1: Navigate to the Project Directory
```bash
cd path/to/NotificationSystem/NotificationSystem
```

### Step 2: Compile All Java Files
```bash
javac *.java
```

### Step 3: Run the Module 5 Maintenance Demo (Recommended)
```bash
java MaintenanceDemo
```

### Optional: Run the Original Demo
```bash
java AlertSystem
```

### What to Look For
- You should see output from **Email**, **SMS**, and **WhatsApp** as the program switches mediums using `setMedium()`
- The printed log confirms every message was stored in the internal `ArrayList` inside `AlertSystem`

## Future Extensions
Adding a new notification medium (e.g., WhatsApp) is simple:

1. Create a new class implementing NotificationMedium:
```java
public class WhatsAppService implements NotificationMedium {
    @Override
    public void send(String message) {
        System.out.println("[WhatsApp] Sending message: " + message);
    }
}
```

2. Use it in AlertSystem:
```java
alertSystem.setMedium(new WhatsAppService());
alertSystem.notifyUser("Hello via WhatsApp!");
```

**No changes required to AlertSystem or other classes!**

## Documentation Standards
All classes and methods include professional JavaDoc documentation with:
- Class-level descriptions
- Method-level descriptions
- `@author` tags
- `@version` tags
- `@since` tags
- `@param` tags for all parameters
- `@return` tags for return values
- `@throws` tags for exceptions
- `@see` tags for related classes



