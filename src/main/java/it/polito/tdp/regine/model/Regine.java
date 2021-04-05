package it.polito.tdp.regine.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Regine {

	
	// N è il numero di righe e colonne della scacchiera
	//   (righe e colonne numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	// 		List<Integer>
	// livello = quante righe sono già piene
	// livello = 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	// [0]
	//     [0, 2]
	//            [0, 2, 1]
	public void posizioni(int N){
		List<Integer> parziale= new LinkedList<>();
		
		//parziale.add(1);
		cerca(parziale, 0, N);
		
	}
	
	private  void cerca(List<Integer>parziale, int livello, int N) {
		if(livello==N) {
			// caso terminale
			
			//stampo tutte le possibili soluzioni
		    	System.out.println(parziale);

		} else {
			
			for(int colonna=0; colonna<N; colonna++) {
				int n=0;
				for(int i=1; i<=livello; i++) {
				if(Math.abs(parziale.get(livello-i)-colonna)!=i && !parziale.contains(colonna)) {
					n++;
				}
				
				}
				if(n==livello) {
				List<Integer> nuovaParziale= new LinkedList<>(parziale);
				nuovaParziale.add(colonna);
				cerca(nuovaParziale, livello+1, N);	
				}
				// if la possa nella casella [livello][colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione
			}
		}
	}
	
}
	
