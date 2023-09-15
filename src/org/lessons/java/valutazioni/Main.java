package org.lessons.java.valutazioni;

import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		final int lng = 20;
		int countPromoted = 0;
		
		Studente[] studenti = new Studente[lng];
		
		Random rnd = new Random();
		
		for(int i=0; i<lng; i++) {
			
			int id = i + 1;
			int percentualeAssenze = rnd.nextInt(0,101);
			float mediaVoti = rnd.nextFloat(0,5.01f);
			
			studenti[i] = new Studente(id, percentualeAssenze, mediaVoti);
			
			if(studenti[i].isPromoted()) {
				countPromoted++;
			}
			
			System.out.println("STUDENTE " + (i+1));
			System.out.println("\nID: " + studenti[i].id);
			System.out.println("Percentuale Assenze: " + studenti[i].percentualeAssenze +"%");
			System.out.println("Media voti: " + String.format("%.02f", studenti[i].mediaVoti));
			System.out.println(studenti[i].isPromoted() ?
					"\nPromosso :)":
					"\nBocciato :(");
			
			System.out.println("\n==============================\n");
		}
		
		System.out.println("Numero studenti promossi: " + countPromoted + " su " + lng);
		
		//Bonus 
		Studente[] studentiPromossi = new Studente[countPromoted];
		Studente[] studentiBocciati = new Studente[lng - countPromoted];
		
		int indexPromossi = 0;
		int indexBocciati = 0;
		
		for(int i=0; i<lng; i++) {
			if(studenti[i].isPromoted()) {
				studentiPromossi[indexPromossi] = studenti[i];
				indexPromossi++;
			} else {
				studentiBocciati[indexBocciati] = studenti[i];
				indexBocciati++;
			}
		}
		
		int indexMigliorStudente = 0;
		int indexPeggiorStudente = 0;
		
		for(int i=0; i<countPromoted; i++) {
			if(studentiPromossi[i].mediaVoti > studentiPromossi[indexMigliorStudente].mediaVoti) {
				indexMigliorStudente = i;
			}
		}
		
		for(int i=0; i<(lng - countPromoted); i++) {
			if(studentiBocciati[i].mediaVoti < studentiBocciati[indexPeggiorStudente].mediaVoti) {
				indexPeggiorStudente = i;
			}
		}
		
		System.out.println("\nL'ID del miglior studente è: " + studentiPromossi[indexMigliorStudente].id);
		System.out.println("L'ID del peggior studente è: " + studentiBocciati[indexPeggiorStudente].id);
	}
}
