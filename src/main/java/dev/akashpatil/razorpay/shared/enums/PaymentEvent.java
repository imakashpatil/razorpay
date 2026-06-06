package dev.akashpatil.razorpay.shared.enums;
/**
 * Enum representing various payment events that can occur in the system.
 * This enum is used to track the different stages and outcomes of payment transactions, such as authorization attempts, captures, refunds, settlements, disputes, and cancellations.
 */

public enum PaymentEvent {
    AUTHORIZE_ATTEMPTED,
    AUTHORIZE_SUCCEEDED,
    AUTHORIZE_FAILED,
    CAPTURE_ATTEMPTED,
    CAPTURE_SUCCEEDED,
    CAPTURE_FAILED,
    REFUND_INITIATED,
    REFUND_SUCCEEDED,
    REFUND_FAILED,
    SETTLEMENT_INITIATED,
    SETTLEMENT_SUCCEEDED,
    SETTLEMENT_FAILED,
    DISPUTE_CREATED,
    DISPUTE_WON,
    DISPUTE_LOST,
    DISPUTE_SETTLED,
    DISPUTE_CANCELLED,
    PAYMENT_CANCELLED,
    CAPTURE_EXPIRED,
    AUTH_EXPIRED
}
