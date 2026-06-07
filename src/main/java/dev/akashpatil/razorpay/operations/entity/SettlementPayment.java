package dev.akashpatil.razorpay.operations.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "settlement_payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SettlementPayment {
    @EmbeddedId
    SettlementPaymentId  settlementPaymentId;

    @MapsId("settlementId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "settlement_id", nullable = false)
    private Settlement settlementId;
}
