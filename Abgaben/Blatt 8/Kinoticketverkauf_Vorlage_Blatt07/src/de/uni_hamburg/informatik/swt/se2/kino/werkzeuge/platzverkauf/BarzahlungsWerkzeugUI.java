package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Die UI des {@link BarzahlungsWerkzeug}
 * @author torevonschwartz
 *
 */
public class BarzahlungsWerkzeugUI
{
    // Die Widgets, aus denen sich die UI zusammensetzt
    private JDialog _dialog;
    private JTextField _zuZahlen;
    private JTextField _bezahlt;
    private JTextField _restgeld;
    private JLabel _zuZahlenLabel;
    private JLabel _bezahltLabel;
    private JLabel _restgeldLabel;
    private JButton _abbruchButton;
    private JButton _okButton;

    /**
     * Initialisiere die UI
     */
    public BarzahlungsWerkzeugUI()
    {
        _dialog = erstelleDialog();
        _dialog.setLocation(600, 300);
        _dialog.setModalityType(Dialog.ModalityType.MODELESS);
        _dialog.setVisible(true);
    }

    /**
     * Erzeugt den Dialog für die Barzahlung
     * @return den Dialog
     */
    private JDialog erstelleDialog()
    {
        JDialog dialog = new JDialog();
        dialog.setSize(new Dimension(300, 300));
        dialog.setLayout(new BorderLayout());

        JPanel zahlungsPanel = new JPanel();
        zahlungsPanel.setLayout(new GridLayout(3, 2));

        _zuZahlenLabel = new JLabel("Gesamtpreis: (ct)");
        zahlungsPanel.add(_zuZahlenLabel);

        _zuZahlen = new JTextField("0");
        _zuZahlen.setEditable(false);
        zahlungsPanel.add(_zuZahlen);

        _bezahltLabel = new JLabel("Barzahlung: (ct)");
        zahlungsPanel.add(_bezahltLabel);

        _bezahlt = new JTextField("");
        zahlungsPanel.add(_bezahlt);

        _restgeldLabel = new JLabel("Restbetrag: (ct)");
        zahlungsPanel.add(_restgeldLabel);

        _restgeld = new JTextField("0");
        zahlungsPanel.add(_restgeld);

        dialog.add(zahlungsPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        _abbruchButton = new JButton("Abbruch");
        buttonPanel.add(_abbruchButton, BorderLayout.EAST);

        _okButton = new JButton("OK");
        _okButton.setEnabled(false);
        buttonPanel.add(_okButton, BorderLayout.WEST);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        return dialog;
    }

    /**
     * gibt den AbbruchButton zurück
     */
    public JButton getAbbruchButton()
    {
        return _abbruchButton;
    }

    /**
     * gibt den OKButton zurück
     */
    public JButton getOkButton()
    {
        return _okButton;
    }

    /**
     * gibt das Textfeld mit dem zu zahlenden Betrag zurück
     */
    public JTextField getZuZahlen()
    {
        return _zuZahlen;
    }

    /**
     *  gibt das Textfeld mit dem bereits bezahlten Betrag zurück
     */
    public JTextField getBezahlt()
    {
        return _bezahlt;
    }

    /**
     * setzt den noch zu zahlenden Betrag als Text in das entsprechende Textfeld
     * @param preis
     */
    public void setZuZahlen(int preis)
    {
        _zuZahlen.setText(String.valueOf(preis));
    }

    /**
     * setzt den Restbetrag als Text in das entsprechende Textfeld
     * @param rest
     */
    public void setRestBetrag(int rest)
    {
        _restgeld.setText(String.valueOf(rest));
    }

    /**
     * gibt den noch zu zahlenden Betrag als int zurück
     * @return den zu zahlenden Betrag
     */
    public int getZuZahlenBetrag()
    {
        return Integer.parseInt(_zuZahlen.getText());
    }

    /**
     * gibt den bereits bezahlten Betrag als int zurück
     * @return den bereits bezahlten Betrag
     */
    public int getBezahltBetrag()
    {
        return Integer.parseInt(_bezahlt.getText());
    }

    /**
     * gibt den Dialog zurück
     */
    public JDialog getDialog()
    {
        return _dialog;
    }
}
