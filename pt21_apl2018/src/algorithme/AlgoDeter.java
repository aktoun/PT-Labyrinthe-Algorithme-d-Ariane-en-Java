/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 *
 */

package src.algorithme;

import java.util.LinkedList;
import java.util.Stack;

public class AlgoDeter {
	private int[][] typecase;
	private int xThesee;
	private int yThesee;
	private int xSortie;
	private int ySortie;
	private int taille;
	private int nbrDeplacement;

	private LinkedList<Integer> fileofX;
	private LinkedList<Integer> fileofY;

	/**
	 * Constructeur pour AlgoDeter
	 * 
	 * @param tab
	 * 			Correspond au typecase
	 * @param xThesee
	 * 			Position X de Thesee
	 * @param yThesee
	 * 			Position Y de Thesee
	 * @param xSortie
	 * 			Position X de la sortie
	 * @param ySortie
	 * 			Position Y de la sortie
	 * @param taille
	 * 			Taille de la grille
	 */
	public AlgoDeter(int[][] tab, int xThesee, int yThesee, int xSortie, int ySortie, int taille) {
		this.typecase=tab;
		this.xThesee=xThesee;
		this.yThesee=yThesee;
		this.xSortie=xSortie;
		this.ySortie=ySortie;
		this.taille=taille;
		
		Stack<Integer> stackofX = new Stack<Integer>();
		Stack<Integer> stackofY = new Stack<Integer>();

		LinkedList<Integer> fileX = new LinkedList<Integer>();
		LinkedList<Integer> fileY = new LinkedList<Integer>();

		int compteurDeplacement=0;

		int compteurS = 0;
		int compteurT = 0;
		int sortie = 0;


		if (this.xSortie>0) {
			if (this.typecase[this.xSortie-1][this.ySortie]==1) {
				compteurS++;
			}
		}

		if (this.xSortie<this.taille-1) {

			if (this.typecase[this.xSortie+1][this.ySortie]==1) {
				compteurS++;
			}
		}

		if(this.ySortie>0) {
			if (this.typecase[this.xSortie][this.ySortie-1]==1) {
				compteurS++;
			}
		}

		if (this.ySortie<this.taille-1) {
			if (this.typecase[this.xSortie][this.ySortie+1]==1) {
				compteurS++;
			}
		}
		
		if (this.xThesee>0) {
			if (this.typecase[this.xThesee-1][this.yThesee]==1) {
				compteurT++;
			}
		}

		if (this.xThesee<this.taille-1) {
			if (this.typecase[this.xThesee+1][this.yThesee]==1) {
				compteurT++;
			}
		}

		if(this.yThesee>0) {
			if (this.typecase[this.xThesee][this.yThesee-1]==1) {
				compteurT++;
			}
		}

		if (this.yThesee<this.taille-1) {
			if (this.typecase[this.xThesee][this.yThesee+1]==1) {
				compteurT++;
			}
		}

		if(compteurT == 4 || compteurS == 4) {
			sortie = 1;
		}



		/* ordre des directions: haut, gauche, bas, droite */

		while (typecase[xThesee][yThesee]!=3 && sortie==0) {

			//si Thesee se trouve dans le coin en haut a gauche 
			if(xThesee==0 && yThesee==0) {


				if(typecase[xThesee+1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
			
				} else if(typecase[xThesee+1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}

			// si Thesee se trouve dans le coin en haut a droite 
			} else if(xThesee==0 && yThesee==taille-1) {

				if(typecase[xThesee][yThesee-1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if(typecase[xThesee][yThesee-1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}

			// si Thesee se trouve dans le coin en bas a gauche 
			} else if (xThesee==taille-1 && yThesee==0) {

				if(typecase[xThesee-1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if (typecase[xThesee-1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}

			// si Thesee se trouve dans le coin en bas a droite
			} else if (xThesee==taille-1 && yThesee==taille-1) {

				if(typecase[xThesee-1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if(typecase[xThesee-1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}

			// si Thesee se trouve tout en haut
			} else if(xThesee==0) {

				if(typecase[xThesee][yThesee-1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if(typecase[xThesee][yThesee-1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}	
			
			// si Thesee se trouve tout en bas
			} else if (xThesee==taille-1) {

				if(typecase[xThesee-1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if (typecase[xThesee-1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}

			// si Thesee se trouve tout a gauche
			} else if (yThesee==0) {

				if(typecase[xThesee-1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==3) {
					typecase[xThesee][yThesee]=4;
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if (typecase[xThesee-1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}	

			// si Thesee se trouve tout a droite
			} else if (yThesee==taille-1) {

				if(typecase[xThesee-1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				
				} else if (typecase[xThesee-1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {
					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}

			// si Thesee se trouve au milieu et possede 4 directions 
			} else {

				if(typecase[xThesee-1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==3) {
					typecase[xThesee][yThesee]=4;
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=3;
					fileX.add(xThesee);
					fileY.add(yThesee);
					compteurDeplacement++;
				}


				else if (typecase[xThesee-1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee-1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee-1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee+1][yThesee]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					xThesee=xThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else if(typecase[xThesee][yThesee+1]==0) {
					typecase[xThesee][yThesee]=4;
					stackofX.push(xThesee);
					stackofY.push(yThesee);
					fileX.add(xThesee);
					fileY.add(yThesee);
					yThesee=yThesee+1;
					typecase[xThesee][yThesee]=2;
					compteurDeplacement++;
				} else {

					if(!stackofX.empty()) {
						typecase[xThesee][yThesee]=4;
						fileX.add(xThesee);
						fileY.add(yThesee);
						xThesee=stackofX.pop();
						yThesee=stackofY.pop();
						typecase[xThesee][yThesee]=2;
						compteurDeplacement++;
					} else {
						sortie=1;
						compteurDeplacement=0;
					}
				}
			}
		}

		this.fileofX=fileX;
		this.fileofY=fileY;

		this.nbrDeplacement=compteurDeplacement;

		if (this.nbrDeplacement>10000) {
			this.nbrDeplacement=0;
		}
	}

	/**
	 * @return int compteurDeplacement qui correspond au nombre d'etapes qu'a parcouru Thesee
	 */
	public int Nombre() {
		return this.nbrDeplacement;
	}

	/**
	 * @return {@link LinkedList} recupFileX
	 */
	public LinkedList<Integer> recupFileX() {
		return this.fileofX;
	}

	/**
	 * @return {@link LinkedList} recupFileY
	 */
	public LinkedList<Integer> recupFileY() {
		return this.fileofY;
	}
}