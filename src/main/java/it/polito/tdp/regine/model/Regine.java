package it.polito.tdp.regine.model;

import java.util.ArrayList;
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
	List<Integer> risultato;
	public List<Integer>  posizioni(int N){
		List<Integer> parziale= new ArrayList<>();
		this.risultato=null;
		cerca(parziale, 0, N, risultato);
		return risultato;
	}
	
	private  boolean cerca(List<Integer>parziale, int livello, int N, List<Integer> risultato) {
		
		if(livello==N && risultato.size()==0) {
			// caso terminale
			
			//stampo tutte le possibili soluzioni
		    	this.soluzione= new ArrayList<>(parziale);
		    	return true;

		} else {
			
			for(int colonna=0; colonna<N; colonna++) {
				int n=0;
				for(int i=1; i<=livello; i++) {
				if(Math.abs(parziale.get(livello-i)-colonna)!=i && !parziale.contains(colonna)) {
					n++;
				}
				
				}
				if(n==livello) {//if la posa nella casella [livello][colonna] è valida  aggiungi a parziale e fai ricorsione
					
					parziale.add(colonna);
					boolean trovato= cerca(parziale, livello+1, N, risultato);
					if(trovato)
						return true;
					parziale.remove(parziale.size()-1);	       
				
				}
				
			}
			return false;
		}
	}
	
	
	
	//soluzione del professore (trova solo la prima soluzione)
	//il professore ha caricato anche una soluzione che restituisce tutte le soluzioni
	//lista di liste
	
	private int N;
	private List<Integer> soluzione;
	public List<Integer> risolvi(int N) {
		this.N=N;
		List<Integer> parziale= new ArrayList<>();
		this.soluzione=null;
		cercaDelProf(parziale, 0);
		return this.soluzione;
	}
	
	private boolean cercaDelProf(List<Integer> parziale, int livello) {
		if(livello==N) {
			this.soluzione= new ArrayList<>( parziale);
			return true;
		}else {
			for(int colonna=0; colonna<N; colonna++) {
				
				if(posValida(parziale, colonna)) {
					parziale.add(colonna);
					boolean trovato= cercaDelProf(parziale, livello+1);
					if(trovato)
						return true;
					parziale.remove(parziale.size()-1); //backtracking
				}
			}
			return false;
		}
	}
	
	private boolean posValida(List<Integer> parziale, int colonna) {
		int livello= parziale.size();
		
		if(parziale.contains(colonna))
			return false;
		
		for(int r=0; r<livello; r++) {
			int c= parziale.get(r);
			if(r+c== livello+colonna || r-c== livello-colonna)
				return false;
		}
		
		return true;
	}
	
	
}
	
