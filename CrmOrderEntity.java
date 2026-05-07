package com.gpro.erp.crm;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gpro_crm_orders")
public class CrmOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerName;
    private Double amount;
    private LocalDateTime orderDate;
}