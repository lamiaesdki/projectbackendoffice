package com.example.b_office.Config;

import com.example.b_office.model.*;
import com.example.b_office.repositories.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModeFormationRepository modeFormationRepository;
    @Autowired
    private TypeFormationRepository typeFormationRepository;
    @Autowired
    private NiveauFormationRepository niveauFormationRepository;
    @Autowired
    private AnneeFormationRepository anneeFormationRepository;
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private SecteurRepository SecteurRepository;
    @Autowired
    private TypeUORepository typeUORepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private CodeDRRepository codeDRRepository;



    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // Insert default roles if they don't exist
            if (roleRepository.count() == 0) {
                System.out.println("Inserting default roles...");
                roleRepository.save(new Role("ADMIN"));
                roleRepository.save(new Role("DIR_EFP"));
                roleRepository.save(new Role("DIR_CMP"));
                roleRepository.save(new Role("SRIO"));
                roleRepository.save(new Role("DF"));
            } else {
                System.out.println("Roles already exist.");
            }

            // Insert default mode formations if they don't exist
            if (modeFormationRepository.count() == 0) {
                System.out.println("Inserting default mode formations...");
                modeFormationRepository.save(new ModeFormation("cours du jours"));
                modeFormationRepository.save(new ModeFormation("cours de soir"));
            } else {
                System.out.println("Mode formations already exist.");
            }
            if (typeFormationRepository.count() == 0) {
                typeFormationRepository.save(new TypeFormation("Qualifiante"));
                typeFormationRepository.save(new TypeFormation("Diplomante"));
            }
            if (niveauFormationRepository.count() == 0) {
                System.out.println("Inserting default mode formations...");
                niveauFormationRepository.save(new NiveauFormation("TS"));
                niveauFormationRepository.save(new NiveauFormation("T"));
                niveauFormationRepository.save(new NiveauFormation("Q"));
                niveauFormationRepository.save(new NiveauFormation("S"));
            } else {
                System.out.println("niv formations already exist.");
            }
            if (anneeFormationRepository.count() == 0) {
                System.out.println("Inserting default mode formations...");
                anneeFormationRepository.save(new AnneeFormation("1A"));
                anneeFormationRepository.save(new AnneeFormation("2A"));
                anneeFormationRepository.save(new AnneeFormation("3A"));
            } else {
                System.out.println("ans formations already exist.");
            }
            // Insert default secteurs if they don't exist
            if (SecteurRepository.count() == 0) {
                System.out.println("Inserting default secteurs...");
                SecteurRepository.save(new Secteur("Aéronautique", "AE"));
                SecteurRepository.save(new Secteur("Agriculture", "AGRI"));
                SecteurRepository.save(new Secteur("Arts et industrie Graphiques", "AIG"));
                SecteurRepository.save(new Secteur("Artisanat", "ART"));
                SecteurRepository.save(new Secteur("Audiovisuel et Cinéma", "AVC"));
                SecteurRepository.save(new Secteur("Bâtiment et Travaux Publics", "BTP"));
                SecteurRepository.save(new Secteur("CUIR", "CUIR"));
                SecteurRepository.save(new Secteur("Digital et Intelligence Artificielle", "DIA"));
                SecteurRepository.save(new Secteur("Economie verte ", "EV"));
                SecteurRepository.save(new Secteur("Froid et Génie Thermique", "FGT"));
                SecteurRepository.save(new Secteur("Gestion et Commerce", "GC"));
                SecteurRepository.save(new Secteur("Génie électrique", "GE"));
                SecteurRepository.save(new Secteur("Génie Mécanique", "GM"));
                SecteurRepository.save(new Secteur("Métiers de l’Automobile", "MA"));
                SecteurRepository.save(new Secteur("Plasturgie", "PLA"));
                SecteurRepository.save(new Secteur("Santé", "SAN"));
                SecteurRepository.save(new Secteur("Services à la personne", "SAP"));
                SecteurRepository.save(new Secteur("Textile Habillement", "TH"));
                SecteurRepository.save(new Secteur("Tourisme Hôtellerie Restauration", "THR"));

            } else {
                System.out.println("Secteurs already exist.");
            }
            // Insert filieres
            if (filiereRepository.count() == 0) {
                System.out.println("Inserting filieres...");
                List<Filiere> filieres = Arrays.asList(
                        new Filiere("AE_CA_FQ", "Câblage aéronautique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(2), SecteurRepository.getById(1)),
                        new Filiere("AE_IRMC_FQ", "Initiation à la réparation des matériaux Composites", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_ISIA_FQ", "Initiation aux Systèmes d’information en aéronautique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_TCMTS_FQ", "Techniques de contrôle et de mesure en traitement de surface", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_TLA_FQ", "Team leader en aéronautique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_PCMCA_FQ", "Principes de Contrôle des matériaux composites aéronautiques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_INA_FQ", "Initiation à la norme EN9100 en aéronautique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_IRMC_FQ_RCDS", "Initiation à la réparation des matériaux Composites", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_PCMCA_FQ_RCDS", "Principes de Contrôle des matériaux composites aéronautiques", modeFormationRepository.getById(2), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AE_TCMTS_FQ_RCDS", "Techniques de contrôle et de mesure en traitement de surface", modeFormationRepository.getById(2), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(1)),
                        new Filiere("AGRI_DSI_FQ", "Dimensionnement des systèmes d'irrigation", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(2)),
                        new Filiere("AGRI_MPA_FQ", "Marketing des produits Agricoles", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(2)),
                        new Filiere("AGRI_APC_FQ", "Apiculture", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(2)),
                        new Filiere("AGRI_CPB_FQ", "Certification des produits biologiques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(2)),
                        new Filiere("AGRI_CA_FQ", "Conseiller agricole", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(2)),
                        new Filiere("AGRI_PFC_FQ", "Programme de Fertilisation des cultures", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(2)),
                        new Filiere("AIG_TI_FQ", "Traitement des illustrations sur illustrator", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(3)),
                        new Filiere("AIG_TIP_FQ", "Traitement d'image sur photoshop", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(3)),
                        new Filiere("AIG_MI_FQ", "Maquettiste Indesign", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(3)),
                        new Filiere("AIG_MI_FQ_RCDS", "Maquettiste Indesign", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(3)),
                        new Filiere("AIG_TIP_FQ_RCDS", "Traitement d'image sur photoshop", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(3)),
                        new Filiere("AIG_TI_FQ_RCDS", "Traitement des illustrations sur illustrator", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(3)),
                        new Filiere("ART_C3DBJNA_FQ", "Conception 3D en bijouterie-joaillerie, niveau avancé", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_FPMA_FQ", "Fabrication d'un produit de maroquinerie artisanal", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_IC3DBJ_FQ", "Initiation à la conception 3D en bijouterie-joaillerie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_IG_FQ", "Initiation à la gainerie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_PCNCMA_FQ", "Programmation CNC en menuiserie d'art", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_TFP_FQ", "Techniques de fabrication de pouf", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("PRD_ART_FA_FQ", "Ferronnerie d'art", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("PRD_ART_B_FQ", "Bijouterie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_IC3DBJ_FQ_RCDS", "Initiation à la conception 3D en bijouterie-joaillerie", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_C3DBJNA_FQ_RCDS", "Conception 3D en bijouterie-joaillerie, niveau avancé", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_FPMA_FQ_RCDS", "Fabrication d'un produit de maroquinerie artisanal", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_PCNCMA_FQ_RCDS", "Programmation CNC en menuiserie d'art", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_TFP_FQ_RCDS", "Techniques de fabrication de pouf", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_IBA_FQ", "Initiation à la broderie d'art", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_PDTT_FQ", "Préparation d'un dossier technique en tapisserie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_ITT_FQ", "Initiation aux techniques de tissage", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_IFB_FQ", "Initiation à la fabrication des bijoux", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("ART_ITT_FQ_RCDS", "Initiation aux techniques de tissage", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(4)),
                        new Filiere("AVC_AV_TS", "Audiovisuel", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_M3D_FQ", "Modélisation 3D du bâtiment", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_PPB_FQ", "Planification d'un projet en bâtiment", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_SEC_FQ_RCDS", "Superviseur en écoconstruction", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_MOE_FQ_RCDS", "Mode opératoire en écoconstruction", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_SEC_FQ", "Superviseur en écoconstruction", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_RPB_FQ", "Réhabilitation du Patrimoine Bâti", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("BTP_ET_FQ", "Etancheur", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(5)),
                        new Filiere("CUIR_EPR_FQ", "Elaboration du prix de revient (chaussure)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_TPOA_FQ", "Techniques des piqures d'ornementation et d'assemblage", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_MMC_TS", "Management et Méthodes Cuir", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_BEC_T", "Bureau d'étude en cuir", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_GPRC_T", "Gestion de production cuir", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_PC_FQ", "Patronnage chaussure", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_EPR_FQ_RCDS", "Elaboration du prix de revient (chaussure)", modeFormationRepository.getById(2), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_PC_FQ_RCDS", "Patronage chaussure", modeFormationRepository.getById(2), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("CUIR_TPOA_FQ_RCDS", "Techniques des piqures d'ornementation et d'assemblage", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(6)),
                        new Filiere("DIA_ATA_FQ", "Automatisation des tâches d’administartion", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_CIWEB_FQ", "Conception des interfaces Web", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_DFO_FQ", "Déploiement de la fibre optique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_GEV_FQ", "Gestion efficace du versioning", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_LTD_FQ", "L’essentiel des technologies digitales", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_TWF_FQ", "Technologies Web Frontend", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_CDIA_FQ", "Cycle de découverte IA", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_BI_FQ", "Informatique décisionnelle (Business intelligence)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_CGBL_FQ", "Création et gestion des boutiques en ligne", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_GSV_FQ", "Gestion des Serveurs Virtualisés", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_LAIA_FQ", "L’essentiel des applications de l’IA", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_MASM_FQ", "Manager Agile Scrum Master", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_DWBP_FQ", "Développement Web Backend en Python", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_ASLW_FQ", "Administration système Linux et Windows", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("DIA_WT_FQ", "Web Technologies", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(7)),
                        new Filiere("EV_OGDD_Q", "Ouvrier de Gestion des déchets et dépollution", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("EV_GDD_TS", "Gestion des déchets et dépollution", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("EV_EPA_TS", "Eau potable et assainissement", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("EV_AEE_Q", "Agent d’Exploitation de l’Eau", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("EV_GDC_FQ", "Gestion des déchets de chantier", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("EV_GD_FQ_RCDS", "Gestion des déchets", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("EV_GDC_FQ_RCDS", "Gestion des déchets de chantier", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(8)),
                        new Filiere("PRD_FGT_MDF_FQ", "Monteur Dépanneur frigoriste", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(9)),
                        new Filiere("FGT_ECSVHB_FQ_RCDS", "Etude et conception des systèmes de la ventilation hygiénique dans le bâtiment", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(9)),
                        new Filiere("FGT_EEBVP_FQ_RCDS", "Efficacité énergétique dans le bâtiment : Volet passif et optimisation du besoin bioclimatique", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(9)),
                        new Filiere("FGT_TTITB_FQ_RCDS", "Techniques et Technologies de l'isolation thermique dans le bâtiment", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(9)),
                        new Filiere("FGT_EEBEIS_FQ", "Efficacité énergétique dans le bâtiment : Etude et installation des systèmes de récupération des calories", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(9)),
                        new Filiere("FGT_EEBVP_FQ", "Efficacité énergétique dans le bâtiment : Volet passif et optimisation du besoin bioclimatique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(9)),
                        new Filiere("GC_EPA_FQ", "Les écrits professionnels et administratifs", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(10)),
                        new Filiere("GC_EPA_FQ_RCDS", "Les écrits professionnels et administratifs", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(10)),
                        new Filiere("GC_ENP_FQ", "Entrepreneuriat", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(10)),
                        new Filiere("GC_COB_FQ", "Conseiller en opérations bancaires", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(10)),
                        new Filiere("GE_NRLER_FQ", "Normes et réglementations liées aux énergies renouvelables", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_SIBAP_FQ", "Systèmes industriels à base d'automates programmables", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_RI_FQ", "Robots industriels", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_DIEBT_FQ", "Dimensionnement d'une installation électrique BT", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_SSP_FQ", "Systèmes solaires photovoltaïques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_SGBI_FQ", "Systèmes de gestion de bâtiments intelligents (La domotique)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_DIEBT_FQ_RCDS", "Dimensionnement d'une installation électrique BT", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_NRLER_FQ_RCDS", "Normes et réglementations liées aux énergies renouvelables", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_RI_FQ_RCDS", "Robots industriels", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_SGBI_FQ_RCDS", "Systèmes de gestion de bâtiments intelligents (La domotique)", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_SIBAP_FQ_RCDS", "Systèmes industriels à base d'automates programmables", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_SSP_FQ_RCDS", "Systèmes solaires photovoltaïques", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GE_ME_FQ", "Mechatronics", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(11)),
                        new Filiere("GM_ACADA_FQ", "AutoCAD - Autodesk (niveau avancé)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_ACADI_FQ", "AutoCAD - Autodesk (niveau initiation)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_AP3DTICP_FQ", "Autodesk Plant 3D : Tuyauterie industrielle – Concepts de base", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_V5MDA_FQ", "CATIA V5 : Mechanical Design (niveau avancé)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_V5GSDI_FQ", "CATIA V5 : Generative Chape Design GSD (niveau initiation)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_V5GSDA_FQ_RCDS", "CATIA V5 : Generative Chape Design GSD (niveau avancé)", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_V5GSDI_FQ_RCDS", "CATIA V5 : Generative Chape Design GSD (niveau initiation)", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_V5MDA_FQ_RCDS", "CATIA V5 : Mechanical Design (niveau avancé)", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_V5MDI_FQ_RCDS", "CATIA V5 : Mechanical Design (niveau initiation)", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_TM_FQ", "Tuyauteur métallique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_CBPT_FQ", "Contrôle par Bras Polyarticulé Tridimentionnel", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_INVI_FQ", "Inventor - Autodesk (niveau initiation)", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("GM_CMMTA_FQ", "Contrôle par machine de mesure Tridimentionnelle MMT Automatique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(12)),
                        new Filiere("PRD_MA_CP_FQ", "Carrosserie peinture", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(13)),
                        new Filiere("PRD_MA_MAT_FQ", "Mécanique à deux temps", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(13)),
                        new Filiere("MA_AT_FQ", "Automobile Technology", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(13)),
                        new Filiere("PLA_TMPCGD_FQ", "Techniques de moulage de pièces composites grande diffusion", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_IRMPC_FQ", "Initiation à la réalisation d’un moule pour pièce composite", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_ITETP_FQ", "Initiation aux Techniques d'extrusion tube et profil", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_TIP_FQ", "Techniques d'injection plastique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_PTETP_FQ", "Perfectionnement aux Techniques d’extrusions tube et profil", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_TMPC_FQ", "Techniques de moulage de pièces composites", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_TRMIP_FQ", "Techniques de réglage des machines à injection plastique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("PLA_TUELC_FQ", "Techniques d'utilisation des équipements de laboratoire en chimie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(14)),
                        new Filiere("SAN_GMAO_FQ", "GMAO dans les établissement de santé", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(15)),
                        new Filiere("SANT_MMM_FQ", "Maintenance des moniteurs multiparamétriques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(15)),
                        new Filiere("SAN_CQDM_FQ", "Contrôle qualité des dispositifs médicaux", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(15)),
                        new Filiere("SAN_CQDM_FQ_RCDS", "Contrôle qualité des dispositifs médicaux", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(15)),
                        new Filiere("SAN_GMAO_FQ_RCDS", "GMAO dans les établissements de santé", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(15)),
                        new Filiere("SANT_MMM_FQ_RCDS", "Maintenance des moniteurs multiparamétriques", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(15)),
                        new Filiere("SAP_EPBS_FQ", "Esthétique personnes aux besoins spécifiques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(16)),
                        new Filiere("SAP_HPE_FQ", "L'hygiène chez la petite enfance", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(16)),
                        new Filiere("SAP_PEBS_FQ", "Petite enfance aux besoins spécifiques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(16)),
                        new Filiere("PRD_SAP_EST_FQ", "Esthétique", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(16)),
                        new Filiere("TH_TGIB_FQ", "Transformation et gradation Image de base", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_DPVB_FQ", "Développement de prototype des vêtements bas", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_DPCR_FQ", "Développement de prototype des chemisier et robes", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_PP_FQ", "Planification de la production", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_AP_FQ", "Agent de placement", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_AP_FQ_RCDS", "Agent de placement", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_DPCR_FQ_RCDS", "Développement de prototype des chemisier et robes", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_DPVB_FQ_RCDS", "Développement de prototype des vêtements bas", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_PP_FQ_RCDS", "Planification de la production", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("TH_TGIB_FQ_RCDS", "Transformation et gradation Image de base", modeFormationRepository.getById(2), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(17)),
                        new Filiere("THR_CFTR_FQ", "Conception d'une fiche technique en restauration", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_CPT_FQ", "Cotation des produits touristiques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_CJFO_THR", "La clôture journalière Front office", modeFormationRepository.getById(1), typeFormationRepository.getById(2), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_MRCT_FQ", "Management des risques dans les circuits touristiques", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_PC_FQ", "Préparateur de café", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_SB_FQ", "Service banquet", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_SN_FQ", "Snacking", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_VN_FQ", "Viennoiserie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_MHCCPR_FQ", "La méthode HACCP en restauration", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_BLG_FQ", "Boulangerie", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_GSFB_FQ", "La gestion des stocks F&B", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_GHOS_FQ", "Gouvernante des hébergements des œuvres sociales", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_CO_FQ", "Cooking", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_PCO_FQ", "Pastry-Confectionery", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_DPSTHR_FQ", "Développement personnel dans le Secteur THR", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_CSISTHR_FQ", "Créativité et sens de l’innovation dans le Secteur THR", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_LSTHR_FQ", "Leadership dans le Secteur THR", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_MPSTHR_FQ", "Management de projets dans le Secteur THR", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_ESETHR_FQ", "Excellence du service dans les entreprises THR", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18)),
                        new Filiere("THR_MISTHR_FQ", "Management de l’interculturalité dans le Secteur THR", modeFormationRepository.getById(1), typeFormationRepository.getById(1), niveauFormationRepository.getById(1), anneeFormationRepository.getById(1), SecteurRepository.getById(18))
                );
                filiereRepository.saveAll(filieres);
            } else {
                System.out.println("Filieres already exist.");
            }
// Insert default Type UOs if they don't exist
            if (typeUORepository.count() == 0) {
                System.out.println("Inserting default Type UOs...");

                typeUORepository.save(new TypeUO("DC"));
                typeUORepository.save(new TypeUO("DR"));
                typeUORepository.save(new TypeUO("CMP"));
                typeUORepository.save(new TypeUO("EFP"));
                System.out.println("Type UOs inserted successfully.");
            } else {
                System.out.println("Type UOs already exist.");
            }

            // Insert default regions if they don't exist
            if (regionRepository.count() == 0) {
                System.out.println("Inserting default regions...");

                Optional<TypeUO> drOptional = typeUORepository.findByName("DR");
                TypeUO dr = drOptional.orElseThrow(() -> new RuntimeException("TypeUO 'DR' not found"));

                // Save CodeDRs and associate them with regions
                CodeDR casablancaSettat = new CodeDR("Z", "Casablanca-Settat", dr);
                Region regionCasablancaSettat = new Region("Casablanca-Settat", casablancaSettat);
                codeDRRepository.save(casablancaSettat);
                regionRepository.save(regionCasablancaSettat);
                casablancaSettat.setRegion(regionCasablancaSettat);
                codeDRRepository.save(casablancaSettat);

                CodeDR fesMeknes = new CodeDR("R", "Fès-Meknès", dr);
                Region regionFesMeknes = new Region("Fès-Meknès", fesMeknes);
                codeDRRepository.save(fesMeknes);
                regionRepository.save(regionFesMeknes);
                fesMeknes.setRegion(regionFesMeknes);
                codeDRRepository.save(fesMeknes);

                CodeDR draaTafilalet = new CodeDR("T", "Drâa-Tafilalet", dr);
                Region regionDraaTafilalet = new Region("Drâa-Tafilalet", draaTafilalet);
                codeDRRepository.save(draaTafilalet);
                regionRepository.save(regionDraaTafilalet);
                draaTafilalet.setRegion(regionDraaTafilalet);
                codeDRRepository.save(draaTafilalet);

                CodeDR beniMellalKhenifra = new CodeDR("N", "Béni Mellal-Khénifra", dr);
                Region regionBeniMellalKhenifra = new Region("Béni Mellal-Khénifra", beniMellalKhenifra);
                codeDRRepository.save(beniMellalKhenifra);
                regionRepository.save(regionBeniMellalKhenifra);
                beniMellalKhenifra.setRegion(regionBeniMellalKhenifra);
                codeDRRepository.save(beniMellalKhenifra);

                CodeDR rabatSaleKenitra = new CodeDR("P", "Rabat-Salé-Kénitra", dr);
                Region regionRabatSaleKenitra = new Region("Rabat-Salé-Kénitra", rabatSaleKenitra);
                codeDRRepository.save(rabatSaleKenitra);
                regionRepository.save(regionRabatSaleKenitra);
                rabatSaleKenitra.setRegion(regionRabatSaleKenitra);
                codeDRRepository.save(rabatSaleKenitra);

                CodeDR tangerTetouanAlHoceima = new CodeDR("Q", "Tanger-Tétouan-Al Hoceïma", dr);
                Region regionTangerTetouanAlHoceima = new Region("Tanger-Tétouan-Al Hoceïma", tangerTetouanAlHoceima);
                codeDRRepository.save(tangerTetouanAlHoceima);
                regionRepository.save(regionTangerTetouanAlHoceima);
                tangerTetouanAlHoceima.setRegion(regionTangerTetouanAlHoceima);
                codeDRRepository.save(tangerTetouanAlHoceima);

                CodeDR oriental = new CodeDR("S", "Oriental", dr);
                Region regionOriental = new Region("Oriental", oriental);
                codeDRRepository.save(oriental);
                regionRepository.save(regionOriental);
                oriental.setRegion(regionOriental);
                codeDRRepository.save(oriental);

                CodeDR guelmimOuedNoun = new CodeDR("U", "Guelmim-Oued Noun", dr);
                Region regionGuelmimOuedNoun = new Region("Guelmim-Oued Noun", guelmimOuedNoun);
                codeDRRepository.save(guelmimOuedNoun);
                regionRepository.save(regionGuelmimOuedNoun);
                guelmimOuedNoun.setRegion(regionGuelmimOuedNoun);
                codeDRRepository.save(guelmimOuedNoun);

                CodeDR laayouneSakiaElHamra = new CodeDR("Y", "Laâyoune-Sakia El Hamra", dr);
                Region regionLaayouneSakiaElHamra = new Region("Laâyoune-Sakia El Hamra", laayouneSakiaElHamra);
                codeDRRepository.save(laayouneSakiaElHamra);
                regionRepository.save(regionLaayouneSakiaElHamra);
                laayouneSakiaElHamra.setRegion(regionLaayouneSakiaElHamra);
                codeDRRepository.save(laayouneSakiaElHamra);

                CodeDR dakhlaOuedEdDahab = new CodeDR("W", "Dakhla-Oued Ed Dahab", dr);
                Region regionDakhlaOuedEdDahab = new Region("Dakhla-Oued Ed Dahab", dakhlaOuedEdDahab);
                codeDRRepository.save(dakhlaOuedEdDahab);
                regionRepository.save(regionDakhlaOuedEdDahab);
                dakhlaOuedEdDahab.setRegion(regionDakhlaOuedEdDahab);
                codeDRRepository.save(dakhlaOuedEdDahab);

                CodeDR soussMassa = new CodeDR("K", "Souss-Massa", dr);
                Region regionSoussMassa = new Region("Souss-Massa", soussMassa);
                codeDRRepository.save(soussMassa);
                regionRepository.save(regionSoussMassa);
                soussMassa.setRegion(regionSoussMassa);
                codeDRRepository.save(soussMassa);

                CodeDR marrakechSafi = new CodeDR("L", "Marrakech-Safi", dr);
                Region regionMarrakechSafi = new Region("Marrakech-Safi", marrakechSafi);
                codeDRRepository.save(marrakechSafi);
                regionRepository.save(regionMarrakechSafi);
                marrakechSafi.setRegion(regionMarrakechSafi);
                codeDRRepository.save(marrakechSafi);

                System.out.println("Regions inserted successfully.");
            } else {
                System.out.println("Regions already exist.");
            }
            /*
            if (directionRepository.count() == 0) {
                System.out.println("Inserting default Directions...");
                List<Direction> directions = Arrays.asList(
                        directionRepository.save(new Direction("DRH", "Direction des Ressources Humaines", typeUORepository.getById(1), null)));
                directionRepository.save(new Direction("DF", "Direction de la Formation", typeUORepository.getById(1), null));
                directionRepository.save(new Direction("DRIF", "DRIF", typeUORepository.getById(1), null));
                directionRepository.save(new Direction("DOSI", "Direction Organisation et Système d'Information", typeUORepository.getById(1), null));
                directionRepository.save(new Direction("DACG", "Direction d'Audit et du Contrôle de Gestion", typeUORepository.getById(1), null));
                directionRepository.save(new Direction("Z", "Casablanca-Settat", typeUORepository.getById(2), regionRepository.getById(1)));
                directionRepository.save(new Direction("R", "Fès-Meknès", typeUORepository.getById(2), regionRepository.getById(2)));
                directionRepository.save(new Direction("T", "Drâa-Tafilalet", typeUORepository.getById(2), regionRepository.getById(3)));
                directionRepository.save(new Direction("N", "Béni Mellal-Khénifra", typeUORepository.getById(2), regionRepository.getById(4)));
                directionRepository.save(new Direction("P", "Rabat-Salé-Kénitra", typeUORepository.getById(2), regionRepository.getById(5)));
                directionRepository.save(new Direction("Q", "Tanger-Tétouan-Al Hoceïma", typeUORepository.getById(2), regionRepository.getById(6)));
                directionRepository.save(new Direction("S", "Oriental", typeUORepository.getById(2), regionRepository.getById(7)));
                directionRepository.save(new Direction("U", "Provinces du Sud", typeUORepository.getById(2), regionRepository.getById(8)));
                directionRepository.save(new Direction("K", "Souss-Massa", typeUORepository.getById(2), regionRepository.getById(11)));
                directionRepository.save(new Direction("L", "Marrakech-Safi", typeUORepository.getById(2), regionRepository.getById(12)));

                directionRepository.saveAll(directions);
                System.out.println("directions inserted successfully.");
            } else {
                System.out.println("Directions already exist.");
            }
            if (complexeRepository.count() == 0) {
                System.out.println("Inserting default Directions...");
                List<Complexe> complexes = Arrays.asList(
                        complexeRepository.save(new Complexe("FGG0", "CF TOURISME CASABLANCA", codeDRRepository.getById(1))));
                complexeRepository.save(new Complexe("FLL0", "CF TRANSPORT LOGISTIQUE ET AUTOMOBILE CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("FDD0", "CF ANFA CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("FHH0", "CF INDUSTRIEL HAY HASSANI CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("FJJ0", "CF MEDIOUNA CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("FMM0", "CF TERTIAIRE HAY HASSANI CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("FRR0", "CF AIN CHOCK CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("FVV0", "CF MOULAY RACHID CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("MFF0", "CF EL FIDA CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NOU7", "IS MET.AER.LOG.AEROP.NOUA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("QTT0", "CF TANGER 1", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("EII0", "CF MOHAMMADIA I", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("EBB0", "CF TERTIAIRE AIN SEBAA HAY MOHAMMEDI CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("ECC0", "CF TERTIAIRE 2", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("EEE0", "CF BATIMENT CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("EKK0", "CF BERNOUSSI CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("EOO0", "CF INDUSTRIEL AIN SEBAA HAY MOHAMMEDI CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("EPP0", "CF BEN M'SIK CASABLANCA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("ESS0", "CF TEXT.CONF.CUIR B.MSIK", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NOU6", "CF AGRO-PLAST", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("LRR0", "CF BEN GUERIR", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("NO26", "EFP CENTRE QUALIFICATION METIERS ARTISANAT", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("NO30", "EFP ISTA MISSOUR", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("R200", "CF ROUTE IMOUZER FES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("R300", "CF TERTIAIRE", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("R740", "IFMOTICA FES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("RAA0", "CF CONFECTION FES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("RBB0", "CF TAZA", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("RDD0", "CF SOCIAL FES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("REE0", "CF BATIMENT FES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("RGG0", "CF SEFROU", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("RHH0", "CF TAOUNATE", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("NO11", "INS.INDUST.AGRALIMEN.MEKN", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("NO12", "ISTHT MEKNES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("PTT0", "CF AIN AOUDA TAMESNA", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("TGG0", "CF MEKNES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("THH0", "CF ROUTE AGOURAI MEKNES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("TII0", "CF MOYEN ATLAS", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("TJJ0", "CF ERRACHIDIA", codeDRRepository.getById(3)));
                complexeRepository.save(new Complexe("TKK0", "CF KHENIFRA", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("TNN0", "CF ROUTE DE FES", codeDRRepository.getById(2)));
                complexeRepository.save(new Complexe("NAA0", "CF BEN SLIMANE_BOUZNIKA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NBB0", "CF SETTAT", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NDD0", "CF KHOURIBGA", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("NEE0", "CF OUED ZEM BOUJAAD", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("NFF0", "CF BERRECHID", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NGG0", "CF BENI_MELLAL 1", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("NJJ0", "CF FBS SOUK SEBT", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("NKK0", "CF GRAND ATLAS", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("NLL0", "CF BEN AHMED", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NO21", "ECOLE DU METIER BTP SETAT", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NO22", "ISTA SIDI SLIMANE", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("P980", "INC PR.HERT.MY EL HASSAN", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PFF0", "CF HAY NAHDA RABAT", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PGG0", "CF YM RABAT", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PHH0", "CF KHEMISSET", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PII0", "CF.MAAMORA KENITRA", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PJJ0", "CF HAY RIAD RABAT", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PKK0", "CF SALE I", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PLL0", "CF SIDI KACEM", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PMM0", "CF TEMARA", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PNN0", "CF SEBOU SAKNIA KENITRA", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("POO0", "CF SALE II", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("PMSP", "CF Guich Loudaya", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("ZUU0", "CF MOHAMMADIA II", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("Q910", "CF. TETOUAN", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QCH0", "CF CHEFCHAOUEN OUZZANE", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QFF0", "CF MDIQ FNIDEQ", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QII0", "CF.AL HOCEIMA", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QKK0", "CF TANGER2", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QLL0", "CF.LARACHE KSAR KEBIR", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QNN0", "CF TEXTILE CONF TANGER", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QOO0", "CF.INDUST.TRANS.RT.TANGER", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("QT20", "CF TETOUAN 2", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("NO27", "CF TAOURIRT", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("SNN0", "CF.NADOR", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("SOO0", "CF. OUJDA 1", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("SPP0", "CF.SOCIAL OUJDA", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("SQQ0", "CF. OUJDA 2", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("SRR0", "CF BERKANE", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("SSS0", "CF BOUARFA", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("U400", "CF DAKHLA", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("UKK0", "CF LAAYOUNE", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("ULL0", "CF GUELMIME", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("UMM0", "CF TAN TAN", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("UNN0", "CF MIR LEFT SIDI IFNI", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("KII0", "CF INZGANE AIT MELLOUL", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("KOO0", "CF. TOURISME AGADIR", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("KPP0", "CF AGADIR", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("KQN0", "ISTA TATA", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("KQQ0", "CF OUARZAZATE", codeDRRepository.getById(3)));
                complexeRepository.save(new Complexe("KRR0", "CF TAROUDANT OULED TEIMA", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("KTT0", "CF TIZNIT TAFRAOUT", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("NO10", "CF SOCIAL AGADIR", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("FRT0", "ISFO", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("NO14", "ISTA TINGHIR", codeDRRepository.getById(3)));
                complexeRepository.save(new Complexe("NO15", "ISTA ZAGORA", codeDRRepository.getById(3)));
                complexeRepository.save(new Complexe("LGG0", "CF AZEMMOUR SIDI BENNOUR", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("CQFF0", "CFIJ FAHS ANJRA", codeDRRepository.getById(6)));
                complexeRepository.save(new Complexe("L040", "CDC H.TOURISME MARRAKECH", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LBB0", "CF IND ET BAT MARRAKECH", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LCC0", "CF AZLI MARRAKECH", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LDD0", "CF TERTIAIRE MARRAKECH", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LEE0", "CF SAFI", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LHH0", "CF EL JADIDA", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("LII0", "CF ESSAOUIRA", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LJM0", "PRD CFP PL KALAA", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("LKK0", "CF TOURISME MARRAKECH", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("NO16", "ITA YOUSSOUFIA", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("UOO0", "CF AL WAHDA LAAYOUNE", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("NO20", "ISTA KALAA", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("PC10", "CITE DES METIERS ET DES COMPETENCES RABAT", codeDRRepository.getById(5)));
                complexeRepository.save(new Complexe("EC10", "Cité des métiers et des compétences Casablanca-Settat", codeDRRepository.getById(1)));
                complexeRepository.save(new Complexe("KC10", "Cité des Métiers et des Compétences Agadir", codeDRRepository.getById(9)));
                complexeRepository.save(new Complexe("UC10", "Cité des Métiers et des Compétences Laayoune", codeDRRepository.getById(8)));
                complexeRepository.save(new Complexe("SC10", "Cité des Métiers et des Compétences Nador", codeDRRepository.getById(7)));
                complexeRepository.save(new Complexe("NHH0", "CF BENI_MELLAL 2", codeDRRepository.getById(4)));
                complexeRepository.save(new Complexe("PPP0", "CF du Transport, de la Logistique et de l'industrie de l'automobile Kenitra", codeDRRepository.getById(5)));
                complexeRepository.saveAll(complexes);
                System.out.println("directions inserted successfully.");
            } else {
                System.out.println("Directions already exist.");
            }

            if (etablissementRepository.count() == 0) {
                System.out.println("Inserting default Directions...");
                List<Etablissement> etablissements = Arrays.asList(
                        etablissementRepository.save(new Etablissement("EOT0", "ACADEMIE DES ARTS TRADITIONNELS DE LA MOSQUEE HASSAN II CASABLANCA", complexeRepository.getById(17), codeDRRepository.getById(1))));
                etablissementRepository.save(new Etablissement("S920", "ASSOCIATION ARRAJAE POUR LA SAUVEGARDE DE L'ENFANCE", complexeRepository.getById(78), codeDRRepository.getById(7)));
                etablissementRepository.save(new Etablissement("P460", "CENTRE ASSOCIATION DE L'ENTRAIDE FAMILLIALE RABAT", complexeRepository.getById(55), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("P470", "CENTRE ASSOCIATION PROTECTION DE LA FAMILLE MAROCAINE RABAT", complexeRepository.getById(55), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("EGI0", "CENTRE D'ACCUEIL CASABLANCA", complexeRepository.getById(1), codeDRRepository.getById(1)));
                etablissementRepository.save(new Etablissement("Q810", "CENTRE DE CONSOLIDATION DES COMPÉTENCES DE LA FEMME CHEFCHAOUEN", complexeRepository.getById(67), codeDRRepository.getById(6)));
                etablissementRepository.save(new Etablissement("PMV0", "CENTRE DE DEVELOPPEMENT DES COMPETENCES DES JEUNES AL MASSIRA TEMARA", complexeRepository.getById(61), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("L104", "CENTRE DE DEVELOPPEMENT DES COMPETENCES EN HOTELLERIE ET TOURISME MARRAKECH", complexeRepository.getById(100), codeDRRepository.getById(12)));
                etablissementRepository.save(new Etablissement("R650", "CENTRE DE DEVELOPPEMENT HUMAIN AIN KADDOUS FES", complexeRepository.getById(29), codeDRRepository.getById(2)));
                etablissementRepository.save(new Etablissement("R750", "CENTRE DE FORMATION AIN NOKBI FES", complexeRepository.getById(27), codeDRRepository.getById(2)));
                etablissementRepository.save(new Etablissement("Q950", "CENTRE DE FORMATION ARD DAWLA TANGER", complexeRepository.getById(73), codeDRRepository.getById(6)));
                etablissementRepository.save(new Etablissement("PMS0", "CENTRE DE FORMATION DANS LES METIERS DE L’HOTELLERIE ET DU TOURISME GUICH LOUDAYA TEMARA", complexeRepository.getById(64), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("TMB0", "CENTRE DE FORMATION DANS LES METIERS DU BATIMENT MEKNES", complexeRepository.getById(37), codeDRRepository.getById(2)));
                etablissementRepository.save(new Etablissement("Q520", "CENTRE DE FORMATION DE LA FEMME MARTIL", complexeRepository.getById(74), codeDRRepository.getById(6)));
                etablissementRepository.save(new Etablissement("Q530", "CENTRE DE FORMATION DE LA FEMME TETOUAN", complexeRepository.getById(74), codeDRRepository.getById(6)));
                etablissementRepository.save(new Etablissement("EEG0", "CENTRE DE FORMATION DES ADULTES SIDI MOUMEN CASA", complexeRepository.getById(16), codeDRRepository.getById(1)));
                etablissementRepository.save(new Etablissement("RBF0", "CENTRE DE FORMATION DES ARTS CULINAIRES TAZA", complexeRepository.getById(28), codeDRRepository.getById(2)));
                etablissementRepository.save(new Etablissement("Q560", "CENTRE DE FORMATION DES FEMMES MGHOUGHA TANGER", complexeRepository.getById(11), codeDRRepository.getById(6)));
                etablissementRepository.save(new Etablissement("PMW0", "CENTRE DE FORMATION DES FEMMES OULED METAA", complexeRepository.getById(61), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("PIO0", "CENTRE DE FORMATION DES FEMMES OULED OUJIH KENITRA", complexeRepository.getById(57), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("PIN0", "CENTRE DE FORMATION DES FEMMES SAKNIA KENITRA", complexeRepository.getById(62), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("E100", "CENTRE DE FORMATION DES JEUNES DANS LES METIERS DE LA REPARATION ET DE L'AUTOMOBILE SIDI OTHMANE MY RCHID CASABLANCA", complexeRepository.getById(8), codeDRRepository.getById(1)));
                etablissementRepository.save(new Etablissement("PXB0", "CENTRE DE FORMATION DES JEUNES SKHIRAT", complexeRepository.getById(35), codeDRRepository.getById(5)));
                etablissementRepository.save(new Etablissement("KQS0", "INSTITUT SPECIALISE DANS LES METIERS DU CINEMA OUARZAZATE", complexeRepository.getById(91), codeDRRepository.getById(3)));


                etablissementRepository.saveAll(etablissements);


            } else {
                System.out.println("Directions already exist.");
            }
            // Create Uo entries for all combinations of Etablissement, Complexe, and Direction
            List<Etablissement> etablissements = etablissementRepository.findAll();
            List<Complexe> complexes = complexeRepository.findAll();
            List<Direction> directions = directionRepository.findAll();


           /* for (Etablissement etablissement : etablissements) {
                for (Complexe complexe : complexes) {
                    for (Direction direction : directions) {
                        Uo uo = new Uo();
                        uo.setIntituler(etablissement.getName() + " - " + complexe.getName() + " - " + direction.getName());
                        uo.setEtablissement(etablissement);
                        uo.setComplexe(complexe);
                        uo.setDirection(direction);
                        uo.setTypeUO(direction.getTypeUO());

                        uo.setRegion(direction.getRegion());
                        uoRepository.save(uo);
                    }
                }
            }*/

            System.out.println("Uo entries created successfully.");
        };
        };
    }
