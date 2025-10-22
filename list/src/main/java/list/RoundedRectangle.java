package ua.opnu.list;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangle extends DrawShape {

    public RoundedRectangle() {}

    public RoundedRectangle(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    // Для побудови прямокутника зі скругленими кутами використовується клас RoundRectangle2D.Double,
    // який працює з координатами типу double
    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        return new RoundRectangle2D.Double(
                Math.min(startPoint.getX(), endPoint.getX()),
                Math.min(startPoint.getY(), endPoint.getY()),
                Math.abs(startPoint.getX() - endPoint.getX()),
                Math.abs(startPoint.getY() - endPoint.getY()),
                55.0, 55.0 // Радіус заокруглення по ширині та висоті
        );
    }
}
