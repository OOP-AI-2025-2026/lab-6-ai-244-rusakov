package ua.opnu.list;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Rectangle extends DrawShape {

    public Rectangle() {
    }

    public Rectangle(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    // Для побудови прямокутника використовується клас Rectangle2D.Double,
    // який працює з координатами у форматі double
    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        return new Rectangle2D.Double(
                Math.min(startPoint.getX(), endPoint.getX()),
                Math.min(startPoint.getY(), endPoint.getY()),
                Math.abs(startPoint.getX() - endPoint.getX()),
                Math.abs(startPoint.getY() - endPoint.getY())
        );
    }
}
