package es.upm.dit.prog.p4;

/**
 * The test class RegionTest.
 *
 * @author  Nicolás de la Flor
 * @version 22 de Mayo de 2010
 */
public class RegionTest extends junit.framework.TestCase
{

   /**
    * Default constructor for test class RegionTest
    */
   public RegionTest()
   {
   }

   /**
    * Sets up the test fixture.
    *
    * Called before every test case method.
    */
   protected void setUp() throws Exception
   {

   }

   /**
    * Tears down the test fixture.
    *
    * Called after every test case method.
    */
   protected void tearDown()
   {
   }

   public void testAnadirAntena()
   {

       Region laRegion = new Region();
       assertEquals(0,laRegion.nAntenasEnRegion());

       Punto p1 = new Punto (0,0);
       Punto p2 = new Punto (10,10);
       Punto p3 = new Punto (20,20);
       Punto p4 = new Punto (30,30);
       Punto p5 = new Punto (101,101);
       Punto p6 = new Punto (40,40);
       Punto p7 = new Punto (50,50);
       Punto p9 = new Punto (102,102);
       AntenaDireccional a1 = new AntenaDireccional (1,1,1,p1);
       AntenaDireccional a2 = new AntenaDireccional (1,1,1,p2);
       AntenaDireccional a3 = new AntenaDireccional (1,1,1,p3);
       AntenaDireccional a3_1= new AntenaDireccional(1,1,3,p3);
       AntenaDireccional a4 = new AntenaDireccional (1,1,1,p4);
       AntenaDireccional a5 = new AntenaDireccional (1,1,1,p4);
       AntenaDireccional a6 = new AntenaDireccional (1,1,1,p9);
       AntenaDireccional a7 = new AntenaDireccional (1,1,1,p6);
       AntenaDireccional a8 = new AntenaDireccional (1,1,1,p7);
       try {

           laRegion.anadirAntena(a1);
           laRegion.anadirAntena(a2);
           laRegion.anadirAntena(a3);

           assertEquals(3, laRegion.nAntenasEnRegion());

       }

       catch (Exception e) {

           fail("No debería lanzar excepcioón");
       }

       try {

           laRegion.anadirAntena(a3_1);

           fail("No se ha lanzado la excepción");
       }

       catch (Exception e) {

           assertEquals(3, laRegion.nAntenasEnRegion());
       }

       try {

           laRegion.anadirAntena(a6);

           fail("No se ha lanzado la excepción");
       }
       catch (Exception e) {

           assertEquals(3, laRegion.nAntenasEnRegion());
       }

       try{

           laRegion.anadirAntena(a8);
           laRegion.anadirAntena(a7);

           assertEquals(5, laRegion.nAntenasEnRegion());
       }
       catch (Exception e) {

           fail("No se ha lanzado la excepción");
       }

       try{
           laRegion.anadirAntena(a4);

           fail("Debería de haber lanzado excepción");
       }
       catch (Exception e) {

           assertEquals(5, laRegion.nAntenasEnRegion());
       }

   }

   public void testHayAntena(){
       Region laRegion = new Region();

       Punto pun1 = new Punto (1,1);
       Punto pun2 = new Punto (5,5);
       Punto pun3 = new Punto (101,101);
       AntenaDireccional ad1= new AntenaDireccional (1,3,1,pun1);
       AntenaDireccional ad2= new AntenaDireccional (20,3,14,pun2);

       try{

           laRegion.anadirAntena(ad2);
           assertEquals(ad2, laRegion.hayAntena(pun2));

           laRegion.anadirAntena(ad1);

           assertEquals(ad1, laRegion.hayAntena(pun1));

       }
       catch (Exception e ) {
           fail ("No debería de haber lanzado excepción");
       }

       try{

           assertEquals(null, laRegion.hayAntena(pun3));

       }
       catch (Exception e ) {

           //Y aquí como pongo el fail??

       }

   }

   public void testNAntenasConCobertura(){
       Region laRegion = new Region();
       Punto p1= new Punto (5,5);
       Punto p1_1= new Punto (6,5);
       Punto p2= new Punto (50,50);
       Punto p3 =  new Punto (7,7);
       Punto fuera = new Punto (100,100);
       AntenaOmnidireccional a1 = new AntenaOmnidireccional(10,p1_1);
       AntenaOmnidireccional a2 = new AntenaOmnidireccional (5,p3);

       try{

           laRegion.anadirAntena(a1);
           assertEquals(1,laRegion.nAntenasConCobertura(p1));
       }

       catch (Exception e ) {

           fail("Debería de haber lanzado excepción");
       }

       try {

           assertEquals(0,laRegion.nAntenasConCobertura(p2));
       }

       catch (Exception e ) {

           fail ("Debería de haber lanzado excepción");
       }

       try {
           laRegion.anadirAntena(a2);
           assertEquals(2,laRegion.nAntenasConCobertura(p1));
       }
       catch (Exception e ) {

           fail ("Debería de haber lanzado excepción");
       }
   }

   public void testVelocidadTransmisionWIFI(){
       Region laRegion = new Region();

       Punto p1 = new Punto (5,5);
       Punto p2 = new Punto (6,5);
       Punto p4 = new Punto (7,5);
       Punto p3 = new Punto (50,50);
       Punto fuera = new Punto (100, 100);

       AntenaOmnidireccional a1 = new AntenaOmnidireccional (4, p2);
       RouterWIFI802N router = new RouterWIFI802N (10, p4);

       try {
           laRegion.anadirAntena(a1);
           assertEquals(0, laRegion.velocidadTransmisionWIFI(p1));
       }
       catch (Exception e ) {

           fail("No debería de haber lanzado excepción");
       }

       try {

           laRegion.anadirAntena(router);
           assertEquals(55, laRegion.velocidadTransmisionWIFI(p1));
       }
       catch (Exception e ) {

           fail("no debería saltar la excepción");
       }

   }

}