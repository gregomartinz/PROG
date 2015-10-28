package es.upm.dit.prog.p3;

import junit.framework.*;

public class RegionTest extends TestCase {

    public void setUp() {
        Region unaRegion = new Region();
    }
    
    public void testAnadirAntena() {

    	Region region = new Region();
    	
    	//Primera prueba
    	assertEquals(0,region.nAntenasEnRegion());
    	
    	AntenaDireccional a1 = new AntenaDireccional(10,10,10,new Punto(15,15));
    	AntenaDireccional a2 = new AntenaDireccional(10,10,10,new Punto(15,15));
    	AntenaDireccional a3 = new AntenaDireccional(10,10,10,new Punto(-2,-2));
    	AntenaDireccional a4 = new AntenaDireccional(10,10,10,new Punto(10,13));
    	AntenaDireccional a5 = new AntenaDireccional(10,10,10,new Punto(50,23));
    	AntenaDireccional a6 = new AntenaDireccional(10,10,10,new Punto(20,60));
    	AntenaDireccional a7 = new AntenaDireccional(10,10,10,new Punto(28,49));
    	AntenaDireccional a8 = new AntenaDireccional(10,10,10,new Punto(19,48));
    	
    	// Segunda prueba
    	try{
    		region.anadirAntena(a1);
    		
    		assertEquals(1, region.nAntenasEnRegion());
		}	
    	catch (Exception e){
    		fail("No debería saltar este error") ;
    				}	
    	
    	// Tercera prueba
    	try{   
    		region.anadirAntena(a2);
    		
    		fail("No debería saltar este error") ;   		
    	}
    	catch(Exception e){
    		assertEquals(1,region.nAntenasEnRegion());    			
    	}
    	
    	// Cuarta prueba
    	try{
    		region.anadirAntena(a3);
    		
    		fail("No debería saltar este error") ;
    	}
    	catch(Exception e){    		
    		assertEquals(1,region.nAntenasEnRegion());
    	}
    	
    	// Quinta prueba
    	try{
    		region.anadirAntena(a4);
    		region.anadirAntena(a5);
    		region.anadirAntena(a6);
    		region.anadirAntena(a7);
    		assertEquals(5,region.nAntenasEnRegion());
    	}catch(Exception e){
    		fail("No debería saltar este error") ;
    	}
    	
    	// Sexta prueba
    	try{
    		region.anadirAntena(a8);
    		
    		fail("No debería saltar este error") ;
    	}
    	catch(Exception e){    		
    		assertEquals(5,region.nAntenasEnRegion());
    	}
    	
    }

    public void testHayAntena() {
    	
    	Region region = new Region();
    	
    	Punto p1 = new Punto(10,10);
    	Punto p2 = new Punto(20,20);
    	Punto p3 = new Punto(-2,-2);
    	
    	AntenaDireccional ant1 = new AntenaDireccional(10,10,10,p1);
    	AntenaDireccional ant2 = new AntenaDireccional(10,10,10,p2);
    	AntenaDireccional ant3 = new AntenaDireccional(10,10,10,p3);
        
    	// Primera prueba
    	try{
    		region.anadirAntena(ant1);
    		region.anadirAntena(ant2);
    		
    		assertEquals(ant1.getPosicion(),region.hayAntena(p1).getPosicion());
    		assertEquals(ant2.getPosicion(),region.hayAntena(p2).getPosicion());
    	}
    	catch(Exception e){
    		fail("No debería saltar este error") ;
    	}
    	
    	// Segunda prueba
    	try{
    		region.anadirAntena(ant3);
    		
    		assertEquals(p3,region.hayAntena(p3).getPosicion());
    		
    		fail("No debería saltar este error") ;
    	}
    	catch(Exception e){
    		
    	}
    }

    public void testNAntenasConCobertura() {
    	
        Region region = new Region();
        
        Punto pun1 = new Punto(-5,-5);
        Punto pun2 = new Punto(5,5);
        Punto pun3 = new Punto(15,15);
        Punto pun4 = new Punto(50,50);
        
        AntenaDireccional antena1 = new AntenaDireccional(Math.PI/6,Math.PI,10,new Punto(0,0));
    	AntenaDireccional antena2 = new AntenaDireccional(Math.PI/2,Math.PI,10,new Punto(0,4));
    	AntenaDireccional antena3 = new AntenaDireccional(Math.PI/6,Math.PI/4,10,new Punto(10,10));
    	AntenaDireccional antena4 = new AntenaDireccional(Math.PI/6,Math.PI/4,10,new Punto(51,51));
    	
        
        
        //Primera prueba
        try{
        	assertEquals(pun1,region.nAntenasConCobertura(pun1));
        	fail("No debería saltar este error") ;
        }
        catch(Exception e){        	
        }
        
        //Segunda Prueba
        try{
        	region.anadirAntena(antena1);
        	region.anadirAntena(antena2);
        	region.anadirAntena(antena3);
        	region.anadirAntena(antena4);
        	
        	assertEquals(0,region.nAntenasConCobertura(pun4));
        	assertEquals(1,region.nAntenasConCobertura(pun3));
        	assertEquals(2,region.nAntenasConCobertura(pun2));        		
        }
        catch(Exception e){
        	fail("No debería saltar este error") ;
        }
    }

    public static void main(String args[]) {
        junit.textui.TestRunner.run(RegionTest.class);
}

}