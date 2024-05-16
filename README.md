# CG : Conversion Giraphix

## Description

CG est un outil de conversion de données pour l'outil GIRAPhiX.
Deux types de conversion sont possibles :

    - Excel -> XML : Le XML générer est effectuer sous le format de données de GIRAPHIX.
    - XML -> Excel : Conversion de données de GIRAPHIX, vers un format Excel spécifique. 

### Données GIRAPHIX

Le XSD permettant la visualisation des données de GIRAPHIX est disponible dans `lib/src/main/resources/xsd/giraphix.xsd`.

### Fichier Excel

Un exemple d'Excel, pour la conversion vers les données de GIRAPHIX est présent dans ``documents/Suivi Habilitation BDX_banalisé_Reviser.xls``.

Concernant la transformation des données de GIRAPHIX vers un Excel, un exemple est disponible dans ``/documents/20240111_DGA-SSDI-SDOSD_Catalogue-Emplois_Industriels.xslx``.

## Getting started

Un fichier exécutable est disponible dans le répertoire du projet `/package/CG.exe`, vous pouvez le copier et le coller ou vous le voulez.

Il est possible de générer un nouvel `.exe` en lançant le script `build.bat` disponible à la racine du projet, il va mettre à jour le fichier exécutable présent dans le répertoire `/package`.

Un guide d'utilisation est prensent dans le répertoire `/document`.