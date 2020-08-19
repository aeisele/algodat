import data.Rectangle;

// https://www.interviewcake.com/question/java/rectangular-love
public class RectangleIntersection {

    public Rectangle findIntersection(Rectangle a, Rectangle b) {

        Range rangeAX = new Range(a.getLeftX(), a.getWidth());
        Range rangeBX = new Range(b.getLeftX(), b.getWidth());
        Range intersectionX = rangeAX.intersection(rangeBX);

        Range rangeAY = new Range(a.getBottomY(), a.getHeight());
        Range rangeBY = new Range(b.getBottomY(), b.getHeight());
        Range intersectionY = rangeAY.intersection(rangeBY);

        if (intersectionX.isEmpty() || intersectionY.isEmpty()) {
            return new Rectangle(0, 0, 0, 0);
        }

        return new Rectangle(intersectionX.getStart(),
                intersectionY.getStart(),
                intersectionX.getLength(),
                intersectionY.getLength());
    }

    public static class Range {
        private final int start;
        private final int end;

        public Range(int start, int length) {
            this.start = start;
            this.end = start + length;
        }

        public Range intersection(Range other) {

            int highestStart = Math.max(this.start, other.start);
            int lowestEnd = Math.min(this.end, other.end);

            if (highestStart > lowestEnd) {
                return new Range(0, 0);
            }

            return new Range(highestStart, lowestEnd - highestStart);
        }

        public int getStart() {
            return start;
        }

        public int getLength() {
            return end - start;
        }

        public boolean isEmpty() {
            return getLength() == 0;
        }
    }

}
