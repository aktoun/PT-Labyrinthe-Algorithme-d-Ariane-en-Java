/**
 * @author Nicolas FAFIN
 * @author Antoine MAN
 *
 */

package src.algorithme;

import java.util.Random;
import java.util.LinkedList;

public class AlgoAleaManuelle {
	
	private int xThesee;
	private int yThesee;
	private int xSortie;
	private int ySortie;
	private int taille;
	private int[][] typecase;
	private int compteurDeplacement;
	private LinkedList<Integer> fileofX;
	private LinkedList<Integer> fileofY;

	/**
	 * Constructeur pour AlgoAleaManuelle
	 * 
	 * @param typecase
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
	public AlgoAleaManuelle(int[][] typecase, int xThesee, int yThesee, int xSortie, int ySortie, int taille) {
		
		this.xThesee = xThesee;
		this.yThesee = yThesee;
		this.xSortie = xSortie;
		this.ySortie = ySortie;
		this.typecase = typecase;
		this.taille = taille;

		LinkedList<Integer> fileX = new LinkedList<Integer>();
		LinkedList<Integer> fileY = new LinkedList<Integer>();

		int compteurS = 0;
		int compteurT = 0;
		int sortie = 0;

		double constante = 1;
		double probabilite;
		probabilite=constante/4;

		Random rand = new Random();
		double alea = 0;
	
		int nbrDeplacement = 0;
		
		if (this.xSortie>0) {
			if (this.typecase[this.xSortie-1][this.ySortie]!=1) {
			} else {
				compteurS++;
			}
		}

		if (this.xSortie<this.taille-1) {

			if (this.typecase[this.xSortie+1][this.ySortie]!=1) {
			} else {
				compteurS++;
			}
		}

		if(this.ySortie>0) {
			if (this.typecase[this.xSortie][this.ySortie-1]!=1) {
			} else {
				compteurS++;
			}
		}

		if (this.ySortie<this.taille-1) {
			if (this.typecase[this.xSortie][this.ySortie+1]!=1) {
			} else {
				compteurS++;
			}
		}

		if(compteurS == 4) {
			sortie = 1;
		}
		
		if (this.xThesee>0) {
			if (this.typecase[this.xThesee-1][this.yThesee]!=1) {
			} else {
				compteurT++;
			}
		}

		if (this.xThesee<this.taille-1) {

			if (this.typecase[this.xThesee+1][this.yThesee]!=1) {
			} else {
				compteurT++;
			}
		}

		if(this.yThesee>0) {
			if (this.typecase[this.xThesee][this.yThesee-1]!=1) {
			} else {
				compteurT++;
			}
		}

		if (this.yThesee<this.taille-1) {
			if (this.typecase[this.xThesee][this.yThesee+1]!=1) {
			} else {
				compteurT++;
			}
		}

		if(compteurT == 4) {
			sortie = 1;
		}

		/*ordre de deplacement: haut, gauche, bas, droite */

		while ((this.typecase[this.xThesee][this.yThesee]!=3 && sortie==0)) {
			
			alea =  rand.nextDouble();
		
			if (this.xThesee==0 && this.yThesee==0) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);
				
				if (alea<probabilite) {
					nbrDeplacement++;
				} else if (alea>probabilite && alea<2*probabilite) {
					nbrDeplacement++;
				} else if (alea>2*probabilite && alea<3*probabilite) {
					if(this.typecase[this.xThesee+1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee+1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else {
					if (this.typecase[this.xThesee][this.yThesee+1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee+1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				}
			
			} else if (this.xThesee==0 && this.yThesee==this.taille-1) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					nbrDeplacement++;
				} else if (alea>probabilite && alea<2*probabilite) {
					if(this.typecase[this.xThesee][this.yThesee-1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee-1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>2*probabilite && alea<3*probabilite) {
					if(this.typecase[this.xThesee+1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee+1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else {
					nbrDeplacement++;
				}

			} else if (this.xThesee==this.taille-1 && this.yThesee==0) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					if(this.typecase[this.xThesee-1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee-1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>probabilite && alea<2*probabilite) {
					nbrDeplacement++;
				} else if (alea>2*probabilite && alea<3*probabilite) {
					nbrDeplacement++;
				} else {
					if (this.typecase[this.xThesee][this.yThesee+1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee+1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				}

			} else if (this.xThesee==this.taille-1 && this.yThesee==this.taille-1) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					if(this.typecase[this.xThesee-1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee-1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>probabilite && alea<2*probabilite) {
					if(this.typecase[this.xThesee][this.yThesee-1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee-1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>2*probabilite && alea<3*probabilite) {
					nbrDeplacement++;
				} else {
					nbrDeplacement++;
				}

			} else if(this.xThesee==0) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					nbrDeplacement++;
				} else if (alea>probabilite && alea<2*probabilite) {
					if(this.typecase[this.xThesee][this.yThesee-1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee-1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>2*probabilite && alea<3*probabilite) {
					if(this.typecase[this.xThesee+1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee+1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else {
					if (this.typecase[this.xThesee][this.yThesee+1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee+1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				}

			} else if (this.xThesee==this.taille-1) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					if(this.typecase[this.xThesee-1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee-1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>probabilite && alea<2*probabilite) {
					if(this.typecase[this.xThesee][this.yThesee-1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee-1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>2*probabilite && alea<3*probabilite) {
					nbrDeplacement++;
				} else {
					if (this.typecase[this.xThesee][this.yThesee+1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee+1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				}

			} else if (this.yThesee==0) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					if(this.typecase[this.xThesee-1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee-1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>probabilite && alea<2*probabilite) {
					nbrDeplacement++;
				} else if (alea>2*probabilite && alea<3*probabilite) {
					if(this.typecase[this.xThesee+1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee+1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else {
					if (this.typecase[this.xThesee][this.yThesee+1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee+1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				}

			} else if (this.yThesee==this.taille-1) {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					if(this.typecase[this.xThesee-1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee-1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>probabilite && alea<2*probabilite) {
					if(this.typecase[this.xThesee][this.yThesee-1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee-1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>2*probabilite && alea<3*probabilite) {
					if(this.typecase[this.xThesee+1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee+1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else {
					nbrDeplacement++;
				}

			} else {
				fileX.add(this.xThesee);
				fileY.add(this.yThesee);

				if (alea<probabilite) {
					if(this.typecase[this.xThesee-1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee-1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>probabilite && alea<2*probabilite) {
					if(this.typecase[this.xThesee][this.yThesee-1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee-1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee-1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else if (alea>2*probabilite && alea<3*probabilite) {
					if(this.typecase[this.xThesee+1][this.yThesee]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee+1][this.yThesee]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.xThesee=this.xThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				} else {
					if (this.typecase[this.xThesee][this.yThesee+1]==0) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=2;
						nbrDeplacement++;
					} else if(this.typecase[this.xThesee][this.yThesee+1]==3) {
						this.typecase[this.xThesee][this.yThesee]=0;
						this.yThesee=this.yThesee+1;
						this.typecase[this.xThesee][this.yThesee]=3;
						nbrDeplacement++;
					} else {
						nbrDeplacement++;
					}
				}
				
			}

		if (nbrDeplacement>10000) {
			sortie=1;
		}	

		}

		fileX.add(this.xThesee);
		fileY.add(this.yThesee);

		this.compteurDeplacement=nbrDeplacement;

		if (nbrDeplacement>10000) {
			this.compteurDeplacement=0;
		}

		this.fileofX=fileX;
		this.fileofY=fileY;

	}

	/**
	 * @return int compteurDeplacement qui correspond au nombre d'etapes qu'a parcouru Thesee
	 */
	public int Nombre() {
		return this.compteurDeplacement;
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