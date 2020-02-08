package fr.cnam.tp4.tests;


import fr.cnam.tp1and2.point.Point;
import fr.cnam.tp4.polygon.Polygon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PolygonTest {
    private final static double e = 0.0001;

    private Polygon p0, p1;
    private Point s1, s2, s3, s4;

    @Before
    public void setUp() {
        this.p0 = new Polygon();

        this.p1 = new Polygon();
        this.p1.addVertex(this.s1 = new Point(0, 0));
        this.p1.addVertex(this.s3 = new Point(5, 5));
        this.p1.addVertex(this.s4 = new Point(5, 0));
        this.p1.addVertex(this.s2 = new Point(0, 5), 2);
    }

    @Test
    public void testInitialisation() {
        assertNotNull(this.p0);
        assertNotNull(this.p1);
        assertEquals(0, this.p0.getDegree());
        assertEquals(4, this.p1.getDegree());
    }

    @Test
    public void testInitialisation2() {
        assertEquals(this.s1, this.p1.getVertex(1));
        assertEquals(this.s2, this.p1.getVertex(2));
        assertEquals(this.s3, this.p1.getVertex(3));
        assertEquals(this.s4, this.p1.getVertex(4));
    }

    @Test
    public void testDimensions() {
        assertEquals(20, this.p1.getPerimeter(), e);
        assertEquals(25, this.p1.getArea(), e);
    }

    @Test
    public void testTranslater() {
        this.p1.translate(20, 10);
        assertEquals(20, this.p1.getVertex(1).getX(), e);
        assertEquals(10, this.p1.getVertex(1).getY(), e);
        assertEquals(25, this.p1.getVertex(4).getX(), e);
        assertEquals(10, this.p1.getVertex(4).getY(), e);
        assertEquals(20, this.p1.getPerimeter(), e);
        assertEquals(25, this.p1.getArea(), e);
    }

    @Test
    public void testSupprimer() {
        this.p1.removeVertex(2);
        assertEquals(10 + Math.sqrt(50), this.p1.getPerimeter(), e);
        assertEquals(12.5, this.p1.getArea(), e);
        assertEquals(3, this.p1.getDegree());
    }
}
