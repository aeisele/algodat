package data;

import java.util.Objects;

// given at: https://www.interviewcake.com/question/java/rectangular-love
public class Rectangle {

    // coordinates of bottom left corner
    private int leftX;
    private int bottomY;

    // dimensions
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return leftX == rectangle.leftX &&
                bottomY == rectangle.bottomY &&
                width == rectangle.width &&
                height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftX, bottomY, width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "leftX=" + leftX +
                ", bottomY=" + bottomY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public int getLeftX() {
        return leftX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}