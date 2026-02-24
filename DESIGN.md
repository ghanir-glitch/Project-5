# System Design – Project 5 (Maintenance Enhancement)

## Enhancement Overview

This project extends the Flexible Notification System by adding WhatsApp support.

The enhancement follows the Open/Closed Principle:
- AlertSystem was NOT modified
- NotificationMedium interface was NOT modified
- A new class (WhatsAppService) was added

## Architecture

AlertSystem
    -> NotificationMedium (interface)
        -> EmailService
        -> SMSService
        -> WhatsAppService

## Maintenance Strategy

Instead of rewriting the system, functionality was extended by implementing the existing interface.

This demonstrates proper software maintenance and adherence to SOLID principles.
