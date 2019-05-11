package form;

import jdbc.mySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.awt.GridBagConstraints.*;

class GeneralPanel extends JPanel implements ActionListener {
    static JPanel clMain;
    static mySQL my;
    static JFrame jFrame;
    static CardLayout cardLayout;
    GridBagConstraints c;
    GridBagLayout gridBagLayout;
    JLabel labelAccess;
    private JLabel time;

    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
    private int   currentSecond;
    private Calendar calendar;

    private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

    private void start(){
        reset();
        Timer timer = new Timer(1000, e -> {
            if( currentSecond == 60 ) {
                reset();
            }
            time.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
            currentSecond++;
        });
        timer.start();
    }

    GeneralPanel(){
        initComponents();
    }

    private void initComponents(){
        createFrame(1080, 720);
        start();
        cardLayout = new CardLayout();
        clMain = new JPanel();
        my = new mySQL();

        labelAccess = new JLabel("", SwingConstants.CENTER);

        c = new GridBagConstraints();
        gridBagLayout = new GridBagLayout();

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        Font labelAccessFont = new Font("Arial", Font.BOLD | Font.ITALIC, 26);
        labelAccess.setFont(labelAccessFont);
        labelAccess.setForeground(new Color(-12032069));

        gridBagLayout.setConstraints(labelAccess, c);
        this.add(labelAccess);

        time = new JLabel("");
        c.anchor = EAST;
        //c.gridx = 3;
        c.gridy = 5;
        gridBagLayout.setConstraints(time, c);

        this.add(time);

        this.setLayout(gridBagLayout);


        this.setBackground(Color.ORANGE);
    }

    private void createFrame(int width, int height){
        jFrame = new JFrame("Application");

// размер
        Dimension dim = new Dimension();

// нужная ширина (подставить число)
        dim.width = width;

// нужная высота (подставить число)
        dim.height = height;

// присваиваем форме нужные размеры
        jFrame.setPreferredSize( dim );


// JVM "прорисовывает" форму, получая реальные размеры рабочей области

        jFrame.pack();

// реальная ширина рабочей области

        int realWidth = jFrame.getContentPane().getWidth();

// реальная высота рабочей области
        int realHeight = jFrame.getContentPane().getHeight();

// вычисляем разницу по ширине
        int theXaddition = dim.width - realWidth;

// вычисляем разницу по высоте

        int theYaddition = dim.height - realHeight;

// добавляем разницу к первоначально заданным размерам
        dim.width += theXaddition;

        dim.height += theYaddition;

// устанавливаем увеличенные размеры

        jFrame.setPreferredSize( dim );

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
