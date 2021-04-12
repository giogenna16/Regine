package it.polito.tdp.regine.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Regine prova= new Regine();
		List<Integer> stampa =prova.posizioni(5);
		System.out.print(stampa);
	}

}
