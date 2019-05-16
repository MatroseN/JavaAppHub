package DailyQuote;

import GUI.GUI;
import WebScraper.WebScraper;

import javax.swing.*;
import java.awt.*;

public class DailyQuoteForm{
    public DailyQuoteForm(GUI gui){
        this.gui = gui;
        initialize();
    }

    private void initialize(){
        frameColors();
        panelSetup();
        buildTextAreas();
        addElements();
    }

    private void panelSetup(){
       dailyQuotesPanel = new JPanel();

        dailyQuotesPanel.setBackground(backgroundColor);
        dailyQuotesPanel.setLayout(null);
        dailyQuotesPanel.setVisible(false);
    }

    private void buildTextAreas(){
        webScraper = new WebScraper();
        quoteArea = new JTextArea(webScraper.getDailyQuote());
        quoteArea.setBounds(225, 150, 400, 150);
        quoteArea.setEditable(false);
        quoteArea.setBackground(quoteBoxColor());
        quoteArea.setForeground(quoteTextColor());
        quoteArea.setLineWrap(true);
        quoteArea.setWrapStyleWord(true);
        quoteArea.setFont(quoteArea.getFont().deriveFont(18f));
    }

    private Color quoteBoxColor(){
        Color color;
        red = 0;
        green = 50;
        blue = 60;
        color = new Color(red, green, blue);

        return color;
    }

    private Color quoteTextColor(){
        Color color;
        red = 225;
        green = 225;
        blue = 225;
        color = new Color(red, green, blue);

        return color;
    }

    private void frameColors(){
        //Frame
        red = 16;
        green = 25;
        blue = 34;
        backgroundColor = new Color(red, green, blue);
    }

    private void addElements(){
        dailyQuotesPanel.add(quoteArea);
    }

    public JPanel getDailyQuotesPanel(){
        return dailyQuotesPanel;
    }

    //Colors
    Color backgroundColor;

    //RGB Colors
    private int red;
    private int green;
    private int blue;

    private GUI gui;
    private WebScraper webScraper;

    private JPanel dailyQuotesPanel;

    private JTextArea quoteArea;
}
