package org.lessons.java.valutazioni;

public class Studente {
	public int id;
	public int percentualeAssenze;
	public float mediaVoti;
	
	public Studente(int id, int percentualeAssenze, float mediaVoti) {
		this.id = id;
		this.percentualeAssenze = percentualeAssenze;
		this.mediaVoti = mediaVoti;
	};
	
	public boolean isPromoted() {
		boolean promoted = false;
		
		int maxAssenze = 100;
		
		if(percentualeAssenze <= (maxAssenze/2) ) {
			if (percentualeAssenze >= (maxAssenze/4)) {
				if(mediaVoti > 2) {
					promoted = true;
				}
			} else if(mediaVoti>=2) {
				promoted = true;
			}
		} 
		
		return promoted;
	}
}
