package ua.opnu.list;

import java.awt.*;
import java.awt.Point;

public abstract class DrawShape {

    // Фабричний метод: створює новий об’єкт відповідного типу фігури
    public static DrawShape newInstance(int shapeType) {
        DrawShape shape = null;
        if (shapeType == DrawShape.SHAPE_RECTANGLE) {
            shape = new Rectangle();
        } else if (shapeType == DrawShape.SHAPE_ROUNDED_RECT) {
            shape = new RoundedRectangle();
        } else if (shapeType == DrawShape.SHAPE_ELLIPSE) {
            shape = new Ellipse();
        }
        return shape;
    }

    // Константи, що визначають типи доступних фігур
    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    // Початкова та кінцева координати фігури
    private Point startPoint;
    private Point endPoint;

    // Конструктор за замовчуванням — ініціалізує фігуру з нульовими координатами
    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    // Конструктор з переданими координатами початкової та кінцевої точок
    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Абстрактний метод, який має реалізувати кожен підклас для створення конкретної фігури
    public abstract Shape getShape(Point startPoint, Point endPoint);

    // Метод для отримання форми фігури на основі збережених координат
    public Shape getShape() {
        return this.getShape(startPoint, endPoint);
    }

    // Встановлює нову початкову точку фігури
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    // Встановлює нову кінцеву точку фігури
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
