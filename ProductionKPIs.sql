-- Requête pour le Dashboard BI : Efficacité de production (RFT/H)
-- Référence : Catalogue GPRO-TEX - Page 45 (Affichage TV Atelier)

SELECT 
    workshop_name,
    EXTRACT(HOUR FROM production_time) as production_hour,
    SUM(quantity_produced) as total_units,
    -- Calcul du Right First Time (Produits conformes du premier coup)
    (SUM(quantity_compliant) / NULLIF(SUM(quantity_produced), 0)) * 100 as rft_percentage
FROM 
    gpro_production_logs
WHERE 
    production_date = CURRENT_DATE
GROUP BY 
    workshop_name, production_hour
ORDER BY 
    production_hour DESC;