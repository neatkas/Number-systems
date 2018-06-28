import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;

public class MyFrame extends JFrame{

    private final static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private final static int width = dim.width/2;
    private final static int height = dim.height/2;

    private Font font = new Font("serif",Font.BOLD+Font.ITALIC, 28);
    private Font mainfont = new Font("serif",Font.BOLD, 17);

    private static int first = 2;
    private static int second = 2;

    private static int decNumber;

    private JLabel lab_back = new JLabel("Вернуться к выбору направления перевода");

    MyFrame()
    {
        JPanel Pan1  = new JPanel();
        JPanel internal_p = new JPanel();

        JLabel Lab_Wel = new JLabel("Добро пожаловать!");
        JLabel Lab1 = new JLabel("Перевод из ");
        JLabel Lab2 = new JLabel(" в ");
        JLabel Lab3 = new JLabel(" систему счисления");

        String[] first_list = {
                "двоичной",
                "восьмеричной",
                "шестнадцатеричной",
                "десятичной"
        };

        String[] second_list = {
                "двоичную",
                "восьмеричную",
                "шестнадцатеричную",
                "десятичную"
        };

        JComboBox CB1 = new JComboBox(first_list);
        JComboBox CB2 = new JComboBox(second_list);

        JButton But_start = new JButton("Начать обучение");

        add(Pan1);
        Pan1.setLayout(null);

        Lab_Wel.setBounds(width/2 - (int)len("Добро пожаловать!",font)/2, height/20, width, 40);
        Lab_Wel.setFont(font);

        internal_p.setBounds(10, height/10+100, width-20, 120);

        Lab1.setFont(mainfont);
        Lab2.setFont(mainfont);
        Lab3.setFont(mainfont);

        CB1.setFont(mainfont);
        CB1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                switch ((String)CB1.getSelectedItem()) {
                    case "двоичной":
                        first = 2;
                        break;
                    case "восьмеричной":
                        first = 8;
                        break;
                    case "шестнадцатеричной":
                        first = 16;
                        break;
                    case "десятичной":
                        first = 10;
                        break;
                }
                System.out.println(first);
            }
        });

        CB2.setFont(mainfont);
        CB2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                switch ((String)CB2.getSelectedItem()) {
                    case "двоичную":
                        second = 2;
                        break;
                    case "восьмеричную":
                        second = 8;
                        break;
                    case "шестнадцатеричную":
                        second = 16;
                        break;
                    case "десятичную":
                        second = 10;
                        break;
                }
                System.out.println(second);
            }
        });

        But_start.setBounds(width/2-(int)len("Начать обучение", mainfont)/2-30, height-height/2+10, 250, 50);
        But_start.setFont(mainfont);
        But_start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Frame_training();
            }
        });

        Pan1.add(Lab_Wel);
        internal_p.add(Lab1);
        internal_p.add(CB1);
        internal_p.add(Lab2);
        internal_p.add(CB2);
        internal_p.add(Lab3);
        Pan1.add(internal_p);
        Pan1.add(But_start);
    }

    void Frame_training()
    {
        JFrame fr2 = new JFrame("Training");
        fr2.setSize(width, height);
        fr2.setLocation(width/2, height/2);
        fr2.setVisible(true);
        //fr2.setResizable(false);
        fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel Panel1 = new JPanel();
        Panel1.setLayout(null);

        fr2.add(Panel1);

        JLabel jLab2 = new JLabel("Число в двоичной системе счисления: ");
        JLabel jLab8 = new JLabel("Число в восьмеричной системе счисления: ");
        JLabel jLab16 = new JLabel("Число в шестнадцатеричной системе счисления: ");
        JLabel jLab10 = new JLabel("Число в десятичной системе счисления: ");

        JLabel jLab = new JLabel();                                   // сгенерированное значение
        JLabel answer = new JLabel("Правильно!");
        JLabel answer_wrong = new JLabel("Неправильно! Попробуйте еще раз");
        JLabel not = new JLabel("Неверное направление перевода");
        //JLabel lab_back = new JLabel("Вернуться к выбору направления перевода");

        JTextField txt = new JTextField();

        JButton Back = new JButton("Назад");
        JButton Check = new JButton("Проверить");
        JButton Go = new JButton("Дальше");
        JButton Clear = new JButton("Стереть");

        Panel1.add(jLab2);
        Panel1.add(jLab8);
        Panel1.add(jLab16);
        Panel1.add(jLab10);
        Panel1.add(jLab);
        Panel1.add(answer);
        Panel1.add(answer_wrong);
        Panel1.add(not);
        Panel1.add(txt);
        Panel1.add(Back);
        Panel1.add(lab_back);
        Panel1.add(Check);
        Panel1.add(Go);
        Panel1.add(Clear);

        int len_long = (int)len("Число в шестнадцатеричной системе счисления: ", mainfont);

        jLab.setBounds(len_long + 60, 70, 100, 40);
        jLab.setFont(mainfont);
        jLab2.setFont(mainfont);
        jLab8.setFont(mainfont);
        jLab16.setFont(mainfont);
        jLab10.setFont(mainfont);

        answer.setBounds(width/2-(int)len(answer.getText(), font)/2, height-height/3, width, 40);
        answer.setFont(font);
        answer.setForeground(Color.red);

        answer_wrong.setBounds(width/2-(int)len(answer_wrong.getText(), font)/2, height-height/3, width, 40);
        answer_wrong.setFont(font);
        answer_wrong.setForeground(Color.red);

        not.setBounds(width/2-(int)len(not.getText(), font)/2, height/3, 750, 40);
        not.setFont(font);

        jLab.setVisible(false);
        answer.setVisible(false);
        answer_wrong.setVisible(false);
        not.setVisible(false);
        lab_back.setVisible(false);

        txt.setBounds(len_long + 60, 125, 100, 30);
        txt.setFont(mainfont);

        Back.setBounds(50, height-Back.getSize().height-100, 100, 40);
        Back.setFont(mainfont);
        Back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fr2.dispose();
            }
        });
        Back.addMouseListener(new CustomListener());

        lab_back.setBounds(200, height-Back.getSize().height-60, width, 40);
        lab_back.setFont(new Font("serif",Font.BOLD+Font.ITALIC, 20));

        Check.setBounds(width/2-(int)len("Проверить", font), height/2, 150, 40);
        Check.setFont(mainfont);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(toDec(txt.getText(), second) == decNumber){
                    answer.setVisible(true);
                    answer_wrong.setVisible(false);
                }
                else {
                    answer.setVisible(false);
                    answer_wrong.setVisible(true);
                }
            }
        });

        Go.setBounds(width/2, height/2, 150, 40);
        Go.setFont(mainfont);
        Go.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                decNumber = (int) (Math.random()*100);
                System.out.println(decNumber);

                jLab.setText(fromDec(decNumber, first));
                txt.setText("");
                answer.setVisible(false);
                answer_wrong.setVisible(false);
            }
        });

        Clear.setBounds(width - (int)len("Стереть", font) - 20, 120, 130, 40);
        Clear.setFont(mainfont);
        Clear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txt.setText("");
            }
        });

        decNumber = (int) (Math.random()*100);
        System.out.println(decNumber);

        if(first == second){
            not.setVisible(true);
            jLab2.setVisible(false);
            jLab8.setVisible(false);
            jLab16.setVisible(false);
            jLab10.setVisible(false);
            txt.setVisible(false);
            Check.setVisible(false);
            Go.setVisible(false);
            Clear.setVisible(false);
        }
        else {
            jLab.setText(fromDec(decNumber, first));
            jLab.setVisible(true);

            switch (first) {
                case 2:
                    switch (second) {
                        case 8:
                            jLab2.setBounds(50, 70, width, 40);
                            jLab8.setBounds(50, 120, width, 40);
                            jLab16.setVisible(false);
                            jLab10.setVisible(false);
                            break;
                        case 16:
                            jLab2.setBounds(50, 70, width, 40);
                            jLab8.setVisible(false);
                            jLab16.setBounds(50, 120, width, 40);
                            jLab10.setVisible(false);
                            break;
                        case 10:
                            jLab2.setBounds(50, 70, width, 40);
                            jLab8.setVisible(false);
                            jLab16.setVisible(false);
                            jLab10.setBounds(50, 120, width, 40);
                            break;
                    }
                    break;
                case 8:
                    switch (second) {
                        case 2:
                            jLab2.setBounds(50, 120, width, 40);
                            jLab8.setBounds(50, 70, width, 40);
                            jLab16.setVisible(false);
                            jLab10.setVisible(false);
                            break;
                        case 16:
                            jLab2.setVisible(false);
                            jLab8.setBounds(50, 70, width, 40);
                            jLab16.setBounds(50, 120, width, 40);
                            jLab10.setVisible(false);
                            break;
                        case 10:
                            jLab2.setVisible(false);
                            jLab8.setBounds(50, 70, width, 40);
                            jLab16.setVisible(false);
                            jLab10.setBounds(50, 120, width, 40);
                            break;
                    }
                    break;
                case 16:
                    switch (second) {
                        case 2:
                            jLab2.setBounds(50, 120, width, 40);
                            jLab8.setVisible(false);
                            jLab16.setBounds(50, 70, width, 40);
                            jLab10.setVisible(false);
                            break;
                        case 8:
                            jLab2.setVisible(false);
                            jLab8.setBounds(50, 120, width, 40);
                            jLab16.setBounds(50, 70, width, 40);
                            jLab10.setVisible(false);
                            break;
                        case 10:
                            jLab2.setVisible(false);
                            jLab8.setVisible(false);
                            jLab16.setBounds(50, 70, width, 40);
                            jLab10.setBounds(50, 120, width, 40);
                            break;
                    }
                    break;
                case 10:
                    switch (second) {
                        case 2:
                            jLab2.setBounds(50, 120, width, 40);
                            jLab8.setVisible(false);
                            jLab16.setVisible(false);
                            jLab10.setBounds(50, 70, width, 40);
                            break;
                        case 8:
                            jLab2.setVisible(false);
                            jLab8.setBounds(50, 120, width, 40);
                            jLab16.setVisible(false);
                            jLab10.setBounds(50, 70, width, 40);
                            break;
                        case 16:
                            jLab2.setVisible(false);
                            jLab8.setVisible(false);
                            jLab16.setBounds(50, 120, width, 40);
                            jLab10.setBounds(50, 70, width, 40);
                            break;
                    }
                    break;
            }
        }


    }

    String fromDec(int number, int base)
    {
        String by_res = "";
        String result = "";
        
        if(number == 0) result = "0";
        
        while(number != 0)
        {
            int rest = number % base;
            if (rest<10)
            {
                by_res += Integer.toString(rest);
            }else
            {
                switch(rest)
                {
                    case 10: by_res += "A"; break;
                    case 11: by_res += "B"; break;
                    case 12: by_res += "C"; break;
                    case 13: by_res += "D"; break;
                    case 14: by_res += "E"; break;
                    case 15: by_res += "F"; break;
                }
            }
            number /= base;
        }
        for(int i = by_res.length(); i > 0; i--)
        {
            result += by_res.substring(i-1, i);
        }

        return result;
    }
    int toDec(String number, int base)
    {
        String sym;
        int result = 0, num = 0;
        int len = number.length();
        for(int i = 0; i < len; i++)
        {
            sym = number.substring(i, i+1);
            switch(sym)
            {
                case "0": num = 0; break;
                case "1": num = 1; break;
                case "2": num = 2; break;
                case "3": num = 3; break;
                case "4": num = 4; break;
                case "5": num = 5; break;
                case "6": num = 6; break;
                case "7": num = 7; break;
                case "8": num = 8; break;
                case "9": num = 9; break;

                case "A": num = 10; break;
                case "B": num = 11; break;
                case "C": num = 12; break;
                case "D": num = 13; break;
                case "E": num = 14; break;
                case "F": num = 15; break;

                default: num = -1; break;
            }
            if(num == -1)
            {
                result = -1;
                System.out.println("ERROR!");
                break;
            }
            else
            {
                result += num * Math.pow(base, len-i-1);
            }
        }
        System.out.println(result);
        return result;
    }
    double len(String s, Font f){
        return f.getStringBounds(s, new FontRenderContext(null,true,true)).getWidth();
    }

        //( Math.random() * (b-a) ) + a - случайное число в диапазоне [a,b)

    public static void main(String[] args) {
        run(new MyFrame());
    }

    public static void run(final JFrame f) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);

                f.setLocation(width/2,height/2);
                //f.setResizable(false);
            }
        });
    }

    public class CustomListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) e.getSource();
        }
        public void mouseEntered(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            lab_back.setVisible(true);
        }
        public void mouseExited(MouseEvent e) {
            JButton button = (JButton) e.getSource();
            lab_back.setVisible(false);
        }
        public void mousePressed(MouseEvent e) {
            JButton button = (JButton) e.getSource();
        }

        public void mouseReleased(MouseEvent e) {
            JButton button = (JButton) e.getSource();
        }
    }
}

