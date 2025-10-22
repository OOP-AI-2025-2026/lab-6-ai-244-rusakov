/**
 * Компонент для малювання фігур. Є нащадком стандартного класу JComponent з бібліотеки Swing.
 */
public class PaintSurface extends JComponent {

    // Список фігур, які відображаються на полотні
    private final List<DrawShape> shapes = new ArrayList<>();

    // Поточний вибраний тип фігури
    private int shapeType;

    // Координати точки натискання миші (початок) і точки відпускання (кінець)
    private java.awt.Point startDrag;
    private java.awt.Point endDrag;

    // Палітра кольорів для заливки фігур
    private final List<Color> colors = Arrays.asList(
            Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.RED, Color.BLUE, Color.PINK
    );

    public PaintSurface() {
        // Тип фігури за замовчуванням — 0 (прямокутник)
        shapeType = 0;

        // Задаємо рекомендований розмір області для малювання
        super.setPreferredSize(new Dimension(400, 400));

        // Обробник подій миші: натискання та відпускання кнопки
        this.addMouseListener(new MouseAdapter() {

            // Коли користувач натискає мишу — зберігаємо координати
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
            }

            // Коли користувач відпускає кнопку миші — створюємо фігуру
            public void mouseReleased(MouseEvent e) {
                DrawShape shape = DrawShape.newInstance(shapeType);

                // Встановлюємо координати фігури
                shape.setStartPoint(startDrag);
                shape.setEndPoint(endDrag);

                // Додаємо фігуру до колекції
                shapes.add(shape);

                // Скидаємо координати для наступної операції
                startDrag = null;
                endDrag = null;

                // Оновлюємо відображення
                repaint();
            }
        });

        // Обробник подій переміщення миші з натиснутою кнопкою
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Оновлюємо кінцеву точку під час перетягування
                endDrag = new Point(e.getX(), e.getY());
                repaint();
            }
        });
    }

    // Встановлює тип фігури, яка буде створюватися
    public void setShapeType(int type) {
        this.shapeType = type;
    }

    // Очищує всі фігури з полотна
    public void clearshapes() {
        shapes.clear();
        repaint();
    }

    /*
     * Метод paint() викликається автоматично при оновленні компонента.
     * Тут виконується повне перемалювання: фону, сітки та всіх фігур.
     */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Увімкнення згладжування
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Малюємо фонову сітку
        paintBackgroundGrid(g2);

        // Товщина ліній — 2 пікселі
        g2.setStroke(new BasicStroke(2));

        // Прозорість фігур при заливці
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

        // Малювання всіх збережених фігур
        shapes.forEach(s -> {
            g2.setPaint(Color.BLACK); // контур
            g2.draw(s.getShape());

            // Заливка з циклічним вибором кольору
            g2.setPaint(colors.get(shapes.indexOf(s) % colors.size()));
            g2.fill(s.getShape());
        });

        // Під час створення нової фігури — відображаємо її сірим кольором
        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.LIGHT_GRAY);
            DrawShape shape = DrawShape.newInstance(shapeType);
            g2.draw(shape.getShape(startDrag, endDrag));
        }
    }

    // Малює сітку на фоні полотна
    private void paintBackgroundGrid(Graphics2D g2) {
        g2.setPaint(Color.LIGHT_GRAY);

        // Вертикальні лінії через кожні 10 пікселів
        for (int i = 0; i < getSize().width; i += 10) {
            Shape line = new Line2D.Float(i, 0, i, getSize().height);
            g2.draw(line);
        }

        // Горизонтальні лінії через кожні 10 пікселів
        for (int i = 0; i < getSize().height; i += 10) {
            Shape line = new Line2D.Float(0, i, getSize().width, i);
            g2.draw(line);
        }
    }
}
