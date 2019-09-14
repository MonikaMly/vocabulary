import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

public class GUI {
    public static final String OPEN = "open";
    public static final String START = "start";
    public static final String CHECK = "check";
    private JFrame window;
    private JMenuBar menu;
    private JMenu file;
    private JMenuItem open;
    private JLabel scoreLabel;
    private JLabel score;
    private JLabel answerInfo;
    private JLabel englishWord;
    private JTextField answerTextField;
    private JButton startGame;
    private JButton checkAnswer;
    private JLabel imageLabel;
    private JFileChooser fileChooser;
    private Integer points;

    public GUI(){
        createAndShowGui();
    }

    public File getFile(){
        fileChooser.showOpenDialog(window);
        return fileChooser.getSelectedFile();
    }

    public void showEnglishWord(String englishWord){
        this.englishWord.setText(englishWord);
    }

    public String getTextToCheck(){
        return answerTextField.getText();
    }

    public void resetPoints(){
        points = 0;
        this.score.setText(points.toString());
    }

    public void addPoints(){
        this.score.setText((points += 1).toString());
        this.answerInfo.setText(":)");
    }

    public void takePoint(){
        this.score.setText((points -= 1).toString());
        this.answerInfo.setText(":(");
    }

    public void clearTextField(){
        this.answerTextField.setText("");
    }

    public void showGameOverInfo(){
        JOptionPane.showMessageDialog(window, "End of the game! Your score: " + points);
    }

    private void createAndShowGui(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        window = new JFrame("Translation game");
        window.setLayout(null);
        window.setMinimumSize(new Dimension(500, 500));
        window.setMaximumSize(new Dimension(500, 500));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

        menu = new JMenuBar();
        menu.setPreferredSize(new Dimension(500,20));
        menu.setBackground(new Color(173, 151, 159));
        window.setJMenuBar(menu);

        file = new JMenu("File");
        file.setForeground(new Color(128, 82,173));
        menu.add(file);

        open = new JMenuItem("Open");
        open.setForeground(new Color(94,6,173));
        open.setBackground(new Color(173,160,166));
        open.setActionCommand(OPEN);
        file.add(open);

        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileFilter(new FileNameExtensionFilter(".csv","csv"));

        scoreLabel = new JLabel("score: ");
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font("Serif",Font.PLAIN,20));
        scoreLabel.setBounds(100,50,60,20);
        window.add(scoreLabel);

        score = new JLabel("0");
        score.setForeground(Color.BLACK);
        score.setFont(new Font("Serif",Font.PLAIN, 20));
        score.setBounds(160,50,30,20);
        window.add(score);

        answerInfo = new JLabel(":)");
        answerInfo.setForeground(Color.RED);
        answerInfo.setFont(new Font("Serif", Font.PLAIN,20));
        answerInfo.setBounds(200,50,20,20);
        window.add(answerInfo);

        englishWord = new JLabel("...............");
        englishWord.setForeground(new Color(18,127,92));
        englishWord.setFont(new Font("Serif",Font.PLAIN,20));
        englishWord.setBounds(50,150,100,20);
        window.add(englishWord);

        answerTextField = new JTextField();
        answerTextField.setBounds(150,145,200,30);
        window.add(answerTextField);

        startGame = new JButton("START");
        startGame.setBounds(200,200,100,30);
        startGame.setFont(new Font("Serif", Font.PLAIN,20));
        startGame.setBackground(new Color(18,127,92));
        startGame.setForeground(new Color(182,182,182));
        startGame.setActionCommand(START);
        window.add(startGame);

        checkAnswer = new JButton("Check");
        checkAnswer.setBounds(370,145,100,30);
        checkAnswer.setFont(new Font("Serif",Font.PLAIN,20));
        checkAnswer.setBackground(new Color(127,42,121));
        checkAnswer.setForeground(new Color(28,28,28));
        checkAnswer.setActionCommand(CHECK);
        window.add(checkAnswer);

        imageLabel = new JLabel(new ImageIcon("src/main/resources/england.jpg"));
        imageLabel.setBounds(0,200,500,300);
        window.add(imageLabel);
    }
}
