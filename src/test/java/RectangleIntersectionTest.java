import data.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleIntersectionTest {

    @Test
    public void overlapAlongBothAxesTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 6, 3), new Rectangle(5, 2, 3, 6));
        final Rectangle expected = new Rectangle (5, 2, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void oneRectangleInsideAnotherTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 6, 6), new Rectangle(3, 3, 2, 2));
        final Rectangle expected = new Rectangle(3, 3, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void bothRectanglesTheSameTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(2, 2, 4, 4), new Rectangle(2, 2, 4, 4));
        final Rectangle expected = new Rectangle(2, 2, 4, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void touchOnHorizontalEdgeTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 2, 3, 4), new Rectangle(2, 6, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void touchOnVerticalEdgeTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 2, 3, 4), new Rectangle(4, 3, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void touchAtCornerTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 2, 2), new Rectangle(3, 3, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void noOverlapTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 2, 2), new Rectangle(4, 6, 3, 6));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    private Rectangle findRectangularOverlap(Rectangle a, Rectangle b) {
        return new RectangleIntersection().findIntersection(a, b);
    }
}