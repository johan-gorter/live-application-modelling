package app.ritadministratie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import custom.ritadministratie.AutoCustomization;

public class JaarTest {

	private Jaar jaar;
	private AutoCustomization auto;
	private Maand februari;
	private Maand mei;
	
	@Before
	public void setUp() throws Exception {
		jaar = new Jaar();
		jaar.setJaartal(2012);
		auto = new AutoCustomization(jaar, 0);
		jaar.autos.add(auto);
		auto.initMaanden();
		februari = auto.getMaanden().get(1);
		mei = auto.getMaanden().get(4);
	}
	
	public void addStand(int maandNr, int dagNr, String adres, int kmStand) {
		Maand maand = auto.getMaanden().get(maandNr - 1);
		Dag dag = maand.getDagen().get(dagNr -1);
		Rit rit = new Rit(jaar);
		rit.getEindstand().setAdres(adres);
		rit.getEindstand().setKmStand(kmStand);
		dag.ritten.add(rit);
	}

	@Test
	public void test() {
		auto.getBeginstand().setKmStand(10000);
		auto.getBeginstand().setAdres("a");
		
		addStand(1, 2, "b", 10100);
		
		assertEquals(new Integer(10100), februari.getBeginstand().getKmStand());
		assertSame(februari.getBeginstand(), mei.getBeginstand());
		addStand(3, 3, "a", 10200);
		assertNotSame(februari.getBeginstand(), mei.getBeginstand());
	}

}
