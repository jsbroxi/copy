
package examples.party;


import java.awt.*;
import javax.swing.*;
import java.beans.*;
import javax.swing.event.*;
import java.awt.event.*;

import jade.core.behaviours.OneShotBehaviour;



public class HostUIFrame
    extends JFrame
{
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel pnl_main = new JPanel();
    JButton btn_Exit = new JButton();
    Component component3;
    JButton btn_stop = new JButton();
    Component component2;
    JButton btn_start = new JButton();
    Box box_buttons;
    JPanel pnl_numGuests = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JLabel lbl_numGuests = new JLabel();
    Box box_numGuests;
    JLabel lbl_guestCount = new JLabel();
    JSlider slide_numGuests = new JSlider();
    Component component1;
    Component component4;
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel lbl_numIntroductions = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel lbl_partyState = new JLabel();
    Box box1;
    JProgressBar prog_rumourCount = new JProgressBar();
    Component component6;
    Component component5;
    JLabel jLabel3 = new JLabel();
    JLabel lbl_rumourAvg = new JLabel();


    protected HostAgent m_owner;


    public HostUIFrame( HostAgent owner ) {
        try {
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        m_owner = owner;
    }


    private void jbInit() throws Exception {
        component3 = Box.createHorizontalStrut(10);
        component2 = Box.createHorizontalStrut(5);
        box_buttons = Box.createHorizontalBox();

        box_numGuests = Box.createHorizontalBox();
        component1 = Box.createGlue();
        component4 = Box.createHorizontalStrut(5);
        box1 = Box.createVerticalBox();
        component6 = Box.createGlue();
        component5 = Box.createGlue();
        this.getContentPane().setLayout(borderLayout1);
        pnl_main.setLayout(gridLayout1);
        btn_Exit.setText("Exit");
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Exit_actionPerformed(e);
            }
        });
        btn_stop.setEnabled(false);
        btn_stop.setText("Stop");
        btn_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_stop_actionPerformed(e);
            }
        });
        btn_start.setText("Start");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_start_actionPerformed(e);
            }
        });
        this.setTitle("Party Host Agent");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                this_windowClosing(e);
            }
        });
        pnl_numGuests.setLayout(borderLayout3);
        lbl_numGuests.setText("No. of guests:");
        lbl_guestCount.setMaximumSize(new Dimension(30, 17));
        lbl_guestCount.setMinimumSize(new Dimension(30, 17));
        lbl_guestCount.setPreferredSize(new Dimension(30, 17));
        lbl_guestCount.setText("10");
        slide_numGuests.setValue(10);
        slide_numGuests.setMaximum(1000);
        slide_numGuests.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                slide_numGuests_stateChanged(e);
            }
        });
        gridLayout1.setRows(4);
        gridLayout1.setColumns(2);
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("Party state: ");
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("No. of introductions: ");
        lbl_numIntroductions.setBackground(Color.white);
        lbl_numIntroductions.setText("0");
        jLabel4.setToolTipText("");
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("Guests who have heard rumour: ");
        lbl_partyState.setBackground(Color.white);
        lbl_partyState.setText("Not started");
        prog_rumourCount.setForeground(new Color(0, 255, 128));
        prog_rumourCount.setStringPainted(true);
        jLabel3.setToolTipText("");
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Avg. intros per rumour: ");
        lbl_rumourAvg.setToolTipText("");
        lbl_rumourAvg.setText("0.0");
        this.getContentPane().add(pnl_main, BorderLayout.CENTER);
        pnl_main.add(jLabel1, null);
        pnl_main.add(lbl_partyState, null);
        pnl_main.add(jLabel2, null);
        pnl_main.add(lbl_numIntroductions, null);
        pnl_main.add(jLabel4, null);
        pnl_main.add(box1, null);
        box1.add(component5, null);
        box1.add(prog_rumourCount, null);
        box1.add(component6, null);
        pnl_main.add(jLabel3, null);
        pnl_main.add(lbl_rumourAvg, null);
        this.getContentPane().add(pnl_numGuests, BorderLayout.NORTH);
        pnl_numGuests.add(box_numGuests, BorderLayout.CENTER);
        pnl_numGuests.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder( 2, 2, 2, 2 ) ) );

        box_numGuests.add(lbl_numGuests, null);
        box_numGuests.add(slide_numGuests, null);
        box_numGuests.add(lbl_guestCount, null);
        this.getContentPane().add(box_buttons, BorderLayout.SOUTH);
        box_buttons.add(component2, null);
        box_buttons.add(btn_start, null);
        box_buttons.add(component3, null);
        box_buttons.add(btn_stop, null);
        box_buttons.add(component1, null);
        box_buttons.add(btn_Exit, null);
        box_buttons.add(component4, null);
        lbl_partyState.setForeground( Color.black );
        lbl_numIntroductions.setForeground( Color.black );
        lbl_rumourAvg.setForeground( Color.black );
    }


   
    void slide_numGuests_stateChanged(ChangeEvent e) {
        lbl_guestCount.setText( Integer.toString( slide_numGuests.getValue() ) );
    }


    void btn_start_actionPerformed(ActionEvent e) {
        enableControls( true );

       
        m_owner.addBehaviour( new OneShotBehaviour() {
                                  public void action() {
                                      ((HostAgent) myAgent).inviteGuests( slide_numGuests.getValue() );
                                  }
                              } );
    }


    
    void btn_stop_actionPerformed(ActionEvent e) {
        enableControls( false );

       
        m_owner.addBehaviour( new OneShotBehaviour() {
                                  public void action() {
                                      ((HostAgent) myAgent).endParty();
                                  }
                              } );
    }


    void enableControls( boolean starting ) {
        btn_start.setEnabled( !starting );
        btn_stop.setEnabled( starting );
        slide_numGuests.setEnabled( !starting );
        btn_Exit.setEnabled( !starting );
    }


   
    void btn_Exit_actionPerformed(ActionEvent e) {
        m_owner.addBehaviour( new OneShotBehaviour() {
                                  public void action() {
                                      ((HostAgent) myAgent).terminateHost();
                                  }
                              } );
    }


   
    void this_windowClosing(WindowEvent e) {
        
        btn_Exit_actionPerformed( null );
    }


}


