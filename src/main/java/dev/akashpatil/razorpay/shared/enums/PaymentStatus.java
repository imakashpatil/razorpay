package dev.akashpatil.razorpay.shared.enums;
/**
 * Enum representing the status of a payment in the system.
 * This enum is used to indicate the current state of a payment, such as whether it has been created, authorized, captured, failed, cancelled, refunded, or settled.
 */

public enum PaymentStatus {
    CREATED,
    AUTHORIZING,
    AUTHORIZED,
    CAPTURING,
    CAPTURED,
    FAILED,
    CANCELLED,
    REFUNDED,
    PARTIALLY_REFUNDED,
    SETTLED,
    AUTH_EXPIRED
}
