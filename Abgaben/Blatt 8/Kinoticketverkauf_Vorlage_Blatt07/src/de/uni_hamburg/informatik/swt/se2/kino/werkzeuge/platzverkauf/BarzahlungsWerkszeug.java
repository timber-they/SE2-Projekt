package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Mit diesem Werkzeug kann eine Barzahlung durchgeführt werden.
 * Dieses Werkzeug ist ein eingebettetes Subwerkzeug
 * @author torevonschwartz
 *
 */
public class BarzahlungsWerkszeug
{
    //Die UI des Werkzeuges
    private BarzahlungsWerkzeugUI _ui;
    //Der Preis der gewählten Plätze
    private int _preis;
    //Das Platzverkaufswerkzeug, das die Bezahlung anfordert
    private PlatzVerkaufsWerkzeug _platzVerkaufsWerkzeug;

    /**
     * Initialisiere das Werkzeug
     * @param preis
     */
    public BarzahlungsWerkszeug(int preis, PlatzVerkaufsWerkzeug pvw)
    {
        _ui = new BarzahlungsWerkzeugUI();
        _preis = preis;
        _ui.setZuZahlen(preis);
        registriereUIAktionen();
        _platzVerkaufsWerkzeug = pvw;
        _ui.show();
    }

    /**
     * Fügt der UI die Funktionalitäten mit entsprechenden Listenern hinzu
     */
    void registriereUIAktionen()
    {
        _ui.getAbbruchButton()
            .addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    _ui.getDialog()
                        .dispose();
                }
            });

        _ui.getOkButton()
            .addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    _platzVerkaufsWerkzeug.registriereBarzahlung();
                    _ui.getDialog()
                        .dispose();
                }
            });

        _ui.getBezahlt()
            .addKeyListener(new KeyListener()
            {

                @Override
                public void keyTyped(KeyEvent e)
                {

                }

                @Override
                public void keyPressed(KeyEvent e)
                {

                }

                @Override
                public void keyReleased(KeyEvent e)
                {
                    if (_ui.getBezahlt()
                        .getText()
                        .matches("\\d*")
                            && !_ui.getBezahlt()
                                .getText()
                                .isEmpty())
                    {
                        _ui.setRestBetrag(_ui.getBezahltBetrag()
                                - _ui.getZuZahlenBetrag());

                        if (_ui.getBezahltBetrag() >= _ui.getZuZahlenBetrag())
                        {
                            enableDisableOkButton(true);
                        }
                        else
                        {
                            enableDisableOkButton(false);
                        }

                    }
                    else
                    {
                        enableDisableOkButton(false);

                    }

                }

            });
    }

    /**
     * ändert die Benutzbarkeit des OKButtons der UI
     * @param enable
     */
    public void enableDisableOkButton(boolean enable)
    {
        _ui.getOkButton()
            .setEnabled(enable);
    }
}
