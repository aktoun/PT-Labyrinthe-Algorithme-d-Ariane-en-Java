# PT21_APL2018 - Makefile
# ---
# AUTEUR : NICOLAS FAFIN
# AUTEUR : ANTOINE MAN
# VERSION : X

# BUT FINAL

but: src/modele/Main.class


# VARIABLES

JC = javac


JFLAGS = -implicit:none -encoding UTF-8


# DEPENDANCES ALGORITHME

src/algorithme/AlgoAleaManuelle.class: src/algorithme/AlgoAleaManuelle.java
	$(JC) $(JFLAGS) ./src/algorithme/AlgoAleaManuelle.java


src/algorithme/AlgoDeter.class: src/algorithme/AlgoDeter.java
	$(JC) $(JFLAGS) ./src/algorithme/AlgoDeter.java


src/algorithme/AlgorithmeAlea.class: src/algorithme/AlgorithmeAlea.java
	$(JC) $(JFLAGS) ./src/algorithme/AlgorithmeAlea.java


# DEPENDANCES CONTROLEUR

src/controleur/ActionGrille.class: src/controleur/ActionGrille.java
	$(JC) $(JFLAGS) ./src/controleur/ActionGrille.java


src/controleur/ActionMenu.class: src/controleur/ActionMenu.java \
			src/modele/LireFichier.class \
			src/vue/MenuGrille.class
	$(JC) $(JFLAGS) ./src/controleur/ActionMenu.java


src/controleur/ActionSauvegarder.class: src/controleur/ActionSauvegarder.java \
			src/modele/EcrireFichier.class
	$(JC) $(JFLAGS) ./src/controleur/ActionSauvegarder.java


src/controleur/ClicSourisGrille.class: src/controleur/ClicSourisGrille.java
	$(JC) $(JFLAGS) ./src/controleur/ClicSourisGrille.java


src/controleur/DonneesGrilleExistante.class: src/controleur/DonneesGrilleExistante.java \
			src/vue/GrilleExistanteDefinitive.class
	$(JC) $(JFLAGS) ./src/controleur/DonneesGrilleExistante.java


src/controleur/DonneesMenuGrille.class: src/controleur/DonneesMenuGrille.java \
			src/modele/CreerGrille.class
	$(JC) $(JFLAGS) ./src/controleur/DonneesMenuGrille.java


src/controleur/ExecutionAlgo.class: src/controleur/ExecutionAlgo.java \
			src/algorithme/AlgoDeter.class \
			src/algorithme/AlgorithmeAlea.class \
			src/vue/GrilleManuelleAlea.class \
			src/vue/GrilleManuelleDeter.class
	$(JC) $(JFLAGS) ./src/controleur/ExecutionAlgo.java


src/controleur/ToucheEntreeAlea.class: src/controleur/ToucheEntreeAlea.java \
			src/algorithme/AlgoAleaManuelle.class
	$(JC) $(JFLAGS) ./src/controleur/ToucheEntreeAlea.java


src/controleur/ToucheEntreeDeter.class: src/controleur/ToucheEntreeDeter.java \
			src/algorithme/AlgoDeter.class
	$(JC) $(JFLAGS) ./src/controleur/ToucheEntreeDeter.java


src/controleur/TypeEntre.class: src/controleur/TypeEntre.java
	$(JC) $(JFLAGS) ./src/controleur/TypeEntre.java


src/controleur/Validation.class: src/controleur/Validation.java \
			src/vue/GrilleExecutionAlgo.class
	$(JC) $(JFLAGS) ./src/controleur/Validation.java


# DEPENDANCES VUE.BACKGROUND

src/vue/background/BackgroundGrille.class: src/vue/background/BackgroundGrille.java
	$(JC) $(JFLAGS) ./src/vue/background/BackgroundGrille.java


src/vue/background/BackgroundGrilleAlgo.class: src/vue/background/BackgroundGrilleAlgo.java
	$(JC) $(JFLAGS) ./src/vue/background/BackgroundGrilleAlgo.java


src/vue/background/BackgroundGrilleExistante.class: src/vue/background/BackgroundGrilleExistante.java
	$(JC) $(JFLAGS) ./src/vue/background/BackgroundGrilleExistante.java


src/vue/background/BackgroundMenu.class: src/vue/background/BackgroundMenu.java
	$(JC) $(JFLAGS) ./src/vue/background/BackgroundMenu.java


# DEPENDANCES VUE

src/vue/DessinerTypeCase.class: src/vue/DessinerTypeCase.java
	$(JC) $(JFLAGS) ./src/vue/DessinerTypeCase.java


src/vue/GrilleAlea.class: src/vue/GrilleAlea.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ActionSauvegarder.class \
			src/controleur/ClicSourisGrille.class \
			src/controleur/Validation.class \
			src/vue/background/BackgroundGrille.class
	$(JC) $(JFLAGS) ./src/vue/GrilleAlea.java


src/vue/GrilleExecutionAlgo.class: src/vue/GrilleExecutionAlgo.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ExecutionAlgo.class \
			src/vue/background/BackgroundGrilleAlgo.class
	$(JC) $(JFLAGS) ./src/vue/GrilleExecutionAlgo.java


src/vue/GrilleExistante.class: src/vue/GrilleExistante.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ActionSauvegarder.class \
			src/controleur/ClicSourisGrille.class \
			src/controleur/DonneesGrilleExistante.class \
			src/vue/background/BackgroundGrilleExistante.class
	$(JC) $(JFLAGS) ./src/vue/GrilleExistante.java


src/vue/GrilleExistanteDefinitive.class: src/vue/GrilleExistanteDefinitive.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ExecutionAlgo.class \
			src/vue/background/BackgroundGrille.class
	$(JC) $(JFLAGS) ./src/vue/GrilleExistanteDefinitive.java


src/vue/GrilleManuelleAlea.class: src/vue/GrilleManuelleAlea.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ToucheEntreeAlea.class \
			src/vue/background/BackgroundGrilleAlgo.class
	$(JC) $(JFLAGS) ./src/vue/GrilleManuelleAlea.java


src/vue/GrilleManuelleDeter.class: src/vue/GrilleManuelleDeter.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ToucheEntreeDeter.class \
			src/vue/background/BackgroundGrilleAlgo.class
	$(JC) $(JFLAGS) ./src/vue/GrilleManuelleDeter.java


src/vue/GrilleVide.class: src/vue/GrilleVide.java \
			src/vue/DessinerTypeCase.class \
			src/controleur/ActionGrille.class \
			src/controleur/ActionSauvegarder.class \
			src/controleur/ClicSourisGrille.class \
			src/controleur/Validation.class \
			src/vue/background/BackgroundGrille.class
	$(JC) $(JFLAGS) ./src/vue/GrilleVide.java


src/vue/Menu.class: src/vue/Menu.java \
			src/controleur/ActionMenu.class \
			src/vue/background/BackgroundMenu.class
	$(JC) $(JFLAGS) ./src/vue/Menu.java


src/vue/MenuGrille.class: src/vue/MenuGrille.java \
			src/controleur/DonneesMenuGrille.class \
			src/controleur/TypeEntre.class
	$(JC) $(JFLAGS) ./src/vue/MenuGrille.java


# DEPENDANCES MODELE

src/modele/CreerGrille.class: src/modele/CreerGrille.java \
			src/vue/GrilleAlea.class \
			src/vue/GrilleVide.class
	$(JC) $(JFLAGS) ./src/modele/CreerGrille.java


src/modele/EcrireFichier.class: src/modele/EcrireFichier.java
	$(JC) $(JFLAGS) ./src/modele/EcrireFichier.java


src/modele/LireBit.class: src/modele/LireBit.java
	$(JC) $(JFLAGS) ./src/modele/LireBit.java


src/modele/LireFichier.class: src/modele/LireFichier.java \
			src/modele/LireBit.class \
			src/vue/GrilleExistante.class
	$(JC) $(JFLAGS) ./src/modele/LireFichier.java


src/modele/Main.class: src/modele/Main.java \
			src/vue/Menu.class
	$(JC) $(JFLAGS) ./src/modele/Main.java

# NETTOYAGE DES FICHIERS .class

clean:
	find ./src/* -name "*.class" -exec rm {} \;


# BUTS

.PHONY: run

run:
	java src.modele.Main

