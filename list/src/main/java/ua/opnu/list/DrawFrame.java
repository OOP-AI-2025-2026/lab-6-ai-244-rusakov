/**
 * Головне вікно програми. Клас JFrame виступає основним контейнером інтерфейсу.
 */
public class DrawFrame extends JFrame {

    // Компонент, який відповідає за відображення графічних елементів
    private PaintSurface surface;

    // Конструктор створює графічний інтерфейс користувача
    public DrawFrame(String title) {

        // Виклик конструктора суперкласу. В ньому реалізовано базове
        // налаштування та відображення вікна
        super(title);

        // Задаємо поведінку при закритті вікна — завершити роботу застосунку.
        // Інакше програма може залишитися активною у фонових процесах
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Встановлюємо менеджер розташування компонентів у фреймі
        this.setLayout(new BorderLayout());

        // Додаємо верхню панель із кнопками
        this.add(setButtonPanel(), BorderLayout.NORTH);

        // Створюємо компонент для малювання фігур
        surface = new PaintSurface();

        // Додаємо область для малювання в центр фрейму
        this.add(surface, BorderLayout.CENTER);

        // Підганяємо розмір вікна під вміст компонентів
        this.pack();

        // Робимо вікно видимим для користувача
        this.setVisible(true);
    }

    /*
     * Метод створює та налаштовує панель з кнопками керування фігурами.
     */
    private JPanel setButtonPanel() {

        // Створюємо панель для кнопок
        JPanel buttonPanel = new JPanel(true);

        // Встановлюємо компонування з вирівнюванням по центру зліва направо
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Задаємо колір фону панелі
        buttonPanel.setBackground(Color.CYAN);

        // Додаємо рамку чорного кольору товщиною 2 пікселі
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // *** Додаємо кнопки до панелі ***

        // 1. Кнопка для малювання прямокутника
        ua.opnu.list.BigTextButton rect = new ua.opnu.list.BigTextButton("Rectangle");

        // Додаємо обробник подій — при натисканні встановлюється тип фігури «прямокутник»
        rect.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_RECTANGLE);
        });

        // Додаємо кнопку на панель
        buttonPanel.add(rect);

        // 2. Кнопка для малювання прямокутника зі скругленими кутами
        ua.opnu.list.BigTextButton rounded_rect = new ua.opnu.list.BigTextButton("Rounded rect.");
        rounded_rect.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT);
        });
        buttonPanel.add(rounded_rect);

        // 3. Кнопка для створення еліпса
        ua.opnu.list.BigTextButton ellipse = new ua.opnu.list.BigTextButton("Ellipse");
        ellipse.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_ELLIPSE);
        });
        buttonPanel.add(ellipse);

        // 4. Кнопка для очищення області малювання
        ua.opnu.list.BigTextButton clear = new BigTextButton("Clear");
        clear.addActionListener(e -> {
            surface.clearshapes();
        });
        buttonPanel.add(clear);

        return buttonPanel;
    }
}
