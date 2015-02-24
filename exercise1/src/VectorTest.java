import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test für die Klasse Vector.
 *
 * @author Ajay Ghale
 */
public class VectorTest {

    @Test
    public void testCreation() {

        Vector vektor = new Vector(3, 1, -5);

        assertEquals(3, vektor.getX(), 0.01d);
        assertEquals(1, vektor.getY(), 0.01d);
        assertEquals(-5, vektor.getZ(), 0.01d);

        Vector nullVector = new Vector();
        assertEquals(0.0,  nullVector.betrag(), 0.001);
        assertEquals(0.0,  nullVector.getX(), 0.001);
        assertEquals(0.0,  nullVector.getY(), 0.001);
        assertEquals(0.0,  nullVector.getZ(), 0.001);
    }

    @Test
    public void testEqualsAndHashCode() {

        Vector vektor1 = new Vector(5, 7, 9);
        Vector vektor2 = new Vector(5, 7, 9);
        Vector vektor3 = new Vector(5, 7, 2);
        Vector vektor4 = new Vector(5, 3, 9);
        Vector vektor5 = new Vector(5, 7, 8);

        assertTrue(vektor1.equals(vektor2));
        assertTrue(vektor2.equals(vektor1));
        assertTrue(vektor1.equals(vektor1));
        assertTrue(vektor2.equals(vektor2));

        assertFalse(vektor1.equals(vektor3));
        assertFalse(vektor1.equals(vektor4));
        assertFalse(vektor1.equals(vektor5));

        assertFalse(vektor3.equals(vektor1));
        assertFalse(vektor4.equals(vektor1));
        assertFalse(vektor5.equals(vektor1));

        assertFalse(vektor1.equals(null));
        assertFalse(vektor1.equals("Hello"));

        assertEquals(vektor1.hashCode(), vektor2.hashCode());
    }

    @Test
    public void testImmutable() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(10, 20, 30);

        Vector v3 = v1.addiere(v2);

        assertNotSame(v1,  v2);
        assertNotSame(v1,  v3);
        assertNotSame(v3,  v2);
    }

    @Test
    public void testSkalarMultiplikationSkalar() {

        Vector vektor1 = new Vector(1, -5,  3);
        Vector ergebnis1 = new Vector(6, -30, 18);

        Vector vektor2 = new Vector(1, -5,  3);
        Vector ergebnis2 = new Vector(-3,  15,  -9);

        assertEquals(ergebnis1, vektor1.multipliziere(6));
        assertEquals(ergebnis2, vektor2.multipliziere(-3));

        Vector vektor3 = new Vector(3, 4, 5);
        assertEquals(1, vektor3.einheitsvektor().betrag(), 0.01d);
    }

    @Test
    public void testSkalarMultiplikationVektor() {

        Vector vektor1 = new Vector(1, 2,  3);
        Vector vektor2 = new Vector(-7, 8, 9);
        double ergebnis = 36;

        assertEquals(ergebnis, vektor1.multipliziere(vektor2), 0.0001);

        Vector vektor3 = new Vector(-5, 9,  7);
        Vector vektor4 = new Vector(10, 3, 8);
        double ergebnis2 = 33;

        assertEquals(ergebnis2, vektor3.multipliziere(vektor4), 0.0001);

    }

    @Test
    public void testAdditionUndSubtraktion() {

        Vector a = new Vector( 4,  0,  8);
        Vector b = new Vector(-1,  4,  7);
        Vector c = new Vector( 3,  4, 15);

        assertEquals(c, a.addiere(b));
        assertEquals(a.addiere(b), b.addiere(a));
    }

    @Test
    public void testBetrag() {

        Vector a = new Vector( 1,  1,  1);
        Vector b = new Vector( 2,  0,  0);
        Vector c = new Vector( 3,  4,  5);

        assertEquals(Math.sqrt(3), a.betrag(), 0.00001);
        assertEquals(2, b.betrag(), 0.00001);
        assertEquals(Math.sqrt(50), c.betrag(), 0.00001);
    }

    @Test
    public void testKreuzprodukt() {

        Vector a = new Vector(  1,    2,   3);
        Vector b = new Vector( -7,    8,   9);
        Vector c = new Vector( -6,  -30,  22);

        assertEquals(c, a.kreuzprodukt(b));
    }

    @Test
    public void testAufgabenStellung1() {
        Vector a = new Vector(2, 0, 5);
        Vector b = new Vector(-1, 5, -2);
        Vector c = new Vector(2, 1, 2);
        assertEquals(-31, b.kreuzprodukt(c).multipliziere(a), 0.001d);
    }

    @Test
    public void testAufgabenStellung2() {
        Vector a = new Vector(1, 2, 8);
        Vector b = new Vector(4, 3, 5);
        Vector e = new Vector(-14, 27, -5);
        assertEquals(e, a.kreuzprodukt(b));
    }

    @Test
    public void testAufgabenStellung3() {
        Vector a = new Vector(1, -2, 2);
        Vector b = new Vector(3, 2, -4);
        assertEquals(-9, a.multipliziere(b), 0.001d);
    }

    @Test
    public void testWinkel() {
        Vector a = new Vector(3, -1, 2);
        Vector b = new Vector(1,  2, 4);
        assertEquals(58.3, a.winkel(b), 0.1d);
    }

    @Test
    public void testToString() {
        assertEquals("[ 1,00  1,00  1,00 ]", new Vector(1, 1, 1).toString());
        assertEquals("[ -1,00  -1,00  -1,00 ]", new Vector(-1, -1, -1).toString());
        assertEquals("[ 1,50  2,00  0,00 ]", new Vector(1.5, 2, 0).toString());
    }
}
