package com.gpro.erp.bi;

import org.springframework.stereotype.Service;

/**
 * Service de Business Intelligence pour l'ERP GPRO-TEX.
 * Ce module permet le pilotage stratégique de la production.
 * Référence : Catalogue GPRO-TEX Standard Edition - Page 47.
 */
@Service
public class BiReportingService {

    /**
     * Calcule le rapport MPS (Master Production Schedule).
     * C'est le ratio entre les charges (Commandes/Prévisions) et la capacité réelle.
     * Objectif : Anticiper les périodes de sur-capacité ou de déficit.
     * * @param plannedLoad Total des heures prévues (OFs + Prévisions)
     * @param actualCapacity Capacité de production disponible
     * @return Le pourcentage d'utilisation de la capacité
     */
    public double calculateMpsRatio(double plannedLoad, double actualCapacity) {
        if (actualCapacity <= 0) {
            return 0.0;
        }
        
        // Formule : (Charges / Capacité) * 100
        double ratio = (plannedLoad / actualCapacity) * 100;
        
        return Math.round(ratio * 100.0) / 100.0; // Arrondi à deux décimales
    }

    /**
     * Analyse l'état de la capacité de production.
     * Aide à la prise de décision stratégique.
     */
    public String getCapacityStatus(double mpsRatio) {
        if (mpsRatio > 100) {
            return "ALERTE : Sur-capacité détectée. Risque de retard.";
        } else if (mpsRatio < 80) {
            return "OPTIMISATION : Sous-capacité. Possibilité d'accepter de nouvelles commandes.";
        } else {
            return "STABLE : Capacité de production optimisée.";
        }
    }
}