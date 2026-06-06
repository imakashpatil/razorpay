package dev.akashpatil.razorpay.shared.enums;
/**
 * Enum representing the status of an order in the system.
 * This enum is used to indicate the current state of an order, such as whether it has been created, paid, attempted, cancelled, or expired.
 */
public enum OrderStatus {
    CREATED,
    PAID,
    ATTEMPTED,
    CANCELLED,
    EXPIRED
}
