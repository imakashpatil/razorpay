package dev.akashpatil.razorpay.vault.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_vault")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardVault {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cardVaultId;

    @Column(nullable = false , length = 4)
    private String lastFourDigits;

    @Column(nullable = false , length = 6)
    private String bin;

    @Column(nullable = false)
    private byte[] encryptedPan;

    @Column(nullable = false)
    private byte[] encryptedDek;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String expiryMonth;

    @Column(nullable = false)
    private String expiryYear;

    @Column(nullable = false)
    private String cardholderName;

    private LocalDateTime deletedAt;

}
