package tutorial7;

import javax.swing.*;
import java.awt.event.*;

public class QuizBattleGUI extends JFrame implements ActionListener {
    private JLabel lblQuestion;
    private JButton btnOption1;
    private JButton btnOption2;
    private JLabel lblResult;

    private Question question;

    public QuizBattleGUI() {
        setTitle("Programming Quiz Battle");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the question
        question = new Question(
            "Which keyword creates an object?",
            "new",
            "class",
            "new"
        );

        // Question label
        lblQuestion = new JLabel(question.getQuestion());
        lblQuestion.setBounds(50, 30, 300, 30);
        add(lblQuestion);

        // Option 1 button ("new")
        btnOption1 = new JButton(question.getOption1());
        btnOption1.setBounds(50, 80, 120, 40);
        btnOption1.addActionListener(this);
        add(btnOption1);

        // Option 2 button ("class")
        btnOption2 = new JButton(question.getOption2());
        btnOption2.setBounds(200, 80, 120, 40);
        btnOption2.addActionListener(this);
        add(btnOption2);

        // Result label
        lblResult = new JLabel("Answer the question!");
        lblResult.setBounds(50, 150, 300, 30);
        add(lblResult);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (question.isCorrect(clickedButton.getText())) {
            lblResult.setText("Correct! You defeated the Code Boss!");
        } else {
            lblResult.setText("Wrong! Try Again!");
        }
    }

    // Main entry point to run the app
    public static void main(String[] args) {
        new QuizBattleGUI();
    }
}