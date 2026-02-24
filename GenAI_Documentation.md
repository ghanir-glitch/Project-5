# Generative AI Usage Documentation
CSC6301 Module 4 Assignment 1



---

## Purpose
This document details how Generative AI (Claude) was used as a collaborative tool during the development process, including the queries made and specific refinements applied to the AI-generated output.

---

## AI Tool Used
- **Platform**: Claude (Anthropic)
- **Model**: Claude Sonnet 4.5
- **Date of Use**: February 9, 2025

---

## Query 1: Initial Interface Design

### Query Submitted:
```
"I need to create a NotificationMedium interface in Java with a send method 
that takes a String message parameter. Please include professional JavaDoc 
documentation with @author, @version, @since, and @param tags. The interface 
should be designed for a composition-based notification system."
```

### AI Output:
The AI generated a basic interface with JavaDoc documentation.

### Refinements Made:
1. **Added more detailed class-level JavaDoc**: Expanded the interface description to explain the composition pattern and why it's being used
2. **Enhanced @param documentation**: Added more context about what implementations should do with the message parameter
3. **Added @throws tag**: Included documentation about IllegalArgumentException for null/empty messages
4. **Added contextual paragraph**: Included a `<p>` tag explaining the maintenance benefits of this design

### Rationale:
These refinements make the documentation more professional and educational, clearly explaining the design decisions to future developers.

---

## Query 2: Concrete Implementation Classes

### Query Submitted:
```
"Create EmailService and SMSService classes that implement NotificationMedium. 
Each should have complete JavaDoc documentation including @see tags to reference 
the interface. Include input validation that throws IllegalArgumentException 
for null or empty messages."
```

### AI Output:
The AI generated two implementation classes with basic documentation and validation.

### Refinements Made:
1. **Added production context comments**: Included notes about how these would integrate with real services (SendGrid, Twilio) in production
2. **Enhanced method documentation**: Added detailed explanations of what the methods simulate
3. **Standardized error messages**: Made validation error messages consistent across both classes
4. **Added @see tags**: Cross-referenced the interface and other related classes

### Rationale:
These changes provide better context for students and professionals reviewing the code, making it clear this is a demonstration with production considerations in mind.

---

## Query 3: AlertSystem Container Class

### Query Submitted:
```
"Create an AlertSystem class that uses composition to contain a NotificationMedium 
object. Include setMedium and notifyUser methods. Add an ArrayList<String> to log 
all messages. Include a main method that demonstrates switching between email and 
SMS at runtime. All methods need complete JavaDoc with @param, @throws, and @return tags."
```

### AI Output:
The AI generated the AlertSystem class with basic functionality.

### Refinements Made:
1. **Added defensive programming**: Included null checks with descriptive exception messages
2. **Added additional helper methods**: 
   - `getMessageLog()` returning unmodifiable list for encapsulation
   - `getMessageCount()` for quick size retrieval
   - `clearLog()` for log management
   - `printLog()` for formatted output
3. **Enhanced main method demonstration**: 
   - Added clear section headers
   - Demonstrated multiple medium switches
   - Included log retrieval examples
   - Added summary of design benefits
4. **Improved JavaDoc completeness**:
   - Added detailed class-level description with multiple paragraphs
   - Documented the ArrayList field's purpose
   - Added comprehensive @throws tags for all edge cases
   - Included a detailed main method documentation with HTML list
5. **Added constructor overloading**: Created both parameterless and parameterized constructors

### Rationale:
These refinements transform the class from a basic implementation to a professional, production-ready component with comprehensive documentation and robust error handling.

---

## Query 4: README and CLI Instructions

### Query Submitted:
```
"Create a comprehensive README.md file that explains the composition pattern, 
includes step-by-step CLI compilation and execution instructions for Windows, 
Mac, and Linux, and explains the project structure and future extensibility."
```

### AI Output:
The AI generated a README with basic instructions.

### Refinements Made:
1. **Added platform-agnostic instructions**: Focused on universal commands that work across all systems
2. **Enhanced design pattern explanation**: Added a clear "Why Composition?" section with bullet points
3. **Included concrete extension example**: Showed how to add WhatsApp service with actual code
4. **Added file structure diagram**: Visual representation of project organization
5. **Expanded key learning outcomes**: Detailed what students gain from this assignment

### Rationale:
A professional README should serve as both documentation and teaching tool, clearly explaining not just "how" but "why."

---

## Query 5: UML Class Diagram

### Query Submitted:
```
"Generate a UML class diagram showing the relationship between NotificationMedium 
interface, EmailService, SMSService, and AlertSystem. Use proper UML notation 
showing interface implementation (dashed arrows) and composition (filled diamond). 
Output should be suitable for conversion to PDF."
```

### AI Output:
The AI provided options for creating the diagram.

### Refinements Made:
1. **Selected SVG format**: Chose SVG for easy PDF conversion without quality loss
2. **Added color coding**: Used different colors to distinguish interfaces, implementations, and container classes
3. **Enhanced relationship labels**: Added clear labels on arrows (implements, uses, contains)
4. **Included method signatures**: Added key methods to show the complete class structure
5. **Added legend**: Included a legend explaining UML symbols used

### Rationale:
A clear, professional diagram helps visualize the composition pattern and serves as quick reference documentation.

---

## Overall Refinement Strategy

### Key Principles Applied:
1. **Professional Standards**: Ensured all code meets industry-standard documentation practices
2. **Educational Value**: Made code serve as a teaching tool, not just a working program
3. **Defensive Programming**: Added comprehensive input validation and error handling
4. **Encapsulation**: Used unmodifiable collections and proper access modifiers
5. **Extensibility**: Designed for easy future modifications (WhatsApp example)

### Time Saved vs. Manual Coding:
- **Estimated manual time**: ~90 minutes
- **Actual time with AI**: ~40 minutes (including refinements)
- **Time savings**: ~55% while achieving higher quality documentation

### Quality Improvements from Refinements:
- More comprehensive JavaDoc coverage (100% vs. typical 60-70%)
- Better error handling with descriptive messages
- Enhanced encapsulation through unmodifiable collections
- Professional README that serves multiple purposes
- Clear visual documentation through UML diagram

---

## Conclusion

Using Generative AI as a collaborative tool significantly enhanced both the efficiency and quality of this assignment. The key to success was:

1. **Specific, detailed queries** that clearly communicated requirements
2. **Critical review** of AI output rather than blind acceptance
3. **Purposeful refinements** that added professional polish and educational value
4. **Understanding the "why"** behind design decisions, not just implementing the "what"


# Module 5 Maintenance Enhancement (WhatsApp)
CSC6301 Module 5 Assignment 1

---

## Maintenance Constraint
For this maintenance task, **no changes were made** to:
- `AlertSystem.java`
- `NotificationMedium.java`

The new feature was added **purely by extension** (adding new components), which is the real-world goal of maintainable, SOLID, composition-based design.

---

## Query 6: WhatsAppService (New Medium) + CLI Test Driver

### Prompt Submitted (GenAI)
```
You are helping with a maintenance enhancement. I have an existing Java interface:

public interface NotificationMedium {
    void send(String message);
}

Constraints:
- Do NOT change NotificationMedium.
- Do NOT change AlertSystem.

Task:
1) Create a new class WhatsAppService that implements NotificationMedium.
2) The send(String message) method must validate null/empty like the other services and print EXACTLY:
   [WhatsApp] Sending message: <message>
3) Create a small CLI demo class (separate from AlertSystem) that:
   - Instantiates AlertSystem
   - Uses setMedium() to switch between EmailService, SMSService, and WhatsAppService at runtime
   - Calls notifyUser() after each switch
   - Prints the AlertSystem log to prove messages still land in the internal ArrayList
4) Include professional JavaDocs with @author, @version, @since, @param, @throws, and @see where appropriate.
```

### How Compatibility Was Ensured (No Rewrite)
- The prompt included the **exact interface signature** (`void send(String message)`) so the generated class could compile without changing the interface.
- After generation, the implementation was manually checked to ensure:
  - The class declaration is `public class WhatsAppService implements NotificationMedium`.
  - The method is annotated with `@Override`.
  - The method signature matches **exactly**: `public void send(String message)`.

### Manual Refinements Made
1. **Output formatting match (rubric requirement)**:
   - Ensured the output is exactly:
     - `[WhatsApp] Sending message: ` followed by the message.
2. **Validation consistency**:
   - Used the same validation rule and exception message used by `EmailService` and `SMSService`.
3. **JavaDoc consistency**:
   - Matched the style of existing files (paragraph tags, production context notes, @since date, and @see tags).
4. **Test driver naming and scope**:
   - Added `MaintenanceDemo.java` as a standalone CLI runner so `AlertSystem.java` remains untouched.

---

## CLI Verification Notes
- Compile (all platforms): `javac *.java`
- Run the maintenance demo: `java MaintenanceDemo`

This proves that WhatsApp is **plugged in at runtime** using `setMedium()` and that messages are still logged through the existing `ArrayList` inside `AlertSystem`.
